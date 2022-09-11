package com.example.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Created by qdd on 2022/4/22.
 */
public class MyStepdefs implements En {

    private String today;
    private String actualAnswer;

    final Map<String, Long> users = new HashMap<>();

    public MyStepdefs() {
        users.put("Alice", 1440001L);
        users.put("Bob", 1440002L);
        users.put("Charlie", 1440003L);

        ParameterType("user", "Alice|Bob|Charlie", users::get);

        Given("today is {string}", (String today) -> {
            this.today = today;
        });
        When("^I ask whether it's Friday yet$", () -> {
            actualAnswer = IsItFriday.isItFriday(today);
        });
        Then("I should be told {string}", (String expectedAnswer) -> {
            assertEquals(expectedAnswer, actualAnswer);
        });
        Given("New client {user} has a balance:", (Long clientId, DataTable balance) -> {
            System.out.println(clientId);
        });
    }
}

class IsItFriday {

    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
