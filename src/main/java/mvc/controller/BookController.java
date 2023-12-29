package mvc.controller;

import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(method = GET)
    public String showBook(Model model){
        List<BookEntity> bookList = (List<BookEntity>) bookRepository.findAll();
        System.out.println(bookList.isEmpty()+"Test");
        model.addAttribute("bookList", bookList);
        return "book/home";
    }

    @RequestMapping(value = "/search", method = GET)
    public String search(@RequestParam("searchInput") String searchInput, Model model){
        List<BookEntity> resultList;
        if(searchInput.isEmpty()){
            resultList = (List<BookEntity>) bookRepository.findAll();
        } else {
            resultList = bookRepository.findByNameOrAuthor(searchInput, searchInput);
        }
        model.addAttribute("bookList", resultList);
        return "book/home";
    }

    @RequestMapping(value = "/newBook", method = GET)
    public String showNewBook(Model model){
        model.addAttribute("book", new BookEntity());
        model.addAttribute("msg", "Add a new book");
        model.addAttribute("action", "newBook");

        setCategoryDropDownList(model);
        return "book/book";
    }

    @RequestMapping(value = "/newBook", method = POST, produces = "text/plain;charset=UTF-8")
    public String saveBook(BookEntity book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String showEditBook(Model model, @PathVariable int id){
        model.addAttribute("book", bookRepository.findById(id));
        model.addAttribute("msg", "update book information");
        model.addAttribute("type", "update");
        model.addAttribute("action", "/updateBook");

        setCategoryDropDownList(model);
        return "book/book";
    }

    @RequestMapping(value = "/updateBook", method = POST)
    public String updateBook(@ModelAttribute BookEntity book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteBook(@PathVariable int id){
//        bookCategory.delete(id);
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    private void setCategoryDropDownList(Model model){
        List<CategoryEntity> cateList = (List<CategoryEntity>) categoryRepository.findAll();
        if(!cateList.isEmpty()){
            Map<Integer,String> cateMap = new LinkedHashMap<>();
            for(CategoryEntity categoryEntity : cateList){
                cateMap.put(categoryEntity.getId(), categoryEntity.getName());
            }
            model.addAttribute("categoryList", cateMap);
        }
    }
}