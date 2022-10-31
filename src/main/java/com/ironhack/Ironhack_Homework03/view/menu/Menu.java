package com.ironhack.Ironhack_Homework03.view.menu;

import com.ironhack.Ironhack_Homework03.Service.Impl.*;
import static com.ironhack.Ironhack_Homework03.utils.Utils.*;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.enums.Option;
import com.ironhack.Ironhack_Homework03.model.enums.Status;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;
import com.ironhack.Ironhack_Homework03.model.leads.SalesRep;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class Menu {

    private Option option;
    private HashMap<Integer, Lead> availableLeads;
    private HashMap<Integer, Opportunity> avaliableOpportunities;

    private HashMap<Integer, SalesRep> availableSalesRep;

    private LeadServiceImpl leadService;
    private AccountServiceImpl accountService;
    private ContactServiceImpl contactService;
    private OpportunityServiceImpl opportunityService;
    private SalesRepServiceImpl salesRepService;

    //Sets the menu in the correct option
    public void setCurrentOption(Option option) {
        this.option = option;
    }

    Map<Option, String[]> currentMenu = Map.of(
            Option.MAIN_MENU,
            new String[]{"Welcome to getLead CRM ®",
            "=============================="
            ,"* Create Lead"
            ,"* Show Leads"
            ,"* Lookup Lead"
            ,"* Convert"
            ,"* New SalesRep"
            ,"* Show SalesReps"
            ,"* Show Opportunities"
            ,"* Lookup Opportunity"
            ,"* Close Lost"
            ,"* Close Won"
            ,"* Reports"
            ,"* Exit"
            ,"=============================="},
            Option.REPORTS,
            new String[]{"Welcome to getLead CRM ®",
                    "=============================="
                    ,"* Report Lead by SalesRep"
                    ,"* Report Opportunity by SalesRep"
                    ,"* Report CLOSED-WON by SalesRep"
                    ,"* Report CLOSED-LOST by SalesRep"
                    ,"* Report OPEN by SalesRep"
                    ,"* Report Opportunity by the product"
                    ,"* Report CLOSED-WON by the product"
                    ,"* Report CLOSED-LOST by the product"
                    ,"* Report OPEN by the product"
                    ,"* Report Opportunity by Industry"
                    ,"* Report CLOSED-WON by Industry"
                    ,"* Report CLOSED-LOST by Industry"
                    ,"* Report OPEN by Industry"
                    ,"* Report Mean EmployeeCount"
                    ,"* Report Max EmployeeCount"
                    ,"* Report Min EmployeeCount"
                    ,"* Report Mean Quantity"
                    ,"* Report Max Quantity"
                    ,"* Report Min Quantity"
                    ,"* Go Back"
                    ,"=============================="}
    );
    //Constructor Menu
    public Menu(LeadServiceImpl leadService, AccountServiceImpl accountService, ContactServiceImpl contactService, OpportunityServiceImpl opportunityService, SalesRepServiceImpl salesRepService){
        this.leadService = leadService;
        this.accountService = accountService;
        this.contactService = contactService;
        this.opportunityService = opportunityService;
        this.salesRepService = salesRepService;
        setCurrentOption(Option.MAIN_MENU);
        availableLeads = new HashMap<>();
        avaliableOpportunities = new HashMap<>();
        availableSalesRep = new HashMap<>();
    }

    public void printPage(){
        String[] menu = currentMenu.get(option);
        System.out.println(menu[0]);
        for (int i = 1; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }


    //Converts Lead to Opportunity
    public void convert(int id){
        Optional<Lead> leadOptional = leadService.getLeadById(id);
        if(leadOptional.isPresent()) {

            Contact newContact = contactService.createNewContact(leadOptional);
            Opportunity opo = opportunityService.createNewOpportunity(newContact, leadOptional);
            boolean valid = false;
            while(!valid){
                String input = captureUserInput("Quieres crear una nueva Account? (S/N)");
                if (input.equals("s")){
                    opo.setAccount(accountService.createNewAccount(newContact, opo));
                    valid = true;
                }else if(input.equals("n")){
                    opo.setAccount(accountService.updateAccountContacts(newContact, opo));
                    valid = true;
                }
            }
            opportunityService.updateOpportunity(opo);
            leadService.deleteLead(leadOptional.get());
        }else{
            System.err.println("Este lead no existe!");
        }
    }
    //Looks for the text input and manages the string to select the correct option in the menu
    public void manageOption(UserInput option){
        switch (option.getOrder())
        {
            //1. Creating a Lead.
            case "create lead":  //method();
                createLead();
                break;
            //2. Show Leads: a list of all Leads id and name to be displayed.
            case "show leads":  //Lead.showLeads(leads);
                showLeads();
                break;
            //3. Lookup Lead id: individual Leads details.
            case "lookup lead":  //method();
                if(option.getId() != null) {
                    LookUpLeads(option.getId());
                }else{
                    System.err.println("invalid option");
                }
                break;
            //4. Convert Lead to Opportunity
            case "convert":
                if(option.getId() != null) {
                    convert(option.getId());
                }else{
                    System.err.println("invalid option");
                }
                break;
            //5. Create new Sales Rep
            case "new salesrep":
                newSalesRep();
                break;
            //6. Create new Sales Rep
            case "show salesreps":
                showSalesReps();
                break;
            //7. Show Opportunities
            case "show opportunities":
                showOpportunities();
                break;
            //8. Looking for opportunity record by typing "lookup opportunity id"
            case "lookup opportunity":  //method();
                if(option.getId() != null) {
                    LookUpOpportunity(option.getId());
                }else{
                    System.err.println("invalid option");
                }
                break;
            //9. By typing, change status of Opportunity to "close-lose id", Opportunity id.
            case "close lost":  //method();
                if(option.getId() != null) {
                    opportunityService.UpdateOpportunityStatus(option.getId(),Status.CLOSED_LOST);
                    LookUpOpportunity(option.getId());
                }else{
                    System.err.println("invalid option");
                }
                break;
            //10. By typing, change status of Opportunity to "close-won id", Opportunity id.
            case "close won":  //method();
                if(option.getId() != null) {
                    opportunityService.UpdateOpportunityStatus(option.getId(),Status.CLOSED_WON);
                    LookUpOpportunity(option.getId());
                }else{
                    System.err.println("invalid option");
                }
                break;
            case "reports":
                setCurrentOption(Option.REPORTS);
                break;
            case "exit":  //method();
                setCurrentOption(Option.EXIT);
                break;
            default:
                System.out.println("That's not a valid option!");
                break;
        }
    }

    public void manageReportOptions(UserInput option){
        switch (option.getOrder())
        {
            case "report lead by salesrep":
                leadService.reportLeadBySalesRep();
                break;
            case "report opportunity by salesrep":
                opportunityService.reportOpposdBySalesRep();
                break;
            case "report closed-won by salesrep":
                opportunityService.reportCountOppoBySalesRepInStatus(Status.CLOSED_WON);
                break;
            case "report closed-lost by salesrep":
                opportunityService.reportCountOppoBySalesRepInStatus(Status.CLOSED_LOST);
                break;
            case "report open by salesrep":
                opportunityService.reportCountOppoBySalesRepInStatus(Status.OPEN);
                break;
            case "report opportunity by the product":
                opportunityService.reportOppoByProduct();
                break;
            case "report closed-won by the product":
                opportunityService.reportCountOppoByProductInStatus(Status.CLOSED_WON);
                break;
            case "report closed-lost by the product":
                opportunityService.reportCountOppoByProductInStatus(Status.CLOSED_LOST);
                break;
            case "report open by the product":
                opportunityService.reportCountOppoByProductInStatus(Status.OPEN);
                break;
            case "report opportunity by industry":
                opportunityService.reportCountOppoByIndustry();
                break;
            case "report closed-won by industry":
                opportunityService.reportCountOppoByIndustryAndStatus(Status.CLOSED_WON);
                break;
            case "report closed-lost by industry":
                opportunityService.reportCountOppoByIndustryAndStatus(Status.CLOSED_LOST);
                break;
            case "report open by industry":
                opportunityService.reportCountOppoByIndustryAndStatus(Status.OPEN);
                break;
            case "report mean employeecount":
                accountService.meanEmployeeCount();
                break;
            case "report max employeecount":
                accountService.maxEmployeeCount();
                break;
            case "report min employeecount":
                accountService.minEmployeeCount();
                break;
            case "report mean quantity":
                opportunityService.meanProductQuantity();
                break;
            case "report max quantity":
                opportunityService.maxProductQuantity();
                break;
            case "report min quantity":
                opportunityService.minProductQuantity();
                break;
            case "go back":
                setCurrentOption(Option.MAIN_MENU);
                break;
        }
    }

    public void showMenu(){

        do{
            printPage();
            try {
                switch (option) {
                    case MAIN_MENU -> manageOption(captureOptions());
                    case REPORTS -> manageReportOptions(captureOptions());
                }
            }catch(Exception e){
                System.err.println("haber estudiao!");
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }while (option != Option.EXIT);

    }

    public void createLead(){
        leadService.createLead();
    }


    public void showLeads(){
        String leftAlignFormat = "|| %-4s | %-21s ||%n";

        System.out.format("||------+-----------------------||%n");
        System.out.format("||  Id  |         Name          ||%n");
        System.out.format("||------+-----------------------||%n");

        for (Lead lead : leadService.getAllLeads()) {
            System.out.format(leftAlignFormat, lead.getId(), lead.getLeadName());
            System.out.format("||------+-----------------------||%n");
        }

    }

    public void showOpportunities(){
        String leftAlignFormat = "|| %-4s | %-21s ||%n";

        System.out.format("||------+-----------------------||%n");
        System.out.format("||  Id  |  Decision Maker Name  ||%n");
        System.out.format("||------+-----------------------||%n");

        for (Opportunity opo : opportunityService.getAllOpportunities()) {
            System.out.format(leftAlignFormat, opo.getId(), opo.getDecisionMaker().getName());
            System.out.format("||------+-----------------------||%n");
        }

    }

    public void LookUpLeads(int id){
        Optional<Lead> leadOptional = leadService.getLeadById(id);
        if(leadOptional.isPresent()) {
            String leftAlignFormat = "|| %-4s | %-21s | %-10s | %-15s | %-21s ||%n";

            System.out.format("||------+-----------------------+------------+-----------------+-----------------------||%n");
            System.out.format("||  Id  |         Name          |   Phone    |      Email      |      Company Name     ||%n");
            System.out.format("||------+-----------------------+------------+-----------------+-----------------------||%n");

            Lead lead = leadOptional.get();
            System.out.format(leftAlignFormat, lead.getId(), lead.getLeadName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
            System.out.format("||------+-----------------------+------------+-----------------+-----------------------||%n");
        }else{
            System.err.println("This opportunity does not exist!");
        }
    }

    public void LookUpOpportunity(int id){
        Optional<Opportunity> optionalOpportunity = opportunityService.getOpportunity(id);
        if(optionalOpportunity.isPresent()) {
            String leftAlignFormat = "|| %-4s | %-19s | %-12s | %-12s | %-21s | %-15s ||%n";

            System.out.format("||------+---------------------+--------------+--------------+-----------------------+-----------------||%n");
            System.out.format("||  Id  |       Product       |   Quantity   |  Contact id  |      Contact Name     |      Status     ||%n");
            System.out.format("||------+---------------------+--------------+--------------+-----------------------+-----------------||%n");

            Opportunity opo = optionalOpportunity.get();
            System.out.format(leftAlignFormat, opo.getId(), opo.getProduct().toString(), opo.getQuantity(), opo.getDecisionMaker().getId(), opo.getDecisionMaker().getName(), opo.getStatus().toString());
            System.out.format("||------+---------------------+-------------+--------------+-----------------------+-----------------||%n");
        }else{
            System.err.println("This opportunity does not exist!");
        }
    }

    public void newSalesRep(){
        salesRepService.createSalesRep();
    }

    public void showSalesReps(){
        String leftAlignFormat = "|| %-4s | %-21s ||%n";

        System.out.format("||------+-----------------------||%n");
        System.out.format("||  Id  |         Name          ||%n");
        System.out.format("||------+-----------------------||%n");


        for (SalesRep sales :salesRepService.getAllSalesReps()) {
            System.out.format(leftAlignFormat, sales.getId(), sales.getName());
            System.out.format("||------+-----------------------||%n");
        }

    }

}
