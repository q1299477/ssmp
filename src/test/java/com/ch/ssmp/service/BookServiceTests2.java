package com.ch.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTests2 {
    @Autowired
    private IBookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(3));
    }
    @Test
    void getpage(){
        IPage<Book> page=new Page<>(1,3);
        System.out.println(bookService.page(page));
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
    }
}
