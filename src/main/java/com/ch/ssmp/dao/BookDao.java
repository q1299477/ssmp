package com.ch.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import com.ch.ssmp.domain.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
