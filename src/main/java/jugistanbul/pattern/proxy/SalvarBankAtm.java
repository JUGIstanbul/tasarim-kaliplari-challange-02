package jugistanbul.pattern.proxy;

import jugistanbul.pattern.proxy.operations.MoneyOperation;

import static java.util.Objects.nonNull;

public class SalvarBankAtm implements MoneyOperation {

    private SalvarBank salvarBank;

    private Account loggedInAccount;

    public SalvarBankAtm(SalvarBank salvarBank) {

        this.salvarBank = salvarBank;
    }

    @Override
    public void withdraw(Money amount, Account account) {

    }

    @Override
    public void deposit(Money amount, Account account) {

    }

    public boolean insertCard(Card card, String password) {
        loggedInAccount = salvarBank.authorize(new Credential(card.getFullname(), password));
        return nonNull(loggedInAccount);
    }

    @Override
    public Money displayMyMoney(Account account) {
        salvarBank.displayMyMoney(account);
    }
}
