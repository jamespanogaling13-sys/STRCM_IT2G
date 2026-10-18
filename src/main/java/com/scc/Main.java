package com.scc;

import com.scc.dao.UserDao;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserDao userDao = new UserDao();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=========================================");
            System.out.println("SMART TRUCK RENTAL & CARGO MATCHING SYSTEM");
            System.out.println("=========================================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        System.out.print("Select Role [1] OWNER | [2] SHIPPER | [3] ADMIN: ");
        int roleChoice;
        try {
            roleChoice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            roleChoice = 0;
        }

        String role;
        switch (roleChoice) {
            case 1:
                role = "OWNER";
                break;
            case 2:
                role = "SHIPPER";
                break;
            case 3:
                role = "ADMIN";
                break;
            default:
                role = null;
        }

        if (role != null) {
            userDao.registerUser(username, pass, role);
        } else {
            System.out.println("Invalid role selection!");
        }
    }

    private static void login() {
        System.out.println("Login coming soon...");
    }
}