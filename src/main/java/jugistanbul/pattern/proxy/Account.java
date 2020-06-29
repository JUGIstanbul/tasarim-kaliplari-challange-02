package jugistanbul.pattern.proxy;

public class Account {

    private final String firstname;
    private final String lastname;
    private final String password;
    private Card card;

    public Account(String firstname, String lastname, String password) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public void assignCard(Card card) {
        this.card = card;
    }

    public String getFullname() {
        return firstname +" "+ lastname;
    }
}
