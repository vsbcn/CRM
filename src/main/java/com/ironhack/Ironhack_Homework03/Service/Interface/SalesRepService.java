package com.ironhack.Ironhack_Homework03.Service.Interface;

import com.ironhack.Ironhack_Homework03.model.leads.SalesRep;

import java.util.List;
import java.util.Optional;

public interface SalesRepService {

    Optional<SalesRep> findSalesRep(Integer id);

    void createSalesRep();

    List<SalesRep> getAllSalesReps();
}
