package com.ironhack.Ironhack_Homework03.repositories;

import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}