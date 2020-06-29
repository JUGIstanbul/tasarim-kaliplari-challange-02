package jugistanbul.pattern.proxy.operations;

import jugistanbul.pattern.proxy.Account;
import jugistanbul.pattern.proxy.Money;

public interface MoneyOperation {
    void withdraw(Money amount, Account account);

    void deposit(Money amount, Account account);

    Money displayMyMoney(Account account);
}
