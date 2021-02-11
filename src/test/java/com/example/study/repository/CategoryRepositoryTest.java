package com.example.study.repository;

import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void create() throws Exception{
        //given
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createAt = LocalDateTime.now();
        String createBy = "AdminServer";
        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createAt);
        category.setCreatedBy(createBy);

        //when
        Category saveCategory = categoryRepository.save(category);

        //then
        assertNotNull(saveCategory);
        assertEquals(saveCategory.getType(), type);
        assertEquals(saveCategory.getTitle(), title);

    }

    @Test
    public void read() throws Exception{
        String type = "COMPUTER";
        //given
        List<Category> findCategory = categoryRepository.findAllByType(type);
        //when
        for (Category category : findCategory) {
            System.out.println(category.getTitle());
            assertEquals(category.getType(), type);
        }
        //then
    }
}