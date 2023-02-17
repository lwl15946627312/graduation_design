package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.BookMapper;
import com.lwl.pojo.Book;
import com.lwl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    /**
     * 分页查询所有书籍
     * @return 书籍信息
     */
    @Override
    public PageInfo<Book> queryAllBooks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.queryAllBooks();
        PageInfo<Book> bookPageInfo = new PageInfo<>(books);
        return bookPageInfo;
    }

    /**
     * 多条件查询所有书籍
     * @return 书籍信息
     */
    @Override
    public PageInfo<Book> queryBooksByBookNameOrAuthor(Integer pageNum, Integer pageSize, String bookName, String author) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.queryBooksByBookNameOrAuthor(bookName, author);
        PageInfo<Book> bookPageInfo = new PageInfo<>(books);
        return bookPageInfo;
    }

    /**
     * 查找一本书籍信息
     * @return 书籍信息
     */
    @Override
    public Book queryOneBookById(String id) {
        return bookMapper.queryOneBookById(id);
    }

    /**
     * 管理员添加信息
     * @return ok
     */
    @Override
    public int adminAddBook(String id, String bookName, String author, String number) {
        return bookMapper.adminAddBook(id,bookName,author,number);
    }

    /**
     * 管理员修改信息
     * @return ok
     */
    @Override
    public int adminUpdateBook(String id, String bookName, String author, String number) {
        return bookMapper.adminUpdateBook(id,bookName,author,number);
    }

    /**
     * 管理员删除信息
     * @return ok
     */
    @Override
    public int adminDelBook(String id) {
        return bookMapper.adminDelBook(id);
    }
}
