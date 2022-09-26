package ru.otus.oop.atm;

import ru.otus.oop.atm.impl.AutomatedTellerMachine;
import ru.otus.oop.atm.interfaces.ATM;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        ATM atm = new AutomatedTellerMachine();

        try {
            atm.saveState();
        } catch (IOException e) {
            e.printStackTrace();
        }

        atm.accountState().printState();

        try {
            atm.withdraw(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        atm.accountState().printState();

        try {
            atm.saveStateViaJackson();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
