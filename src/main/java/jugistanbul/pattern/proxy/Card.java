package jugistanbul.pattern.proxy;

public abstract class Card {

    private final CardNumber number;

    private final String fullname;

    private final Bank bank;

    public Card(CardNumber number, String fullname, Bank bank) {
        this.number = number;
        this.fullname = fullname;
        this.bank = bank;
    }

    public CardNumber getNumber() {
        return number;
    }

    protected Bank getBank() {
        return bank;
    }

    public String getFullname() {
        return fullname;
    }
}
