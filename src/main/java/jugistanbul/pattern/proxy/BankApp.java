package jugistanbul.pattern.proxy;

import java.math.BigDecimal;

public class BankApp {
    private static final String PASSWORD = "123456";
    public static void main(String[] args) {
        var salvarBank = new SalvarBank();
        var salvarBankAtm = new SalvarBankAtm(salvarBank);
        var accountForTaner = salvarBank.register("Taner","Diler", PASSWORD);
        var cardOfTaner = salvarBank.giveCard(accountForTaner);

        salvarBankAtm.insertCard(cardOfTaner, PASSWORD);
        salvarBankAtm.deposit(Money.of(BigDecimal.valueOf(1000d)), accountForTaner);
        salvarBankAtm.deposit(Money.of(BigDecimal.valueOf(500d)), accountForTaner);
        salvarBankAtm.withdraw(Money.of(BigDecimal.valueOf(300d)), accountForTaner);
        Money money = salvarBankAtm.displayMyMoney(accountForTaner);

        System.out.println("");

    }
}
