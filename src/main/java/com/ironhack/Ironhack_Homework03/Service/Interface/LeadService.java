package com.ironhack.Ironhack_Homework03.Service.Interface;

import com.ironhack.Ironhack_Homework03.model.leads.Lead;

import java.util.List;
import java.util.Optional;

public interface LeadService {

    Lead SaveLead(Lead lead);

    void createLead();

    List<Lead> getAllLeads();

    Optional<Lead> getLeadById(Integer id);

    boolean exists(Integer leadId);

    void deleteLead(Lead lead);

    void reportLeadBySalesRep();

}
