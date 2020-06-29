package jugistanbul.pattern.proxy.operations;

import jugistanbul.pattern.proxy.Account;

public interface AccountOperation {

    Account register(String firstname, String lastname, String password);
}
