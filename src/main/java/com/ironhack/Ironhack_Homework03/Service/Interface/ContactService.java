package com.ironhack.Ironhack_Homework03.Service.Interface;

import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;

import java.util.Optional;

public interface ContactService {

    Contact createNewContact(Optional<Lead> leadOptional);

}
