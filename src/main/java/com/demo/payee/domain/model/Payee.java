package com.demo.payee.domain.model;

import lombok.*;
import java.util.UUID;

@Data
@Builder
public class Payee {
    private UUID id;
    private String name;
    private String mobile;
    private BankInfo bankInfo;
}
