package com.demo.payee.controller;

import com.demo.payee.controller.resource.PayeeRequest;
import com.demo.payee.controller.resource.PayeeResponse;
import com.demo.payee.domain.model.AddPayee;
import com.demo.payee.domain.model.BankInfo;
import com.demo.payee.domain.model.Payee;
import com.demo.payee.domain.PayeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PayeeController {

    private final PayeeService payeeService;
    private final Logger logger = LoggerFactory.getLogger(PayeeController.class);

    @PostMapping("/payees")
    @ApiOperation(value = "Add a new payee")
    public ResponseEntity<PayeeResponse> addPayee(@RequestBody PayeeRequest payeeRequest) {
        Payee addedPayee = payeeService.addPayee(toAddPayee(payeeRequest));
        return new ResponseEntity(toPayeeResponse(addedPayee), HttpStatus.CREATED);
    }

    @GetMapping("/payees")
    @ApiOperation(value = "Fetch all payees")
    public ResponseEntity<List<PayeeResponse>> getPayees() {
        logger.info("getPayees");
        List<PayeeResponse> payees = payeeService.getPayees().stream().map(payee -> toPayeeResponse(payee)).collect(Collectors.toList());
        return new ResponseEntity<>(payees, HttpStatus.OK);
    }

    @GetMapping("/payees/{payee-id}")
    @ApiOperation(value = "Fetch a particular payee")
    public ResponseEntity<PayeeResponse> getPayee(@ApiParam(value = "Unique id of the payee", required = true) @PathVariable("payee-id") String payeeId) {
        Payee payee = payeeService.getPayee(UUID.fromString(payeeId));
        if (payee != null) {
            return new ResponseEntity<>(toPayeeResponse(payee), HttpStatus.OK);
        }
        logger.warn(payeeId + "payee not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    private AddPayee toAddPayee(PayeeRequest payeeRequest) {
        BankInfo bankInfo = BankInfo.builder().accountNumber(payeeRequest.getBankAccountNumber())
                .routingNumber(payeeRequest.getRoutingNumber())
                .build();
        return AddPayee.builder().name(payeeRequest.getPayeeName())
                .mobile(payeeRequest.getMobileNumber())
                .bankInfo(bankInfo)
                .build();
    }

    private PayeeResponse toPayeeResponse(Payee payee) {
        return PayeeResponse.builder().payeeId(payee.getId())
                .payeeName(payee.getName())
                .mobileNumber(payee.getMobile())
                .bankAccountNumber(payee.getBankInfo().getAccountNumber())
                .routingNumber(payee.getBankInfo().getRoutingNumber()).build();
    }

}
