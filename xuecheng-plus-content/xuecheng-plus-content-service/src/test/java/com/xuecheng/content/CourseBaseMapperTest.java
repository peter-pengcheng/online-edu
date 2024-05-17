package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */

@SpringBootTest
@Slf4j
public class CourseBaseMapperTest {


    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Test
    void courseBasePagination(){

//        CourseBase courseBase = courseBaseMapper.selectById(18);
//        System.out.println(courseBase.toString());
//
//        Page<CourseBase> page=new Page<>(1,30);
//        Page<CourseBase> pages = courseBaseMapper.selectPage(page, new LambdaQueryWrapper<>());
//        List<CourseBase> records = pages.getRecords();
//        log.info("pages--"+records);

        // 创建构建where后的语句
        LambdaQueryWrapper<CourseBase> lambdaQueryWrapper=new LambdaQueryWrapper();

        // 构建条件语句
        QueryCourseParamsDto queryCourseParamsDto=new QueryCourseParamsDto();

        queryCourseParamsDto.setCourseName("java");

        // 根据课程名称模糊查询 以及 根据课程审核状态查询
        lambdaQueryWrapper
            .like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()),CourseBase::getName,queryCourseParamsDto.getCourseName())
            .eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus());

        //创建分页参数对象
        Page<CourseBase> page=new Page<>(1,10);

        Page<CourseBase> pages = courseBaseMapper.selectPage(page, lambdaQueryWrapper);


        PageResult pageResult=new PageResult(pages.getRecords(),
                pages.getTotal(),pages.getPages(),pages.getSize());

        log.info("pages-->"+pageResult);

    }


}
