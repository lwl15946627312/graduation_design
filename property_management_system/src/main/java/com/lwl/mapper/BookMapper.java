package com.lwl.mapper;

import com.lwl.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    /**
     * 查询书籍列表
     * @return 书籍信息
     */
    List<Book> queryAllBooks();

    /**
     * 多条件查询书籍信息
     * @return 书籍信息
     */
    List<Book> queryBooksByBookNameOrAuthor(String bookName,String author);

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
