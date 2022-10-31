package com.ironhack.Ironhack_Homework03.Service.Impl;

import com.ironhack.Ironhack_Homework03.Service.Interface.OpportunityService;
import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.enums.Product;
import com.ironhack.Ironhack_Homework03.model.enums.Status;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;
import com.ironhack.Ironhack_Homework03.repositories.OpportunityRepository;
import com.ironhack.Ironhack_Homework03.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ironhack.Ironhack_Homework03.utils.Utils.captureUserInput;
import static com.ironhack.Ironhack_Homework03.utils.Utils.captureUserIntInput;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;


    @Override
    public Opportunity createNewOpportunity(Contact contact, Optional<Lead> optionalLead) {
        Product product = Product.NONE;

        boolean valid = false;
        while (!valid) {
            try {
                product = Product.valueOf(captureUserInput("Introduce el tipo de camión (HYBRID/FLATBED/BOX): ").toUpperCase());
                valid = true;
            } catch (IllegalArgumentException e){
                System.err.println("Valor no valido, porfavor intentalo de nuevo");
            }
        }

        int quantity = captureUserIntInput("Introduce la cantidad a comprar: ");
        Opportunity opo = new Opportunity(product, quantity, contact, optionalLead.get().getSalesRep(), Status.OPEN);
        System.out.println("Oportunity Created Successfully!");
        return opportunityRepository.save(opo);
    }

    @Override
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    @Override
    public Optional<Opportunity> getOpportunity(Integer id) {
        return opportunityRepository.findById(id);
    }

    @Override
    public void UpdateOpportunityStatus(Integer id, Status status) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(id);

        if(optionalOpportunity.isPresent()){
            optionalOpportunity.get().setStatus(status);
            opportunityRepository.save(optionalOpportunity.get());
        }else{
            System.err.println("Error actualizando el estado de la opportunity");
        }
    }

    @Override
    public void updateOpportunity(Opportunity opportunity) {
        opportunityRepository.save(opportunity);
    }

    @Override
    public void reportOppoByProduct() {
        Utils.printReport(opportunityRepository.reportOppoByProduct(), "product id", "opportunity count");
    }

    @Override
    public void reportCountOppoByProductInStatus(Status status) {
        Utils.printReport(opportunityRepository.reportOppoByProductStatus(status),"product id", "opportunity count");
    }

    @Override
    public void reportOpposdBySalesRep() {
        Utils.printReport(opportunityRepository.reportOpposdBySalesRep(),"SalesRep Name", "opportunity count");
    }

    @Override
    public void reportCountOppoBySalesRepInStatus(Status status) {
        Utils.printReport(opportunityRepository.reportStatus(status),"SalesRep Name", "opportunity count");
    }
    @Override
    public void reportCountOppoByIndustry() {
        Utils.printReport(opportunityRepository.reportCountOppoByIndustry(),"Industry Name", "opportunity count");
    }
    @Override
    public void reportCountOppoByIndustryAndStatus(Status status) {
        Utils.printReport(opportunityRepository.reportCountOppoByIndustryAndStatus(status),"Industry Name", "opportunity count");
    }

    @Override
    public void meanProductQuantity() {
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"count",opportunityRepository.meanProductQuantity()});
        Utils.printReport(objects, "Mean employee count", "opportunity count");
    }

    @Override
    public void maxProductQuantity() {
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"count",opportunityRepository.maxProductQuantity()});
        Utils.printReport(objects, "Max employee count", "opportunity count");
    }

    @Override
    public void minProductQuantity() {
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"count",opportunityRepository.minProductQuantity()});
        Utils.printReport( objects, "Min employee count", "opportunity count");
    }


}
