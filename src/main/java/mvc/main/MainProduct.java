package mvc.main;

import mvc.configuration.JPAConfig;
import mvc.entity.Products;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainProduct {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = context.getBean(OrderRepository.class);
    static OrderDetailsRepository orderDetailsRepository = context.getBean(OrderDetailsRepository.class);
    static ProductRepository productRepository = context.getBean(ProductRepository.class);

    public static void main(String[] args) {
        findAll();

    }

    public static void findAll(){
        List<Products> products= (List<Products>) productRepository.findAll();
        for(Products c: products){
            System.out.println(c.toString());
        }
    }

}
