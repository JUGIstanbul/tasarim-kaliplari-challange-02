package jugistanbul.pattern.proxy;

public class Credential {

    private final String fullname;
    private final String password;

    public Credential(String fullname, String password) {
        this.fullname = fullname;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }
}