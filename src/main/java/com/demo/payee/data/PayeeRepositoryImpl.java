package com.demo.payee.data;

import com.demo.payee.data.dao.PayeeDao;
import com.demo.payee.data.persistent_entity.PayeeEntity;
import com.demo.payee.domain.model.AddPayee;
import com.demo.payee.domain.model.BankInfo;
import com.demo.payee.domain.model.Payee;
import com.demo.payee.domain.repository.PayeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PayeeRepositoryImpl implements PayeeRepository {

    private final PayeeDao payeeDao;

    @Override
    public Payee addPayee(AddPayee addPayee) {
        PayeeEntity payeeEntity = payeeDao.save(toPayeeEntity(addPayee));
        Payee newPayee = Payee.builder().id(payeeEntity.getPayeeId())
                .name(addPayee.getName())
                .mobile(addPayee.getMobile())
                .bankInfo(addPayee.getBankInfo())
                .build();
        return newPayee;
    }

    @Override
    public Payee getPayee(UUID payeeId) {
        return toPayee(payeeDao.findById(payeeId).orElse(null));
    }

    @Override
    public List<Payee> getPayees() {
        return payeeDao.findAll().stream().map(payeeEntity -> toPayee(payeeEntity)).collect(Collectors.toList());
    }

    private PayeeEntity toPayeeEntity(AddPayee addPayee) {
        return PayeeEntity.builder().payeeId(UUID.randomUUID())
                .payeeName(addPayee.getName())
                .mobileNum(addPayee.getMobile())
                .accountNum(addPayee.getBankInfo().getAccountNumber())
                .routingNum(addPayee.getBankInfo().getRoutingNumber())
                .build();
    }

    private Payee toPayee(PayeeEntity payeeEntity) {
        if (payeeEntity == null)
            return null;
        return Payee.builder().id(payeeEntity.getPayeeId())
                .name(payeeEntity.getPayeeName())
                .mobile(payeeEntity.getMobileNum())
                .bankInfo(BankInfo.builder().accountNumber(payeeEntity.getAccountNum()).routingNumber(payeeEntity.getRoutingNum()).build())
                .build();
    }
}
