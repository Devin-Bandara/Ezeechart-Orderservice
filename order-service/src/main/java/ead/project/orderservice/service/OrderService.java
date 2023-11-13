package ead.project.orderservice.service;
import ead.project.orderservice.model.OrderLineItems;
import ead.project.orderservice.dto.OrderLineItemsDto;
import ead.project.orderservice.dto.OrderRequest;
import ead.project.orderservice.model.Order;
import ead.project.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.util.stream.Collectors;

import java.util.UUID;
import java.util.List;

@Service//identify the service layer
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;//inject the orderLineItems to repo

    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();//creating a new order entity
        order.setOrderNumber(UUID.randomUUID().toString());//random number assignment to order

       List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this ::mapToDto)
                .toList();
       //4 id will include 4 and 5
        //maps the OrderLineItemsDto list to OrderLineItems entities

       order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);//in built function of sql

    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        //dto putting the data to the real table
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }

    public void deleteOrder(Long orderId){

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }

}
