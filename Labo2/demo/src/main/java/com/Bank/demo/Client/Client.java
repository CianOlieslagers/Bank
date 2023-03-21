package com.Bank.demo.Client;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 0

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_sequence"
    )
    private Long id;
    private String name;
    private Integer balance;
    public Client() {
    }

    public Client(Long id, String user, Integer balance) {
        this.id = id;
        this.name = user;
        this.balance = balance;
    }

    public Client(String user, Integer balance) {
        this.name = user;
        this.balance = balance;
    }
// Lombok zou de getters en setter niet nodig maken
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return name;
    }

    public void setUser(String user) {
        this.name = user;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
