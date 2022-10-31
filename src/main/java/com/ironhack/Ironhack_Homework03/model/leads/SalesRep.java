package com.ironhack.Ironhack_Homework03.model.leads;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "sales_rep")
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "salesRep", fetch = FetchType.EAGER)
    private List<Lead> leadList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "salesRepOpp")
    private List<Opportunity> opportunityList;

    //region Gets and Sets
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lead> getLeadList() {
        return leadList;
    }

    public void setLeadList(List<Lead> leadList) {
        this.leadList = leadList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    //CONSTRUCTORS
    public SalesRep() {
    }

    public SalesRep(String name) {
        this.name = name;
    }

    public SalesRep(String name, List<Lead> leadList, List<Opportunity> opportunityList) {
        this.name = name;
        this.leadList = leadList;
        this.opportunityList = opportunityList;
    }

    @Override
    public String toString() {
        return "SalesRep{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


