package mvc.controller;

import mvc.entity.Orderdetails;
import mvc.entity.Orders;
import mvc.entity.Products;
import mvc.model.CartSession;
import mvc.model.Customer;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping(value = "/")
public class CartController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;


    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
        Products product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            // Lấy thông tin giỏ hàng từ session
            List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
            if (cartList == null) {
                cartList = new ArrayList<>();
            }

            // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
            boolean exists = false;
            for (CartSession cartItem : cartList) {
                if (cartItem.getProducts().getId() == productId) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                // Nếu sản phẩm chưa có trong giỏ hàng, thêm sản phẩm mới
                CartSession newCartItem = new CartSession(product, 1);
                cartList.add(newCartItem);
            }

            // Cập nhật giỏ hàng trong session
            session.setAttribute("cartList", cartList);
        }
        return "product/Cart";
    }

    @PostMapping("/removeFromCart/{productId}")
    public String removeFromCart(@PathVariable("productId") int productId, HttpSession session) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        if (cartList != null) {
            //cartList.removeIf(cartItem -> cartItem.getProducts().getId() == productId);
            for (CartSession cartSession : cartList){
                if(cartSession.getProducts().getId() == productId){
                    cartList.remove(cartSession);
                    break;
                }
            }
            session.setAttribute("cartList", cartList);
        }
        return "redirect:/myCart"; // Điều hướng người dùng đến trang giỏ hàng
    }


    @GetMapping("/myCart")
    public String viewCart(HttpSession session, Model model) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        model.addAttribute("cartList", cartList);
        return "product/Cart";
    }

    @GetMapping("/checkout")
    public String checkOut(HttpSession session, Model model) {
        model.addAttribute("customer", new Customer());
        return "product/Checkout";
    }

    @PostMapping("/checkout")
    public String saveOrder(HttpSession session, Customer customer, Model model) {
        // luu vao bang order
        Orders orders = new Orders();
        orders.setOrderDate(LocalDate.now());
        orders.setCustomerName(customer.getName());
        orders.setCustomerAddress(customer.getAddress());
        orderRepository.save(orders);
        //luu vao order detail


        //order detail lay data tu session

        List<CartSession> cartSessionList =(List<CartSession>) session.getAttribute("cartList");
        for(CartSession cartSession: cartSessionList){
            Orderdetails orderdetails = new Orderdetails();
            orderdetails.setOrder(orders);
            orderdetails.setProducts(cartSession.getProducts());
            orderdetails.setQuantity(cartSession.getQuantity());
            orderDetailsRepository.save(orderdetails);

        }
        // saU KHI LUU XONG ORDER THI XOA SESSION
        session.removeAttribute("cartList");
        //con order lay tu man hinh(name vs address)

        return "redirect:/myOrder";
    }

    @GetMapping("/myOrder")
    public String myOrder(HttpSession session, Model model) {
        List<Orders> ordersList = orderRepository.findAll();
        model.addAttribute("ordersList",ordersList);
        return "product/myOrder";
    }

    @GetMapping("/viewOrderDetails/{orderId}")
    public String viewOrderDetails(@PathVariable("orderId") int orderId, Model model) {
        Orders orders = orderRepository.findById(orderId);
        List<Orderdetails> orderdetailsList = orders.getOrderDetails();
        model.addAttribute("orderdetailsList",orderdetailsList);
        return "product/Orderdetails"; // Điều hướng người dùng đến trang giỏ hàng
    }






}