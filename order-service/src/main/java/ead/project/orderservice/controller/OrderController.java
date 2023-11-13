package ead.project.orderservice.controller;
//end point
import ead.project.orderservice.dto.OrderRequest;
import ead.project.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;//Import lombok
import org.springframework.http.HttpStatus;//HttpStatus
import org.springframework.web.bind.annotation.*;//import request mapping annotations

@RestController//marks this as a REST controller
@RequestMapping("/api/order")
@RequiredArgsConstructor//lombok annotation to generate constructor
public class OrderController {
    private final OrderService orderService;
    // Handle the HTTP POST request for order placement
    @PostMapping//maps POST requests to this method
    @ResponseStatus(HttpStatus.CREATED)//returns 201 status code
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);//Calls orderService.placeOrder - delegates to service layer
        return"order placed successfully";
    }
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return"order deleted successfully";
    }



}
