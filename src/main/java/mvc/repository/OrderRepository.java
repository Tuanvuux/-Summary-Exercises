package mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mvc.entity.Orders;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findAll();

    Orders findById(int id);


    List<Orders> findByCustomerName(String customerName);

    List<Orders> findByCustomerAddress(String customerAddress);

}