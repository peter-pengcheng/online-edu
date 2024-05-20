package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */

public interface CourseCategoryService {

    /**
     * 课程分类树形结构查询
     *
     * @return
     */
     List<CourseCategoryTreeDto> queryTreeNodes(String id);
}
