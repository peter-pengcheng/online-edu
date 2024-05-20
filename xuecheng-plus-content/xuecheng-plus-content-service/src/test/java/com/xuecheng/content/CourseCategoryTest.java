package com.xuecheng.content;


import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.model.po.CourseCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Peter
 * @Date: 2024/5/16
 */

@SpringBootTest
@Slf4j
public class CourseCategoryTest {


    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @Test
    void courseBasePagination(){

        List<CourseCategoryTreeDto> categoryTreeDtos=this.courseCategoryMapper.selectTreeNodes();


        List<CourseCategoryTreeDto> cateforyList= categoryTreeDtos.stream().filter(t -> t.getParentid().equals("1")).peek(t->t.setChildrenTreeNodes(findNode(t,categoryTreeDtos))).collect(Collectors.toList());



    }


    private List<CourseCategory> findNode(CourseCategoryTreeDto courseCategoryTreeDto, List<CourseCategoryTreeDto> categoryTreeDtos){
        return categoryTreeDtos.stream().filter(t->t.getParentid().equals(courseCategoryTreeDto.getId()))
                .peek(t->t.setChildrenTreeNodes(findNode(t,categoryTreeDtos))).collect(Collectors.toList());
    }

}
