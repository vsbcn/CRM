package com.ironhack.Ironhack_Homework03.model.leads;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.enums.Product;
import com.ironhack.Ironhack_Homework03.model.enums.Status;


import javax.persistence.*;

@Entity
@Table(name = "opportunities")
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Product product;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "SALES_REP_ID")
    private SalesRep salesRepOpp;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @OneToOne
    @JoinColumn(name = "DECISION_MAKER")
    private Contact decisionMaker;

    //CONSTRUCTORS
    public Opportunity() {
    }

    public Opportunity(Product product, Integer quantity, Contact decisionMaker, SalesRep salesRep, Status status) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
        setSalesRep(salesRep);
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, SalesRep salesRep, Account account) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
        setSalesRep(salesRep);
        setAccount(account);
    }

    //GETTERS AND SETTERS
    public SalesRep getSalesRep() {
        return salesRepOpp;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRepOpp = salesRep;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", status=" + status +
                ", salesRepOpp=" + salesRepOpp +
                ", account=" + account +
                ", decisionMaker=" + decisionMaker +
                '}';
    }
}
