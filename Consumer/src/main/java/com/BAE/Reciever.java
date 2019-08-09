package com.BAE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.BAE.domain.MongoAccountRepo;
import com.BAE.domain.repository.SentAccount;

@Component
public class Reciever {


    @Autowired
    private MongoAccountRepo repo;

    @JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
    public void receiveMessage(SentAccount sentAccount) {
        repo.save(sentAccount);
    }
}