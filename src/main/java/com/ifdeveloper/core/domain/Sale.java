package com.ifdeveloper.core.domain;

import com.ifdeveloper.core.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

    private Long idOperation;

    private Long idClient;

    private Integer quantity;

    private BigDecimal totalAmount;

    private PaymentMethod paymentMethod;

}
