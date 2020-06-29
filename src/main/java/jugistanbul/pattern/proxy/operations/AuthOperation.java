package jugistanbul.pattern.proxy.operations;

import jugistanbul.pattern.proxy.Account;
import jugistanbul.pattern.proxy.Credential;

public interface AuthOperation {

    Account authorize(Credential credential);
}
