package com.lwl.service;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Book;

public interface BookService {

    /**
     * 查询书籍列表 以分页
     * @return 书籍信息
     */
    PageInfo<Book> queryAllBooks(Integer pageNum,Integer pageSize);

    /**
     * 多条件查询书籍信息 分页
     * @return 书籍信息
     */
    PageInfo<Book> queryBooksByBookNameOrAuthor(Integer pageNum,Integer pageSize,String bookName,String author);

    /**
     *  查询一本书籍通过id
     * @return 书籍信息
     */
    Book queryOneBookById(String id);

    /**
     * 管理员添加图书
     * @return ok
     */
    int adminAddBook(String id,String bookName,String author,String number);

    /**
     * 管理员修改图书
     * @return ok
     */
    int adminUpdateBook(String id,String bookName,String author,String number);

    /**
     * 删除图书信息
     * @param id id
     * @return ok
     */
    int adminDelBook(String id);


}
