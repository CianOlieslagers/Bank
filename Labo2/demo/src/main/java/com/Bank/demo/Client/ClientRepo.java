package com.Bank.demo.Client;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo
        extends JpaRepository<Client,Long> {


    @Query("select client From Client client where client.name =?1")
    Optional<Client> findClientByName(String Name);

    @Query("SELECT balance FROM Client WHERE id = ?1")
    double findBalanceByClientId(Long id);

    @Query("SELECT balance FROM Client WHERE name = ?1")
    double findBalanceByname(String name);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Client SET balance = balance + ?2 WHERE name = ?1")
    void DepositMoneyByName(String name, double amount);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Client SET balance = balance - ?2 WHERE name = ?1")
    void WithdrawMoneyByName(String name, double amount);



}
