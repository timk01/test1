package ru.otus.oop.atm.interfaces;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.otus.oop.atm.dictionary.Denomination;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.List;

public interface ATM extends Serializable {
    void withdraw(int amount);

    void depositMoney(Denomination denomination, int amount);

    AccountState accountState();

    void saveState() throws IOException;

    void loadState();

    void saveStateViaJackson() throws IOException;
}
