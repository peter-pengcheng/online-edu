package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.CourseCategory;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 * 树形数据结构的模型类
 */
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {

    List<CourseCategory> childrenTreeNodes;


}
