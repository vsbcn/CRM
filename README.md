<!-- PROJECT LOGO -->

<div align="center">
  
![bankingClassDiagram](https://drive.google.com/uc?export=view&id=18xfdnSgXayAKT5dggnwH11d0vEga8ygD)  
  
  <h3 align="center">getLead CRM ® V2.0</h3>
  
</div>

<!-- PROJECT SUMMARY -->
<details>
  <summary>Project summary:</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project: </a>
      <ul>
        <li><a href="#built-with">Built With:</a></li>
      </ul>
    </li>
    <li>
      <a>Diagrams:</a>
      <ul>
        <li><a href="#use-case-diagram">Use Case: </a></li>
        <li><a href="#class-diagram">Class Diagram:</a></li>
      </ul>
    </li>
    <li>
      <a href="#contributors">Contributors:</a>
    </li>    
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

# About The Project:

<p href="#about-the-project">
  
getLead CRM ® done the community way. Focus is on the Community that includes Subject Matter Specialists, Implementors and End-Users.
Our specialization is within Transport companies. Equipped with wide and detailed functionality fits for companies from industry and trade that are searching business software that provides high scalability and flexibility.
  
 Let's fast walk throught and overview the main functionality:
## V2 Main features

![image (2)](https://user-images.githubusercontent.com/83654247/189436936-a41d3d6d-189b-46a2-aa5b-cec14968066b.png)


1) **SalesRep Creation:**
By typing `New SalesRep` you will be prompted to introduce a name to create the new Sales Rep.

2) **SalesRep List:**
By typing `Show SalesReps`you will see a list of all the Sales Reps.

3) **Account Creation:**
After a Lead is created you will be given the option to create a new Account or not. You will see the prompt `Quieres crear una nueva Account? (S/N)`where you need to type `S` or `N`.

4) **Reporting**
By typing `Reporting` you will go into the reporting menu where you will be able to choose your report.

### Reporting

**By SalesRep**

1) Type `Report Lead by SalesRep` to see a count of the Leads by SalesRep.
2) Type `Report Opportunity by SalesRep` to see a count of all the Opportunities by SalesRep.
3) Type `Report CLOSED-WON by SalesRep` to see a count of all the *CLOSED_WON* Opportunities.
4) Type `Report CLOSED-LOST by SalesRep` to see a count of all *CLOSED_LOST* Opportunities.
5) Type `Report OPEN by SalesRep` to see a count of all *OPEN* Opportunities.

**By Product**

1) Type `Report Opportunity by the product` to see a count of all the Opportunities by Product.
2) Type `Report CLOSED-WON by the product` to see a count of all the *CLOSED_WON* Opportunities by Product.
3) Type `Report CLOSED-LOST by the product` to see a count of all *CLOSED_LOST* Opportunities by Product.
4) Type `Report OPEN by the product` to see a count of all *OPEN* Opportunities by Product.

**By Industry**

1) Type `Report Opportunity by Industry` to see a count of all the Opportunities by Industry.
2) Type `Report CLOSED-WON by Industry` to see a count of all the *CLOSED_WON* Opportunities by Industry.
3) Type `Report CLOSED-LOST by Industry` to see a count of all *CLOSED_LOST* Opportunities by Industry.
4) Type `Report OPEN by Industry` to see a count of all *OPEN* Opportunities by Industry.

Also we can have reports for the **EmployeeCount** state.

1) Type `Mean EmployeeCount` to get the mean.
2) Type `Max EmployeeCount` to get the maximum.
3) Type `Min EmployeeCount` to get the minimum.

And lastly we also have 3 reports for the **Quantity** state.

1) Type `Mean Quantity` to get the mean.
2) Type `Max Quantity` to get the maximum.
3) Type `Min Quantity` to get the minimum.



## V1 Main features
 ![image](https://user-images.githubusercontent.com/10848174/185793972-e874435d-fde8-434b-8684-798fb70d3e60.png)

  1) The main feature starts from Lead creation: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794022-3cec2fcf-259a-4973-8f95-20b376512c66.png) <br>
Where user will be prompted for name, telephone number, e-mail and company name.
2) To show current leads, we just need to select second option by typying: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794133-11f79b91-388d-4b7e-8957-b0ef93cf309a.png) <br>
Then screen with lead information will be prompted to check lead's id and name. <br>
  3) With the existing id, we can check lead full information provided by next option: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794181-05b262e3-1802-498d-aedd-fb0e7e98de0f.png) <br>
Where the screen will pop up with full lead details. <br>
  4) Since our lead could be possible opportunity to make our deals, we can convert lead by typing convert + existing id into opportunity: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794238-f68bb418-4a3b-45d6-8b6a-bb030a9ceacd.png) <br>
  Then we can select available trucks, quantity of items to be purchased and the Opportunity will be created! <br>
5) In the next option, we can double check one or more opportunites that are created previouslly: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794315-5bac6d0f-2228-4f48-9386-77f82b374a9e.png) <br>
6) With valid Id, we can check full opportunity details: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794329-bfae3713-993a-4f02-8d70-cce3e02dbb3a.png) <br>
7) As final step to fullfil business expectations about the opportunity, one of the options could be to select providing valid opportunity's id: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794394-6aa4e405-085e-439e-811c-a9659485c14b.png) <br>
8) Last but not least, the CRM can be closed by "exit" option: <br>
  ![image](https://user-images.githubusercontent.com/10848174/185794446-26d93a75-b54c-466a-8a16-77b41ffffcb4.png) <br>
  Thank you for using getLead Customer Relationship Management platform!
</p>

<p align="right">(<a href="#top">back to top</a>)</p>

## Built With:

<p href="#built-with">
  
Our planning were organized within Jira Tools with previous break downs of a main project and distribution within modular tasks:
  ![image](https://user-images.githubusercontent.com/10848174/185794902-b1e0e18a-b1ab-4f27-885c-7fc88c60adf9.png)

  
</p>

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- DIAGRAMS -->
<p href="#use-case-diagram"></p>

## Case Diagram:

![Use Case diagram](https://user-images.githubusercontent.com/83654247/189441147-9156a513-4feb-4baf-bf11-8ccbf11b79d3.svg)



<p href="#class-diagram"></p>

## Class Diagram:

![Class diagram](https://user-images.githubusercontent.com/83654247/189480804-be80a250-2048-4477-861b-c11787127684.svg)




## Contributors:

<p href="#contributors">
<a href="https://github.com/huenchu">	» @huenchu - Alexis Emmanuel Huenchuán Varas</a><br> 
 <a href="https://github.com/oroig">	» @oroig - Oscar Roig</a><br>
  <a href="https://github.com/MaxiVina">	» @MaxiVina - Maximiliano Vina</a><br>
  <a href="https://github.com/vsbcn"> 	» @vsbcn - Vitalik Serhyeyev</a><br>  
</p>

<p align="right">(<a href="#top">back to top</a>)</p>
