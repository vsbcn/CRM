
package com.ironhack.Ironhack_Homework03.model.account;

import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.enums.Industry;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private Integer employeeCount;
    private String city;
    private String country;
    @OneToMany(mappedBy = "account")
    private List<Contact> contactList;
    @OneToMany(mappedBy = "account")
    private List<Opportunity> opportunityList;

    //CONSTRUCTORS
    public Account() {
    }

    public Account(int employeeCount, Industry industry, String city, String country) {
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setIndustry(industry);
        contactList = new ArrayList<>();
        opportunityList = new ArrayList<>();
    }

    //GETTERS & SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addContactToList(Contact contact){
        contactList.add(contact);
    }

    public void addOpportunityToList(Opportunity opportunity){
        opportunityList.add(opportunity);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}