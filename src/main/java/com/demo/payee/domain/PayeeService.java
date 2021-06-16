package com.demo.payee.domain;

import com.demo.payee.domain.model.AddPayee;
import com.demo.payee.domain.model.Payee;

import java.util.List;
import java.util.UUID;

public interface PayeeService {

    Payee addPayee(AddPayee payee);

    Payee getPayee(UUID payeeId);

    List<Payee> getPayees();
}
