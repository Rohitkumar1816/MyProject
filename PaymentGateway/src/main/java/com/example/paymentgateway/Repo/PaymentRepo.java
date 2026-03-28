package com.example.paymentgateway.Repo;

import com.example.paymentgateway.PaymentOrder;
import com.razorpay.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo  extends JpaRepository<PaymentOrder, Long> {
    PaymentOrder findByOrderId(String orderNumber);
}
