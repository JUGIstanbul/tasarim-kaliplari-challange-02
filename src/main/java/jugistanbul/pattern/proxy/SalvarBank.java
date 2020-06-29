package jugistanbul.pattern.proxy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SalvarBank implements Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private Map<Account, Money> moneys = new HashMap<>();

    @Override
    public Account authorize(Credential credential) {
        return accounts.get(credential.getFullname());
    }

    @Override
    public void withdraw(Money amount, Account account) {
        Money money = moneys.get(account);
        moneys.computeIfAbsent(account, m->Money.of(BigDecimal.ZERO));
        moneys.put(account, money.minus(amount));
    }

    @Override
    public void deposit(Money amount, Account account) {
        Money money = moneys.get(account);
        moneys.computeIfAbsent(account, m->Money.of(BigDecimal.ZERO));
        moneys.put(account, money.plus(amount));
    }

    @Override
    public Money displayMyMoney(Account account) {
        Money money = moneys.get(account);
        return money;
    }

    @Override
    public Account register(String firstname, String lastname, String password) {
        Account account = new Account(firstname, lastname, password);
        accounts.put(firstname+" "+lastname, account);
        return account;
    }

    @Override
    public Card giveCard(Account account) {
        Card card = new DebitCard(account, this);
        return card;
    }
}
