//package mvc.controller;
//import mvc.entity.RESTBook;
//import mvc.repository.RESTBookRepositiry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.springframework.web.bind.annotation.RequestMethod.GET;
//
//@RestController
//@RequestMapping(value = "/book")
//public class RestBookController {
//    //    @Autowired
////    BookCategory bookCategory;
////
////    @Autowired
////    CategoryRepository categoryRepository;
////
////    @RequestMapping(value = "/rest-book", method = GET)
////    public String getListBook(Model model){
////        List<BookEntity> bookList = (List<BookEntity>) bookCategory.findAll();
////        model.addAttribute("bookList", bookList);
////        return "book/home";
////    }
//    @Autowired
//    BookRestRepository bookRestRepository;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public Object getAllBook(){
//        List<RESTBook> bookRestEntityList = bookRestRepository.findAll();
//        return bookRestEntityList;
//    }
//
//    //add
//    @RequestMapping(method = RequestMethod.POST)
//    public Object addNewBook(@RequestBody RESTBook newBookRestEntity){
//        RESTBook result = bookRestRepository.save(newBookRestEntity);
//        return result;
//    }
//
//    //update
//    @RequestMapping(method = RequestMethod.PUT)
//    public Object updateBook(@RequestBody RESTBook updateBookRestEntity){
//        RESTBook result = bookRestRepository.update(updateBookRestEntity);
//        if(result == null){
//            Map<String, String> error = new HashMap<String, String>(){{
//                put("error", updateBookRestEntity.getId() + " does not exist");
//            }};
//            return error;
//        }
//        return result;
//    }
//
//    //delete
//    @RequestMapping(value = "/{bookRestID}", method = RequestMethod.DELETE)
//    public Object deleteBook(@PathVariable(value = "bookRestID")String bookRestID){
//        boolean result = bookRestRepository.delete(Integer.valueOf(bookRestID));
//        if(!result){
//            Map<String, String> error = new HashMap<String, String>(){{
//                put("error","A book which book ID = "+ bookRestID + " does not exist");
//            }};
//            return error;
//        }else {
//            Map<String, String> success = new HashMap<String, String>(){{
//                put("success","A book which book ID = "+ bookRestID + " has been delete successfully");
//            }};
//            return success;
//        }
//    }
//}
