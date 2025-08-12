package com.shopping.order.controller;

import com.shopping.order.entity.Cart;
import com.shopping.order.request.CartResponse;
import com.shopping.order.request.OrderRequest;
import com.shopping.order.service.OrderService;
import com.shopping.order.validators.OrderRequestValidator;
import com.shopping.order.validators.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;
    private final OrderRequestValidator orderRequestValidator;
    private final Logger logger = LogManager.getLogger(OrderController.class);

    public OrderController(OrderService orderService, OrderRequestValidator orderValidator) {
        this.orderService = orderService;
        this.orderRequestValidator = orderValidator;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Cart>> getShoppingList(){
        try{
            return ResponseEntity.ok(this.orderService.getAllOrders());
        }catch (Exception e){
            logger.error("Error while getting orders", e);
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/orders")
    public ResponseEntity<CartResponse> addOrder(@RequestBody OrderRequest orderRequest){
        try{
            if(!orderRequestValidator.validate(orderRequest)){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(this.orderService.addOrder(orderRequest));
        } catch (Exception e) {
            logger.error("Error while adding order", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/orders")
    public ResponseEntity<Cart> updateOrder(@RequestBody OrderRequest orderRequest){
        try{
            return ResponseEntity.ok(this.orderService.updateOrder(orderRequest));
        } catch (Exception e) {
            logger.error("Error while adding order", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/orders")
    public ResponseEntity<Boolean> deleteOrder(@RequestBody OrderRequest orderRequest){
        try{
            return ResponseEntity.ok(this.orderService.deleteOrder(orderRequest));
        } catch (Throwable e) {
            logger.error("Error while deleting order", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
