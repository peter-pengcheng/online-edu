package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */
@Service
@Slf4j
public class CourseBaseInfoServiceImpl extends ServiceImpl<CourseBaseMapper,CourseBase> implements CourseBaseInfoService  {

    @Autowired
    CourseBaseMapper courseBaseMapper;

    /**
     * 课程分页查询
     * @param pageParams 分页查询参数
     * @param queryCourseParamsDto 查询参数
     * @return 返回结果
     */
    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto) {

        //构建page对象 用于拼接page的语句
        Page<CourseBase> page=new Page<>(pageParams.getPageNo(),pageParams.getPageSize());
        //构建条件查询器
        LambdaQueryWrapper<CourseBase> lambdaQueryWrapper=new LambdaQueryWrapper<>();

        lambdaQueryWrapper.like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()),CourseBase::getName,queryCourseParamsDto.getCourseName())
                        .eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus());

        Page<CourseBase> pages = courseBaseMapper.selectPage(page, lambdaQueryWrapper);

        return new PageResult<>(pages.getRecords(),pages.getTotal(),pages.getPages(),pages.getSize());



    }


}
