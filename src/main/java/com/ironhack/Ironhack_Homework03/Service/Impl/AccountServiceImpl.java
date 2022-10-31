package com.ironhack.Ironhack_Homework03.Service.Impl;

import com.ironhack.Ironhack_Homework03.Service.Interface.AccountService;
import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.customer.Contact;
import com.ironhack.Ironhack_Homework03.model.enums.Industry;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;
import com.ironhack.Ironhack_Homework03.repositories.AccountRepository;
import com.ironhack.Ironhack_Homework03.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import static com.ironhack.Ironhack_Homework03.utils.Utils.captureUserInput;
import static com.ironhack.Ironhack_Homework03.utils.Utils.captureUserIntInput;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Account createNewAccount(Contact contact, Opportunity opo) {
        System.out.println("Cuentanos sobre la empresa!");
        Industry industry = Industry.OTHERS;

        boolean valid = false;
        while (!valid) {
            try {
                industry = Industry.valueOf(captureUserInput("Introduce el tipo de industria realcionada (PRODUCE / ECOMMERCE / MANUFACTURING / MEDICAL / OTHERS): ").toUpperCase());
                valid = true;
            } catch (IllegalArgumentException e){
                System.err.println("Valor no valido, porfavor intentalo de nuevo");
            }
        }

        int employeeCount = captureUserIntInput("Introduce la cantidad de empleados: ");
        String city = captureUserInput("En que ciudad se encuentra?");
        String country = captureUserInput("En que pais se encuentra?");

        Account account = new Account(employeeCount, industry, city, country);
        account.addContactToList(contact);
        account.addOpportunityToList(opo);

        return accountRepository.save(account);

    }

    @Override
    public Account updateAccountContacts(Contact contact, Opportunity opo) {
        Optional<Account> accountOptional = Optional.empty();
        boolean valid = false;
        while (!valid) {
            Integer id = captureUserIntInput("Indica el identificador de la account a asociar");
            accountOptional = accountRepository.findById(id);
            if (accountOptional.isPresent()){
                accountOptional.get().addContactToList(contact);
                accountOptional.get().addOpportunityToList(opo);
                valid = true;
            }else {
                System.err.println("El contacto no existe!");
            }
        }

        return accountRepository.save(accountOptional.get());
    }

    @Override
    public void meanEmployeeCount() {
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"count",accountRepository.meanEmployeeCount()});
        Utils.printReport(objects, "Mean employee count", "opportunity count");
    }

    @Override
    public void maxEmployeeCount() {
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"count",accountRepository.maxEmployeeCount()});
        Utils.printReport(objects, "Max employee count", "opportunity count");
    }

    @Override
    public void minEmployeeCount() {
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"count",accountRepository.minEmployeeCount()});
        Utils.printReport( objects, "Min employee count", "opportunity count");
    }
}
