package com.ironhack.Ironhack_Homework03.repositories;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    //EmployeeCount States
    //The mean employeeCount can be displayed by typing “Mean EmployeeCount”
    @Query(value = "SELECT AVG(EMPLOYEE_COUNT) FROM accounts", nativeQuery = true)
    Double meanEmployeeCount();

    //The maximum employeeCount can be displayed by typing “Max EmployeeCount”
    @Query(value = "SELECT MAX(EMPLOYEE_COUNT) FROM accounts", nativeQuery = true)
    Double maxEmployeeCount();

    //The minimum employeeCount can be displayed by typing “Min EmployeeCount”
    @Query(value = "SELECT MIN(EMPLOYEE_COUNT) FROM accounts", nativeQuery = true)
    Double minEmployeeCount();

}