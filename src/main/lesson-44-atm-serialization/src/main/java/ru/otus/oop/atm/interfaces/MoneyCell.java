package ru.otus.oop.atm.interfaces;

import ru.otus.oop.atm.dictionary.Denomination;

import java.io.Serializable;

public interface MoneyCell extends Serializable {
    Denomination cellDenomination();

    void putMoney(int amount) throws Exception;

    boolean canPut(int amount);

    void getMoney(int amount) throws Exception;

    boolean canGet(int amount);

    String getState();

    void setState(String state);
}
