package com.xuecheng.content;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        List<CourseCategoryTreeDto> courseCategoryTreeDtoList =courseCategoryMapper.selectTreeNodes("1");
        System.out.println("courselist"+ courseCategoryTreeDtoList);


    }


}
