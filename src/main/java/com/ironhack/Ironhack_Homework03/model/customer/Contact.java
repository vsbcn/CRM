package com.ironhack.Ironhack_Homework03.model.customer;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "contacts")
public class Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The department should be not empty.")
    private String name;
    private Integer phoneNumber;
    private String email;
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @OneToOne(mappedBy = "decisionMaker")
    private Opportunity opportunity;
    public Contact() {
    }

    //CONSTRUCTORS
    public Contact(Lead lead) {
        this.name = lead.getLeadName();
        this.phoneNumber = lead.getPhoneNumber();
        this.email = lead.getEmail();
        this.companyName = lead.getCompanyName();
    }

    public Contact(Lead lead, Account account) {
        this.name = lead.getLeadName();
        this.phoneNumber = lead.getPhoneNumber();
        this.email = lead.getEmail();
        this.companyName = lead.getCompanyName();
        this.account = account;
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
