package com.ironhack.Ironhack_Homework03.Service.Interface;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;

public interface AccountService {

    Account createNewAccount(Contact contact, Opportunity opo);

    Account updateAccountContacts(Contact contact, Opportunity opo);

    void meanEmployeeCount();
    void maxEmployeeCount();
    void minEmployeeCount();

}
