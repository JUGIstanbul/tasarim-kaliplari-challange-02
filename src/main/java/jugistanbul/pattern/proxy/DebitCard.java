package jugistanbul.pattern.proxy;

public class DebitCard extends Card {

    public DebitCard(Account account, Bank bank) {
        super(CardNumber.generate(), account.getFullname(), bank);
    }

}
