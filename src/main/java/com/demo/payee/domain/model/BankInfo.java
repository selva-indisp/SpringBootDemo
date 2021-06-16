package com.demo.payee.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BankInfo {
    private String accountNumber;
    private String routingNumber;
}
