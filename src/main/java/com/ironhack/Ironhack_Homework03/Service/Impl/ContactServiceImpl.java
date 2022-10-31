package com.ironhack.Ironhack_Homework03.Service.Impl;

import com.ironhack.Ironhack_Homework03.Service.Interface.ContactService;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;


    @Override
    public Contact createNewContact(Optional<Lead> optionalLead) {
        // Creamos el contacto en base a la información del lead
        Contact newContact = new Contact(optionalLead.get());
        return contactRepository.save(newContact);
    }
}
