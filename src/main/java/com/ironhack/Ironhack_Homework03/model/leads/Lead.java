package com.ironhack.Ironhack_Homework03.model.leads;

import com.ironhack.Ironhack_Homework03.model.customer.Contact;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;


@Entity
@Table(name = "leads")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Lead {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The department should be not empty.")
    private String leadName;
    private Integer phoneNumber;
    private String email;
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "SALES_REP_ID")
    private SalesRep salesRep;

    //CONSTRUCTORS
    public Lead() {
    }

    public Lead(String leadName, Integer phoneNumber, String email, String companyName) {
        setLeadName(leadName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public Lead(String leadName, Integer phoneNumber, String email, String companyName, SalesRep salesRep) {
        setLeadName(leadName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
        setSalesRep(salesRep);
    }

    //GETTERS AND SETTERS
    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", name='" + leadName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    // Show Leads: a list of all Leads with id and name to be displayed.
    public static ArrayList showLeads(ArrayList<Lead> leads) {
        ArrayList<String> result = new ArrayList<>();
        for (int x = 0; x < leads.size(); x++) {
            result.add(leads.get(x).getId().toString());
            result.add(leads.get(x).getLeadName());
        }
        return result;
    }
}




