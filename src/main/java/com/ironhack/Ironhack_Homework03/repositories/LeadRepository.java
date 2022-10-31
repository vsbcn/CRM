package com.ironhack.Ironhack_Homework03.repositories;

import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Integer> {
    @Query(value = "SELECT * FROM leads L INNER JOIN sales_rep SP ON L.SALES_REP_ID = SP.ID WHERE SP.ID = ?1", nativeQuery = true)
    List<Lead> reportLeadBySalesRepId(Integer id);


    //A count of Leads by SalesRep
    @Query(value = "SELECT sp.name, count(L.id) FROM leads L INNER JOIN sales_rep SP ON L.SALES_REP_ID = SP.ID", nativeQuery = true)
    List<Object[]> reportLeadBySalesRep();

}