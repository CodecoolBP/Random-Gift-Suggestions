package com.codecool.datasaverservice.service;

import com.codecool.datasaverservice.model.Gift;
import com.codecool.datasaverservice.model.Person;
import com.codecool.datasaverservice.repository.GiftRepository;
import com.codecool.datasaverservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataSaveService {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private GiftRepository giftRepo;

    public String savePerson(Person person, Gift gift) {

        personRepo.saveAndFlush(person);
        gift.setPerson(person);
        giftRepo.saveAndFlush(gift);


        return person.getName() + " saved to db with " + gift.getName();
    }

}