package com.example.study.repository;

import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Rollback(value = false)
    public void create() throws Exception{
        //given
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");

        //when
        Item saveItem = itemRepository.save(item);

        //then
        assertNotNull(saveItem);
    }

    @Test
    public void read() throws Exception{
        //given
        Long id = 1L;

        //when
        Optional<Item> item = itemRepository.findById(id);

        //then
        assertTrue(item.isPresent());
    }

}