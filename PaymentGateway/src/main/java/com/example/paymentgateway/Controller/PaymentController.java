package com.example.paymentgateway.Controller;

import com.example.paymentgateway.PaymentOrder;
import com.example.paymentgateway.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/create-order")
    public ResponseEntity<String>creatOrder(@RequestBody PaymentOrder order){
 try {
      String response = paymentService.createOrder(order);
      return  ResponseEntity.ok(response);
 }
 catch (Exception e){
     return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order");
 }
    }
@PostMapping("/update-order")
public ResponseEntity<String>updateOrderStatus(@RequestParam String paymentId,
                                            @RequestParam String orderId,
                                           @RequestParam String status)
{
    paymentService.updateOrderStatus(paymentId, orderId, status);
    System.out.println("Order place successfully");
    return ResponseEntity.ok("Order place successfully");


}}

