package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void greetingShouldContainNameAndVersion() {
        String result = App.getGreeting("Aerika");
        // Adjust version if you change it in App.java
        assertEquals("Hello, Aerika! - demo-java-app v1.3", result);
    }
}
