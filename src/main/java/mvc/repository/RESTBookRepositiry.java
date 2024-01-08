//package mvc.repository;
//
//import mvc.entity.RESTBook;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class RESTBookRepositiry {
//    private List<RESTBook> bookRestEntityList = new ArrayList<>();
//
//    @PostConstruct
//    public void init(){
//        bookRestEntityList.add(new RESTBook(1, "Java A-Z", 13.2, "Roger"));
//        bookRestEntityList.add(new RESTBook(2, ".Net tutorial", 23.9, "Peter"));
//    }
//
//    public List<RESTBook> findAll(){
//        return bookRestEntityList;
//    }
//
//    //add
//    public  RESTBook save(RESTBook bookRestEntity){
//        bookRestEntityList.add(bookRestEntity);
//        return bookRestEntity;
//    }
//
//    //update
//    public RESTBook update(RESTBook newBookRestData){
//        boolean isFound = false;
//        RESTBook foundBookRest = null;
//
//        for(RESTBook bookRest: bookRestEntityList){
//            if(bookRest.getId() == newBookRestData.getId()){
//                isFound = true;
//                foundBookRest = bookRest;
//                break;
//            }
//        }
//        if (!isFound){
//            return null;
//        }
//
//        bookRestEntityList.remove(foundBookRest);
//        newBookRestData.setId((foundBookRest.getId()));
//        bookRestEntityList.add(newBookRestData);
//        return  newBookRestData;
//    }
//
//    //delete
//    public boolean delete(int bookRestID){
//        boolean isFound = false;
//        RESTBook foundBookRest = null;
//
//        for(RESTBook bookRest: bookRestEntityList){
//            if(bookRest.getId() == bookRestID){
//                isFound = true;
//                foundBookRest = bookRest;
//                break;
//            }
//        }
//        if (!isFound){
//            return false;
//        }
//
//        bookRestEntityList.remove(foundBookRest);
//        return true;
//    }
//}