package com.demo.payee.data.persistent_entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "PAYEE")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class PayeeEntity {
    @Id
    private UUID payeeId;
    @Column(name = "payee_name")
    private String payeeName;
    @Column(name = "mobile_num")
    private String mobileNum;
    @Column(name = "account_num")
    private String accountNum;
    @Column(name = "routing_num")
    private String routingNum;
}
