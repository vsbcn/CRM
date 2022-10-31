package com.ironhack.Ironhack_Homework03.repositories;

import com.ironhack.Ironhack_Homework03.model.enums.Status;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;
import com.ironhack.Ironhack_Homework03.model.leads.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {


}