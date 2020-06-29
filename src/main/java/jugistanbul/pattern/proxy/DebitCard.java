package jugistanbul.pattern.proxy;

public class DebitCard extends Card {

    private Account account;

    public DebitCard(Account account, Bank bank) {
        super(CardNumber.generate(), bank);
        this.account = account;
    }

    @Override
    public void withdraw(Money money) {
        getBank().withdraw(money);
    }

    @Override
    public void deposit(Money money) {
        getBank().deposit(money);
    }
}
