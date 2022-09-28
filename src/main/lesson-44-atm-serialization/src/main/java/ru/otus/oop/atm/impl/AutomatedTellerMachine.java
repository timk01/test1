package ru.otus.oop.atm.impl;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.otus.oop.atm.dictionary.Denomination;
import ru.otus.oop.atm.impl.money.cell.*;
import ru.otus.oop.atm.interfaces.ATM;
import ru.otus.oop.atm.interfaces.AccountState;
import ru.otus.oop.atm.interfaces.MoneyCell;
import ru.otus.oop.atm.util.BanknotesNumber;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AutomatedTellerMachine implements ATM {
    private final AccountState state = new AccountStateImpl();
    private final List<MoneyCell> cells = new ArrayList<>();

    public AutomatedTellerMachine() {
        cells.add(new FiftyMoneyCell(10));
        cells.add(new HundredMoneyCell(10));
        cells.add(new TwoHundredMoneyCell(10));
        cells.add(new FiveHundredMoneyCell(10));
        cells.add(new ThousandMoneyCell(10));
        cells.add(new TwoThousandMoneyCell(10));
        cells.add(new FiveThousandMoneyCell(10));
    }

    @Override
    public void withdraw(int amount) {
        if (state.availableAmount() > amount) {

            List<BanknotesNumber> banknotes = new ArrayList<>();
            for (Denomination value : Denomination.values()) {
                int number = amount / value.getMultiplier();
                banknotes.add(new BanknotesNumber(number, value));
            }

            banknotes.sort(Comparator.comparingInt(BanknotesNumber::getBanknotes));

            List<BanknotesNumber> availableBanknotes = banknotes.stream().filter(banknotesNumber -> banknotesNumber.getBanknotes() > 0).toList();

        }
        // TODO проверка наличия купюр в ячейках и печать сколько каких купюр выдано.
    }

    @Override
    public void depositMoney(Denomination denomination, int amount) {

    }

    @Override
    public AccountState accountState() {
        return state;
    }

    @Override
    public void saveState() throws IOException {
        List<String> cellStates = cells.stream()
                .map(moneyCell -> moneyCell.getState())
                .toList();

        Path path = Paths.get("state_non_serialized.txt");
        Files.write(path, cellStates);
    }

    @Override
    public void saveStateViaJackson() throws IOException {
        List<String> cellStates = cells.stream()
                .map(moneyCell -> moneyCell.getState())
                .toList();

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(Paths.get("state_non_serialized_2.txt").toFile(), cellStates);
    }



    @Override
    public void loadState() {
        cells.forEach(MoneyCell::getState);
    }
}
