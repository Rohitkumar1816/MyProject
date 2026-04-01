package com.example.paymentgateway.Repo;

import com.example.paymentgateway.Entity.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo  extends JpaRepository<PaymentOrder, Long> {
    PaymentOrder findByOrderId(String orderNumber);
//    List<PaymentOrder> orders = paymentRepo.findAllByEmailAndStatus(  email, "SUCCESS");

    List<PaymentOrder> findAllByEmailAndStatus(String email, String success);
}
