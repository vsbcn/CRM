package com.ironhack.Ironhack_Homework03.repositories;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.enums.Industry;
import com.ironhack.Ironhack_Homework03.model.enums.Product;
import com.ironhack.Ironhack_Homework03.model.enums.Status;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;
import com.ironhack.Ironhack_Homework03.model.leads.SalesRep;
import com.sun.xml.bind.v2.TODO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OpportunityRepositoryTest {

    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    LeadRepository leadRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    OpportunityRepository opportunityRepository;

    @BeforeEach
    void setUp() {

//        SalesRep salesRep1 = salesRepRepository.save(new SalesRep("Julia"));
//        SalesRep salesRep2 = salesRepRepository.save(new SalesRep("Juan"));
//        SalesRep salesRep3 = salesRepRepository.save(new SalesRep("Joan"));
//        SalesRep salesRep4 = salesRepRepository.save(new SalesRep("Philip"));
//        SalesRep salesRep5 = salesRepRepository.save(new SalesRep("Oscar"));
//
//        Lead lead1 = leadRepository.save(new Lead("Juan", 611333444, "juan@juan.es", "Mercedes", salesRep1));
//        Lead lead2 = leadRepository.save(new Lead("Lea", 611333445, "lea@lea.es", "Volvo", salesRep2));
//        Lead lead3 = leadRepository.save(new Lead("Oscar", 611333446, "oscar@oscar.es", "NM", salesRep3));
//        Lead lead4 = leadRepository.save(new Lead("Nick", 611333447, "nick@nick.es", "BN", salesRep4));
//        Lead lead5 = leadRepository.save(new Lead("Xavi", 611333448, "xavi@xavi.es", "NsCars", salesRep1));
//
//        Account account1 = accountRepository.save(new Account(300, Industry.PRODUCE, "Barcelona", "Germany"));
//        Account account2 = accountRepository.save(new Account(200, Industry.OTHERS, "Madrid", "Spain"));
//        Account account3 = accountRepository.save(new Account(100, Industry.ECOMMERCE, "Paris", "France"));
//        Account account4 = accountRepository.save(new Account(230, Industry.MANUFACTURING, "Lisbon", "Portugal"));
//        Account account5 = accountRepository.save(new Account(125, Industry.MEDICAL, "Lion", "France"));
//
//        Contact contact1 = contactRepository.save(new Contact(lead1, account1));
//        Contact contact2 = contactRepository.save(new Contact(lead2, account2));
//        Contact contact3 = contactRepository.save(new Contact(lead3, account3));
//        Contact contact4 = contactRepository.save(new Contact(lead4, account4));
//        Contact contact5 = contactRepository.save(new Contact(lead5, account5));
//
//        Opportunity opportunity1 = opportunityRepository.save(new Opportunity(Product.BOX,200,contact1,Status.CLOSED_LOST, salesRep1, account1));
//        Opportunity opportunity2 = opportunityRepository.save(new Opportunity(Product.FLATBED,50,contact2,Status.OPEN, salesRep2, account2));
//        Opportunity opportunity3 = opportunityRepository.save(new Opportunity(Product.HYBRID,100,contact3,Status.CLOSED_WON, salesRep3, account3));
//        Opportunity opportunity4 = opportunityRepository.save(new Opportunity(Product.FLATBED,70,contact4,Status.CLOSED_LOST, salesRep4, account4));
//        Opportunity opportunity5 = opportunityRepository.save(new Opportunity(Product.BOX,100,contact5,Status.OPEN, salesRep1, account5));

    }

    @AfterEach
    void tearDown() {
//
//        opportunityRepository.deleteAll();
//        contactRepository.deleteAll();
//        accountRepository.deleteAll();
//        leadRepository.deleteAll();
//        salesRepRepository.deleteAll();

    }

    // By SalesRep:
    @Test
    void reportLeadBySalesRepId() {
//         By SalesRep
//         A count of Leads by SalesRep can be displayed by typing “Report Lead by SalesRep”
//         TODO LeadRepository List<Lead> reportLeadBySalesRepId(Integer id);

        List<Lead> leadList = leadRepository.reportLeadBySalesRepId(46);

        System.out.println(leadList.get(0).getSalesRep().getLeadList().size());
        System.out.println(leadList.get(0).getSalesRep().getLeadList());

        assertTrue(true);
        assertEquals(2,leadList.get(0).getSalesRep().getLeadList().size());
    }

    @Test
    void reportOpposdBySalesRepId() {
//        A count of all Opportunities by SalesRep can be displayed by typing “Report Opportunity by SalesRep"
//        TODO OpportunityRepository List<Opportunity> reportOpposdBySalesRepId(Integer id);

        List<Opportunity> opportunityList = opportunityRepository.reportOpposdBySalesRepId(66);

        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList().size());
        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList());

        assertTrue(true);
        assertEquals(2,opportunityList.get(0).getSalesRep().getOpportunityList().size());
    }

    @Test
    void reportStatusClosedWondBySalesRepId() {
//        A count of all CLOSED_WON Opportunities by SalesRep can be displayed by typing “Report CLOSED-WON by SalesRep”
//        TODO OpportunityRepository List<Opportunity> reportStatusClosedWondBySalesRepId(Integer id, Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportStatusClosedWondBySalesRepId(66, Status.CLOSED_WON);

        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList().size());
        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList());

        assertTrue(true);
        assertEquals(2,opportunityList.get(0).getSalesRep().getOpportunityList().size());
    }

    @Test
    void reportStatusClosedLostBySalesRepId() {
//        A count of all CLOSED_LOST Opportunities by SalesRep can be displayed by typing “Report CLOSED-LOST by SalesRep”
//        TODO OpportunityRepository List<Opportunity> reportStatusClosedLostdBySalesRepId(Integer id, Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportStatusClosedLostdBySalesRepId(71, Status.CLOSED_LOST);

        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList().size());
        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList());

        assertTrue(true);
        assertEquals(4,opportunityList.get(0).getSalesRep().getOpportunityList().size());
    }

    @Test
    void reportStatusoOpendBySalesRepId() {
//        A count of all CLOSED_WON Opportunities by SalesRep can be displayed by typing “Report OPEN by SalesRep”
//        TODO OpportunityRepository List<Opportunity> reportStatusOpendBySalesRepId(Integer id, Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportStatusOpendBySalesRepId(67, Status.OPEN);

        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList().size());
        System.out.println(opportunityList.get(0).getSalesRep().getOpportunityList());

        assertTrue(true);
        assertEquals(1,opportunityList.get(0).getSalesRep().getOpportunityList().size());
    }

    // By Product
    @Test
    void reportOppoByProduct() {
//        A count of all Opportunities by the product can be displayed by typing “Report Opportunity by the product”
//        TODO OpportunityRepository List<Opportunity> reportOppoByProduct(Product product);

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByProduct(Product.FLATBED);

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(4,opportunityList.size());
    }

    @Test
    void reportOppoByProductClosedWon() {
//        A count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by the product”
//        TODO OpportunityRepository List<Opportunity> reportOppoByProductClosedWon(Product product, Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByProductClosedWon(Product.FLATBED, Status.CLOSED_WON);

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(1,opportunityList.size());
    }

    @Test
    void reportOppoByProductClosedLost() {
//        A count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by the product”
//        TODO OpportunityRepository List<Opportunity> reportOppoByProductClosedLost(Product product, Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByProductClosedLost(Product.FLATBED, Status.CLOSED_LOST);

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(1,opportunityList.size());
    }

    @Test
    void reportOppoByProductOpen() {
//        A count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by the product”
//        TODO OpportunityRepository List<Opportunity> reportOppoByProductOpen(Product product, Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByProductOpen(Product.FLATBED, Status.OPEN);

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(2,opportunityList.size());
    }

    // By Country:
    @Test
    void reportOppoByCountry() {
//        A count of all Opportunities by country can be displayed by typing “Report Opportunity by Country”
//        TODO OpportunityRepository List<Opportunity> reportOppoByCountry();

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByCountry();

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(4,opportunityList.size());
    }

    @Test
    void reportOppoByCountryAndStatus() {
//        A count of all CLOSED_WON Opportunities by country can be displayed by typing “Report CLOSED-WON by Country”
//        A count of all CLOSED_LOST Opportunities by country can be displayed by typing “Report CLOSED-LOST by Country”
//        A count of all OPEN Opportunities by country can be displayed by typing “Report OPEN by Country”

//        TODO OpportunityRepository List<Opportunity> reportOppoByCountryAndStatus();

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByCountryAndStatus(Status.OPEN);

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(1,opportunityList.size());
    }

    // By City:
    @Test
    void reportOppoByCity() {
//       A count of all Opportunities by the city can be displayed by typing “Report Opportunity by City”
//       TODO OpportunityRepository List<Opportunity> reportOppoByCity();

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByCity();

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(5,opportunityList.size());
    }

    @Test
    void reportOppoByCityAndStatus() {
//       A count of all Opportunities by the city can be displayed by typing “Report Opportunity by City”
//        1.	A count of all CLOSED_WON Opportunities by the city can be displayed by typing “Report CLOSED-WON by City”
//        1.	A count of all CLOSED_LOST Opportunities by the city can be displayed by typing “Report CLOSED-LOST by City”
//        2.	A count of all OPEN Opportunities by the city can be displayed by typing “Report OPEN by City”
//       TODO OpportunityRepository List<Opportunity> reportOppoByCityAndStatus(Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByCityAndStatus(Status.OPEN);

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(1,opportunityList.size());
    }

    // By Industry
    @Test
    void reportOppoByIndustry() {
//      A count of all Opportunities by industry can be displayed by typing “Report Opportunity by Industry”
//       TODO OpportunityRepository List<Opportunity> reportOppoByIndustry();

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByIndustry();

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(5,opportunityList.size());
    }

    @Test
    void reportOppoByIndustryAndStatus() {
//        A count of all CLOSED_WON Opportunities by industry can be displayed by typing “Report CLOSED-WON by Industry”
//        A count of all CLOSED_LOST Opportunities by industry can be displayed by typing “Report CLOSED-LOST by Industry”
//        A count of all OPEN Opportunities by industry can be displayed by typing “Report OPEN by Industry”
//       TODO OpportunityRepository List<Opportunity> reportOppoByIndustryAndStatus(Status status);

        List<Opportunity> opportunityList = opportunityRepository.reportOppoByIndustryAndStatus(Status.CLOSED_WON);

        System.out.println(opportunityList.size());
        System.out.println(opportunityList);

        assertTrue(true);
        assertEquals(4,opportunityList.size());
    }

    // EmployeeCount States:
    @Test
    void meanEmployeeCount() {
//       The mean employeeCount can be displayed by typing “Mean EmployeeCount”
//       TODO OpportunityRepository Double meanEmployeeCount();

        Double meanEmployeeCount = accountRepository.meanEmployeeCount();

        assertTrue(true);
        assertEquals(200.9091,meanEmployeeCount);
    }

    @Test
    void maxEmployeeCount() {
//       The maximum employeeCount can be displayed by typing “Max EmployeeCount”
//       TODO OpportunityRepository Double maxEmployeeCount();

        Double maxEmployeeCount = accountRepository.maxEmployeeCount();

        assertTrue(true);
        assertEquals(300.0,maxEmployeeCount);
    }

    @Test
    void minEmployeeCount() {
//       The minimum employeeCount can be displayed by typing “Min EmployeeCount”
//       TODO OpportunityRepository Double minEmployeeCount();

        Double minEmployeeCount = accountRepository.minEmployeeCount();

        assertTrue(true);
        assertEquals(100.0,minEmployeeCount);
    }
    @Test
    void meanProductQuantity() {
//       The mean quantity of products order can be displayed by typing “Mean Quantity”
//       TODO OpportunityRepository Double meanProductQuantity();

        Double meanProductQuantity= opportunityRepository.meanProductQuantity();

        assertTrue(true);
        assertEquals(104.0000,meanProductQuantity);
    }

    @Test
    void maxProductQuantity() {
//       The mean quantity of products order can be displayed by typing “Max Quantity”
//       TODO OpportunityRepository Double maxProductQuantity();

        Double maxProductQuantity= opportunityRepository.maxProductQuantity();

        assertTrue(true);
        assertEquals(200.0,maxProductQuantity);
    }

    @Test
    void minProductQuantity() {
//       The mean quantity of products order can be displayed by typing “Min Quantity”
//       TODO OpportunityRepository Double minProductQuantity();

        Double minProductQuantity= opportunityRepository.minProductQuantity();

        assertTrue(true);
        assertEquals(50.0,minProductQuantity);
    }

}