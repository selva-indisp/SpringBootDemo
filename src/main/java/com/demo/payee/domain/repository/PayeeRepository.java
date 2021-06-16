package com.demo.payee.domain.repository;

import com.demo.payee.domain.model.AddPayee;
import com.demo.payee.domain.model.Payee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PayeeRepository {
    Payee addPayee(AddPayee addPayee);
    Payee getPayee(UUID payeeId);
    List<Payee> getPayees();
}
