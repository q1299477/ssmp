package com.ch.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ch.ssmp.controller.utils.R;
import com.ch.ssmp.domain.Book;
import com.ch.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        R r=new R();
//        boolean flag=bookService.save(book);
//        r.setFlag(flag);
//        return r;

        //异常处理测试
        //if (book.getName().equals("123")) throw new IOException();

        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getpage(currentPage, pageSize);
//        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码
//        if (currentPage>page.getPages()){
//            page = bookService.getpage((int)page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        IPage<Book> page = bookService.getpage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码
        if (currentPage>page.getPages()){
            page = bookService.getpage((int)page.getPages(), pageSize,book);
        }
        return new R(null!=page, page);
    }
}
