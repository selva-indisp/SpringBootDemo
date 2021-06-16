package com.demo.payee.domain;

import com.demo.payee.domain.model.AddPayee;
import com.demo.payee.domain.model.BankInfo;
import com.demo.payee.domain.model.Payee;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestPayeeServiceImpl implements PayeeService {

    private Logger logger = LoggerFactory.getLogger(TestPayeeServiceImpl.class.getSimpleName());

    @Override
    public Payee addPayee(AddPayee payee) {
        throw new RuntimeException("Method is not supported");
    }

    @Override
    public Payee getPayee(UUID payeeId) {
        throw new RuntimeException("Method is not supported");
    }

    @Override
    public List<Payee> getPayees() {
        logger.debug("TestPayeeServiceImpl - getPayees");
        BankInfo bankInfo = BankInfo.builder().accountNumber("2011504567").routingNumber("RNR999009").build();
        Payee payee1 = Payee.builder().id(UUID.randomUUID())
                .name("Selvakumar")
                .mobile("123456789")
                .bankInfo(bankInfo)
                .build();
        Payee payee2 = Payee.builder().id(UUID.randomUUID())
                .name("Selvakumar Mohan")
                .mobile("987654321")
                .bankInfo(bankInfo)
                .build();

        return Arrays.asList(payee1, payee2);
    }
}
