package mvc.controller;

import mvc.entity.Products;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
            cartList.removeIf(cartItem -> cartItem.getProducts().getId() == productId);
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


}