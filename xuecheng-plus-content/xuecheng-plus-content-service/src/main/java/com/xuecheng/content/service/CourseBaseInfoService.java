package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */
public interface CourseBaseInfoService extends IService<CourseBase> {

//课程分页查询
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    /**
     * 新增课程信息
     * @param companyIn 后面实现单点登录 从localtread中获取
     * @param addCourseDto
     */
    CourseBaseInfoDto createCourseBase(Long companyIn, AddCourseDto addCourseDto);
}
