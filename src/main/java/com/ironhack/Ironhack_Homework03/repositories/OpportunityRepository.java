package com.ironhack.Ironhack_Homework03.repositories;

import com.ironhack.Ironhack_Homework03.model.account.Account;
import com.ironhack.Ironhack_Homework03.model.enums.Product;
import com.ironhack.Ironhack_Homework03.model.enums.Status;
import com.ironhack.Ironhack_Homework03.model.leads.Lead;
import com.ironhack.Ironhack_Homework03.model.leads.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

    @Query(value = "SELECT * FROM opportunities O INNER JOIN sales_rep SP ON O.SALES_REP_ID = SP.ID WHERE SP.ID=?1", nativeQuery = true)
    List<Opportunity> reportOpposdBySalesRepId(Integer id);
    @Query(value = "SELECT * FROM opportunities O INNER JOIN sales_rep SP ON O.SALES_REP_ID = SP.ID WHERE SP.ID = ?1 AND STATUS LIKE %?2%", nativeQuery = true)
    List<Opportunity> reportStatusClosedWondBySalesRepId(Integer id, Status status);
    @Query(value = "SELECT * FROM opportunities O INNER JOIN sales_rep SP ON O.SALES_REP_ID = SP.ID WHERE SP.ID = ?1 AND STATUS LIKE %?2%", nativeQuery = true)
    List<Opportunity> reportStatusClosedLostdBySalesRepId(Integer id, Status status);
    @Query(value = "SELECT * FROM opportunities O INNER JOIN sales_rep SP ON O.SALES_REP_ID = SP.ID WHERE SP.ID = ?1 AND STATUS LIKE %?2%", nativeQuery = true)
    List<Opportunity> reportStatusOpendBySalesRepId(Integer id, Status status);

    // A count of all Opportunities by SalesRep can be displayed by typing "Report Opportunity by SalesRep"
    @Query(value = "SELECT sp.name, count(O.id) FROM opportunities O INNER JOIN sales_rep SP ON O.SALES_REP_ID = SP.ID", nativeQuery = true)
    List<Object[]> reportOpposdBySalesRep();

    // A count of all CLOSED_WON Opportunities by SalesRep can be displayed by typing "Report CLOSED-WON by SalesRep // CLOSED-LOST by SalesRep // Report OPEN by SalesRep
    @Query(value = "SELECT sp.name, count(O.id) FROM opportunities O INNER JOIN sales_rep SP ON O.SALES_REP_ID = SP.ID WHERE STATUS LIKE %?1%", nativeQuery = true)
    List<Object[]> reportStatus(Status status);

    /*

    A count of all Opportunities by the product can be displayed by typing “Report Opportunity by the product”
    A count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by the product”
    A count of all CLOSED_LOST Opportunities by the product can be displayed by typing “Report CLOSED-LOST by the product”
    A count of all OPEN Opportunities by the product can be displayed by typing “Report OPEN by the product”

     */


    // A count of all CLOSED_WON Opportunities by Industry can be displayed by typing "Report CLOSED-WON by Industry" // CLOSED-LOST by Industry // Report OPEN by Industry
    @Query(value = "SELECT A.INDUSTRY, count(O.id) FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID WHERE O.STATUS LIKE %?1% GROUP BY A.INDUSTRY", nativeQuery = true)
    List<Object[]> reportCountOppoByIndustryAndStatus(Status status);

    @Query(value = "SELECT * FROM opportunities WHERE PRODUCT LIKE %?1%", nativeQuery = true)
    List<Opportunity> reportOppoByProduct(Product product);
    @Query(value = "SELECT opo.product, count(opo.id) FROM opportunities opo GROUP BY product", nativeQuery = true)
    List<Object[]> reportOppoByProduct();
    @Query(value = "SELECT * FROM opportunities WHERE PRODUCT LIKE %?1% AND STATUS LIKE %?2%", nativeQuery = true)
    List<Opportunity> reportOppoByProductClosedWon(Product product, Status status);


    @Query(value = "SELECT opo.status, count(opo.id) FROM opportunities opo WHERE STATUS LIKE %?1%", nativeQuery = true)
    List<Object[]> reportOppoByProductStatus(Status status);

    @Query(value = "SELECT * FROM opportunities WHERE PRODUCT LIKE %?1% AND STATUS LIKE %?2%", nativeQuery = true)
    List<Opportunity> reportOppoByProductClosedLost(Product product, Status status);

    @Query(value = "SELECT * FROM opportunities WHERE PRODUCT LIKE %?1% AND STATUS LIKE %?2%", nativeQuery = true)
    List<Opportunity> reportOppoByProductOpen(Product product, Status status);



    //By Industry
    //A count of all Opportunities by industry can be displayed by typing “Report Opportunity by Industry”
    @Query(value = "SELECT A.INDUSTRY, count(O.id) FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID", nativeQuery = true)
    List<Object[]> reportCountOppoByIndustry();
    @Query(value = "SELECT * FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID GROUP BY A.INDUSTRY", nativeQuery = true)
    List<Opportunity> reportOppoByIndustry();

    //A count of all CLOSED_WON Opportunities by industry / A count of all CLOSED_LOST Opportunities by industry / A count of all OPEN Opportunities by industry
    @Query(value = "SELECT * FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID WHERE O.STATUS LIKE %?1% GROUP BY A.INDUSTRY", nativeQuery = true)
    List<Opportunity> reportOppoByIndustryAndStatus(Status status);


    //Quantity States
    //The mean quantity of products order can be displayed by typing “Mean Quantity”
    @Query(value = "SELECT AVG(QUANTITY) FROM opportunities", nativeQuery = true)
    Double meanProductQuantity();
    //The maximum quantity of products order can be displayed by typing “Max Quantity”
    @Query(value = "SELECT MAX(QUANTITY) FROM opportunities", nativeQuery = true)
    Double maxProductQuantity();
    //The minimum quantity of products order can be displayed by typing “Min Quantity”
    @Query(value = "SELECT MIN(QUANTITY) FROM opportunities", nativeQuery = true)
    Double minProductQuantity();


    //--- OPTIONAL REPORTS ---
    //By Country
    //A count of all Opportunities by country
    @Query(value = "SELECT * FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID GROUP BY A.COUNTRY", nativeQuery = true)
    List<Opportunity> reportOppoByCountry();
    //A count of all CLOSED_WON Opportunities by country / A count of all CLOSED_LOST Opportunities by country / A count of all OPEN Opportunities by country
    @Query(value = "SELECT * FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID WHERE O.STATUS LIKE %?1% GROUP BY A.COUNTRY", nativeQuery = true)
    List<Opportunity> reportOppoByCountryAndStatus(Status status);


    //By City
    //A count of all Opportunities by the city
    @Query(value = "SELECT * FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID GROUP BY A.CITY", nativeQuery = true)
    List<Opportunity> reportOppoByCity();
    //A count of all CLOSED_WON Opportunities by the city / A count of all CLOSED_LOST Opportunities by the city / A count of all OPEN Opportunities by the city
    @Query(value = "SELECT * FROM opportunities O INNER JOIN accounts A ON O.ACCOUNT_ID = A.ID WHERE O.STATUS LIKE %?1% GROUP BY A.CITY", nativeQuery = true)
    List<Opportunity> reportOppoByCityAndStatus(Status status);

}