package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */

@SpringBootTest
@Slf4j
public class CourseBaseServiceTest {


    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Test
    void courseBasePagination(){

        PageParams pageParams=new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(2L);

        QueryCourseParamsDto queryCourseParamsDto=new QueryCourseParamsDto();
        queryCourseParamsDto.setCourseName("java");

        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams, queryCourseParamsDto);
        System.out.println(courseBasePageResult);


    }


}
