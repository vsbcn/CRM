package com.ironhack.Ironhack_Homework03.Service.Impl;

import com.ironhack.Ironhack_Homework03.Service.Interface.SalesRepService;
import com.ironhack.Ironhack_Homework03.model.leads.SalesRep;
import com.ironhack.Ironhack_Homework03.repositories.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ironhack.Ironhack_Homework03.utils.Utils.captureUserInput;

@Service
public class SalesRepServiceImpl implements SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;


    @Override
    public Optional<SalesRep> findSalesRep(Integer id) {
        return salesRepRepository.findById(id);
    }

    @Override
    public void createSalesRep() {
        String name = captureUserInput("Introduce el nombre del Sales Rep: ");
        SalesRep newSalesRep = new SalesRep(name);
        salesRepRepository.save(newSalesRep);
    }

    @Override
    public List<SalesRep> getAllSalesReps() {
        return salesRepRepository.findAll();
    }
}
