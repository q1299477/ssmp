package com.ch.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ch.ssmp.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getbyid(Integer id);
    List<Book> getAll();
    IPage<Book> getpage(int currentPage,int pageSize);
}
