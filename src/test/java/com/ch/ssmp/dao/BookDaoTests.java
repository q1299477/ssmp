package com.ch.ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ch.ssmp.domain.Book;

@SpringBootTest
class BookDaoTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void selectbyid() {
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void insertbyid() {
        Book book1=new Book();
        book1.setName("李东阳");
        book1.setType("学习资料");
        book1.setDescription("asd");
        bookDao.insert(book1);
    }

    @Test
    void selectlist() {
        QueryWrapper<Book> wrapper=new QueryWrapper<>();
        wrapper.like("name","Spring");
        bookDao.selectList(wrapper);
    }
    @Test
    //lanmda查询
    void selectlist2() {
        String name = null;
        LambdaQueryWrapper<Book> wrapper=new LambdaQueryWrapper<>();
//        if (name!=null)
//            wrapper.like(Book::getName,name);
        //或
        wrapper.like(name!=null,Book::getName,name);
        bookDao.selectList(wrapper);
    }
    //分页
    @Test
    void selectpage(){
        IPage page=new Page(1,3);
        bookDao.selectPage(page,null);
    }

}
