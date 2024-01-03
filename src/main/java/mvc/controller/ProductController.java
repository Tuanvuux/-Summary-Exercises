package mvc.controller;

import mvc.entity.Orders;
import mvc.entity.Products;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

// đánh dấu là một thành phần điều khiển cho việc quét thành phần của Spring.
@Controller
@RequestMapping(value = "/")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @RequestMapping(method = GET)
    public String showProduct(Model model){
        List<Products> productList = (List<Products>) productRepository.findAll();
        model.addAttribute("List",productList);
        return "product/ProductList";
    }



}
