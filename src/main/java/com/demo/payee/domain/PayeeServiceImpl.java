package com.demo.payee.domain;

import com.demo.payee.domain.model.AddPayee;
import com.demo.payee.domain.model.Payee;
import com.demo.payee.domain.repository.PayeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PayeeServiceImpl implements PayeeService{

    private Logger logger = LoggerFactory.getLogger(PayeeServiceImpl.class.getSimpleName());
    private final PayeeRepository payeeRepository;

    @Override
    public Payee addPayee(AddPayee payee) {
        return payeeRepository.addPayee(payee);
    }

    @Override
    public Payee getPayee(UUID payeeId) {
        return payeeRepository.getPayee(payeeId);
    }

    @Override
    public List<Payee> getPayees() {
        logger.debug("PayeeServiceImpl - getPayees");
        return payeeRepository.getPayees();
    }
}
