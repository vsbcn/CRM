package com.ironhack.Ironhack_Homework03.Service.Impl;

import com.ironhack.Ironhack_Homework03.Service.Interface.LeadService;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.model.leads.SalesRep;
import com.ironhack.Ironhack_Homework03.repositories.LeadRepository;
import com.ironhack.Ironhack_Homework03.repositories.SalesRepRepository;
import com.ironhack.Ironhack_Homework03.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ironhack.Ironhack_Homework03.utils.Utils.*;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Override
    public Lead SaveLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public void createLead(){
        String name = captureUserInput("Introduce el nombre del Lead: ");
        Integer phone = captureUserLongInput("Introduce el telefono del Lead: ");
        String email = captureUserInput("Introduce el email del Lead: ");
        String companyName = captureUserInput("Introduce el nombre de la compañia del Lead: ");

        boolean valid = false;
        Optional<SalesRep> salesRepOptional = Optional.empty();

        while(!valid){
            Integer salesRepId = captureUserIntInput("Introduce el identificador del sales rep asociado: ");
            //obtener el sales rep del repositorio y dar un error si no existe.
            salesRepOptional = salesRepRepository.findById(salesRepId);
            if(salesRepOptional.isPresent()){
                valid = true;
            }else{
                System.err.println("No existe ningun Sales rep con ese identificador");
            }
        }

        Lead newLead = new Lead(name, phone, email, companyName, salesRepOptional.get());
        leadRepository.save(newLead);
    }

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Optional<Lead> getLeadById(Integer id) {
        return leadRepository.findById(id);
    }

    @Override
    public boolean exists(Integer leadId) {
        return leadRepository.existsById(leadId);
    }

    @Override
    public void deleteLead(Lead lead) {
        leadRepository.delete(lead);
    }

    @Override
    public void reportLeadBySalesRep() {
        Utils.printReport(leadRepository.reportLeadBySalesRep(), "Nombre","count");
    }

}
