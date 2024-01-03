package mvc.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mvc.entity.Orderdetails;
import java.util.List;

@Repository
public interface OrderDetailsRepository extends CrudRepository<Orderdetails, Integer> {
    List<Orderdetails> findAll();

}