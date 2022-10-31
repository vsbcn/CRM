package com.ironhack.Ironhack_Homework03.Service.Interface;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.enums.Status;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;
import com.ironhack.Ironhack_Homework03.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface OpportunityService {

    Opportunity createNewOpportunity(Contact contact, Optional<Lead> optionalLead);

    List<Opportunity> getAllOpportunities();

    Optional<Opportunity> getOpportunity(Integer id);

    void UpdateOpportunityStatus(Integer id, Status status);
    void updateOpportunity(Opportunity opportunity);

    void reportOppoByProduct();

    void reportCountOppoByProductInStatus(Status status);

    void reportOpposdBySalesRep();
    void reportCountOppoBySalesRepInStatus(Status status);

    void reportCountOppoByIndustry();

    void reportCountOppoByIndustryAndStatus(Status status);

    void meanProductQuantity();


    void maxProductQuantity();


    void minProductQuantity();

}
