package com.acts.trekking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acts.trekking.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
