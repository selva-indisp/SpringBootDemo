package com.demo.payee.data.dao;

import com.demo.payee.data.persistent_entity.PayeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PayeeDao extends JpaRepository<PayeeEntity, UUID> {
}
