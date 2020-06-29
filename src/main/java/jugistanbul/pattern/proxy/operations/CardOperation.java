package jugistanbul.pattern.proxy.operations;

import jugistanbul.pattern.proxy.Account;
import jugistanbul.pattern.proxy.Card;

public interface CardOperation {
    Card giveCard(Account account);
}
