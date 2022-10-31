package com.ironhack.Ironhack_Homework03;

import com.ironhack.Ironhack_Homework03.Service.Impl.*;
import com.ironhack.Ironhack_Homework03.view.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IronhackHomework03Application implements CommandLineRunner {

static int exitCode;

	@Autowired
	private LeadServiceImpl leadService;
	@Autowired
	private AccountServiceImpl accountService;
	@Autowired
	private ContactServiceImpl contactService;
	@Autowired
	private OpportunityServiceImpl opportunityService;
	@Autowired
	private SalesRepServiceImpl salesRepService;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =
		SpringApplication.run(IronhackHomework03Application.class, args);
		exitCode = SpringApplication.exit(ctx, () -> 0);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(leadService, accountService, contactService, opportunityService, salesRepService);
		menu.showMenu();
	}



}