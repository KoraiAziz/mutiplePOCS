package com.anb.pocs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anb.pocs.entity.AccountEntity;


@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    AccountEntity findByAccountNumber(Long acc);

}
