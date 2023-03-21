package com.Bank.demo.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    private  final ClientRepo clientRepo;
    // de interface zorgt ervoor dat we eig ziek veek methods hebben


    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> GetClient(){
        return clientRepo.findAll();
    }


    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepo.findClientByName(client.getUser());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException("Naam in gebruik");
        }

        clientRepo.save(client);
    }
    public void removeClient(Long clientId) {
        if (!clientRepo.existsById(clientId)) {
            throw new IllegalStateException("client with id " + clientId + " does not exists");
        }
        clientRepo.deleteById(clientId);
    }

    public double getBalance(Long clientId) {
        return clientRepo.findBalanceByClientId(clientId);
    }

    public void depositMoney(String name, double amount) {
        if (amount <= 0.0) {
            throw new IllegalStateException("amount has to be greater than 0");
        }
        clientRepo.DepositMoneyByName(name,amount);
    }

    public void withdrawMoney(String name, double amount) {
        if (amount <= 0.0) {
            throw new IllegalStateException("amount has to be greater than 0");
        }
        if (clientRepo.findBalanceByname(name) < amount) {
            throw new IllegalStateException("Not enough money in the account");
        }
        clientRepo.WithdrawMoneyByName(name,amount);
    }

    public void transferMoney(String name, String destName, double amount) {
        if (amount <= 0.0) {
            throw new IllegalStateException("amount has to be greater than 0");
        }
        if (clientRepo.findBalanceByname(name) < amount) {
            throw new IllegalStateException("Not enough money in the account");
        }
        clientRepo.WithdrawMoneyByName(name,amount);
        clientRepo.DepositMoneyByName(destName,amount);
    }



}

