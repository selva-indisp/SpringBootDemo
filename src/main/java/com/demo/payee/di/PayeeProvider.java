package com.demo.payee.di;

import com.demo.payee.domain.PayeeServiceImpl;
import com.demo.payee.domain.PayeeService;
import com.demo.payee.domain.TestPayeeServiceImpl;
import com.demo.payee.domain.repository.PayeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayeeProvider {

    @Bean
    public PayeeService payeeService(PayeeRepository payeeRepository) {
        return new PayeeServiceImpl(payeeRepository);
    }

    @Bean
    public PayeeService payeeService2() {
        return new TestPayeeServiceImpl();
    }
}
