package com.getleadcrm.menu;

import com.ironhack.Ironhack_Homework03.view.menu.Menu;
import com.ironhack.Ironhack_Homework03.view.menu.UserInput;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ironhack.Ironhack_Homework03.utils.Utils.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuTest {

    @Test
    public void checkOrder_captureOrderId_returnOrderId() {
        // test of testMenu.captureOrderId(String option, UserInput);

        UserInput userInput = new UserInput("box", 1);

        assertEquals(1, captureOrderId("1", userInput));
        assertNotEquals(2, captureOrderId("1", userInput));
    }

    @Test
    public void checkUserInput_interpretUserInput_returnValidUserInput() {
        // test of testMenu.interpretUserInput(String option);

        UserInput userInput = new UserInput("create lead", null);
        UserInput userInput2 = new UserInput("show leads", null);
        UserInput userInput3 = new UserInput("lookup lead", 1);
        UserInput userInput4 = new UserInput("convert lead", 1);
        UserInput userInput5 = new UserInput("show opportunities", null);
        UserInput userInput6 = new UserInput("lookup opportunity", 1);
        UserInput userInput7 = new UserInput("close lost", 1);
        UserInput userInput8 = new UserInput("close won", 1);
        UserInput userInput9 = new UserInput("exit", null);


        assertEquals(userInput.getOrder(), interpretUserInput("create lead").getOrder());
        assertEquals(userInput2.getOrder(), interpretUserInput("show leads").getOrder());

        assertEquals(userInput3.getOrder(), interpretUserInput("lookup lead 1").getOrder());
        assertEquals(userInput3.getId(), interpretUserInput("lookup lead 1").getId());

        assertEquals(userInput4.getOrder(), interpretUserInput("convert lead 1").getOrder());
        assertEquals(userInput4.getId(), interpretUserInput("convert lead 1").getId());

        assertEquals(userInput5.getOrder(), interpretUserInput("show opportunities").getOrder());
        assertEquals(userInput5.getId(), interpretUserInput("show opportunities").getId());

        assertEquals(userInput6.getOrder(), interpretUserInput("lookup opportunity 1").getOrder());
        assertEquals(userInput6.getId(), interpretUserInput("lookup opportunity 1").getId());

        assertEquals(userInput7.getOrder(), interpretUserInput("close lost 1").getOrder());
        assertEquals(userInput7.getId(), interpretUserInput("close lost 1").getId());

        assertEquals(userInput8.getOrder(), interpretUserInput("close won 1").getOrder());
        assertEquals(userInput8.getId(), interpretUserInput("close won 1").getId());

        assertEquals(userInput9.getOrder(), interpretUserInput("exit").getOrder());
        assertNotEquals(userInput9.getOrder(), interpretUserInput("ex1t").getOrder());
    }
}


