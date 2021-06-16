package com.demo.payee.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddPayee {
    private String name;
    private String mobile;
    private BankInfo bankInfo;
}
