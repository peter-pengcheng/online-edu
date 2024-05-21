package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.model.po.CourseCategory;
import com.xuecheng.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */

@Service
@Slf4j
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        // 调用mapper 查询分类信息
        List<CourseCategoryTreeDto> categoryTreeDtos=this.courseCategoryMapper.selectTreeNodes();
        List<CourseCategoryTreeDto> cateforyList= categoryTreeDtos.stream().
                filter(t -> t.getParentid().equals(id)).
                peek(t->
                        {
                            List<CourseCategory> node = findNode(t, categoryTreeDtos);
                            if(node.size()>0){t.setChildrenTreeNodes(node);}
                            else{t.setChildrenTreeNodes(null);}
                        }
                ).
                collect(Collectors.toList());

        return cateforyList;
    }

    private List<CourseCategory> findNode(CourseCategoryTreeDto courseCategoryTreeDto, List<CourseCategoryTreeDto> categoryTreeDtos){
        return categoryTreeDtos.stream().
                filter(t->t.getParentid().equals(courseCategoryTreeDto.getId()))
                .peek(t->{
                    List<CourseCategory> node = findNode(t, categoryTreeDtos);
                    if(node.size()>1){t.setChildrenTreeNodes(node);}
                    else{t.setChildrenTreeNodes(null);}
                }).
                collect(Collectors.toList());
    }

}
