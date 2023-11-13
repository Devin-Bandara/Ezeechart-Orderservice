package ead.project.orderservice.repository;

import ead.project.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
//import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends JpaRepository<Order,Long> {
    //entity and long primary key

}
