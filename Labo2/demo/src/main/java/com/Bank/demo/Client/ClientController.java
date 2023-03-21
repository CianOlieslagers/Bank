package com.Bank.demo.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// hier zullen onze resources voor onze API staan

@RestController
@RequestMapping(path = "api/v1/student")
public class ClientController {


    private final ClientService userService;

    @Autowired // zorgt ervoor dat Userservice autoamatisch wor toegevoegd
    public ClientController(ClientService userService) {
        this.userService =  userService;
    }


    @GetMapping
    public List<Client> getUsers(){
        return userService.GetClient();

    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        userService.addNewClient(client);
    }
    @DeleteMapping(path = "{clientId}")
    public void removeClient(@PathVariable("clientId") Long clientId) {
        userService.removeClient(clientId);
    }

    // get the balance of the account
    @GetMapping(path = "{clientId}/balance")
    public double getBalance(@PathVariable("clientId") Long clientId) {
        return userService.getBalance(clientId);
    }

    // deposit money on the account
    @PutMapping(path = "{clientId}/deposit/{amount}")
    public void depositMoney(@PathVariable String User, @PathVariable double amount) {
        userService.depositMoney(User, amount);
    }

    // withdraw money from the account
    @PutMapping(path = "{clientId}/withdraw/{amount}")
    public void withdrawMoney(@PathVariable String name, @PathVariable double amount) {
        userService.withdrawMoney(name, amount);
    }

    // transfer money from clientId to destId
    @PutMapping(path = "{clientId}/transfer/{destId}/{amount}")
    public void transferMoney(@PathVariable String Name, @PathVariable String destName, @PathVariable double amount) {
        userService.transferMoney(Name, destName, amount);
    }


}
