package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */

@Api(value = "课程分类接口",tags = "课程分类接口")
@RestController
public class CourseCategoryController {


    @ApiOperation("课程分类树形查询接口")
    @GetMapping("/course-category/tree-nodes")
    public List<CourseCategoryTreeDto> list() {

        return null ;

    }


}
