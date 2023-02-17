package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Book;
import com.lwl.service.impl.BookServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/toCheckAllBooks")
    public String toCheckAllBooks(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                  Model model){
        PageInfo<Book> bookPageInfo = bookService.queryAllBooks(pageNum, pageSize);
        Role.pageLocation = "/toCheckAllBooks";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",bookPageInfo);
        return "allBooks";
    }

    @GetMapping("/toAdminAddBookMessage")
    public String toAdminAddBookMessage(Model model){
        Role.utilsLogin(model);
        return "adminAddBook";
    }

    @PostMapping("adminAddBookMessage")
    public String adminAddBookMessage(Model model,String bookName,String author,String number){
        bookService.adminAddBook(Role.createUUID(),bookName,author,number);
        Role.utilsLogin(model);
        return "redirect:/toCheckAllBooks";
    }

    @RequestMapping("/adminCheckSomeBooks")
    public String adminCheckSomeBooks(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                      Model model,String bookName,String author){
        PageInfo<Book> bookPageInfo = bookService.queryBooksByBookNameOrAuthor(pageNum, pageSize, bookName, author);
        Role.pageLocation = "/adminCheckSomeBooks";
        model.addAttribute("studentPageInfo",bookPageInfo);
        Role.utilsLogin(model);
        return "allBooks";
    }

    @GetMapping("/adminToUpdateBookMessage/{id}")
    public String adminToUpdateBookMessage(@PathVariable("id") String id,Model model){
        Role.utilsLogin(model);
        Book book = bookService.queryOneBookById(id);
        model.addAttribute("book",book);
        return "adminUpdateBook";
    }

    @PostMapping("/adminUpdateBookMessage")
    public String adminUpdateBookMessage(Model model,String id,String bookName,String author,String number){
        bookService.adminUpdateBook(id,bookName,author,number);
        Role.utilsLogin(model);
        return "redirect:/toCheckAllBooks";
    }

    @GetMapping("/adminDelBookMessage/{id}")
    public String adminDelBookMessage(@PathVariable("id") String id,Model model){
        bookService.adminDelBook(id);
        Role.utilsLogin(model);
        return "redirect:/toCheckAllBooks";
    }

}
