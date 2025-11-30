package com.example;

public class App {

    private static final String VERSION = "1.3";

    public static void main(String[] args) {
        // If user passes a name, greet that person; else use "World"
        String name = (args.length > 0) ? args[0] : "World";
        System.out.println(getGreeting(name));
    }

    // New feature: returns a greeting message with version info
    public static String getGreeting(String name) {
        return "Hello, " + name + "! - demo-java-app v" + VERSION;
    }
}
