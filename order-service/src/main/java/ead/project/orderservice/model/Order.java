package ead.project.orderservice.model;
//used to store orders

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity//class convert sql tables
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor//auto created using lombok
public class Order {
    @Id// primary key id for the order
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long userID;
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)//join the table order and orderLineItems
    private List<OrderLineItems> orderLineItemsList;//each order contains list of orders

}
