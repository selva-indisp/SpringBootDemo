package com.demo.payee.controller.resource;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PayeeRequest {
    @ApiModelProperty(name = "Payee name", required = true)
    private String payeeName;
    @ApiModelProperty(name = "Payee mobile number without country code", required = true)
    private String mobileNumber;
    @ApiModelProperty(name = "Payee bank account number", required = true)
    private String bankAccountNumber;
    @ApiModelProperty(name = "Payee bank routing number", required = true)
    private String routingNumber;
}
