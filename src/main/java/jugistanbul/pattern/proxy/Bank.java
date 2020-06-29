package jugistanbul.pattern.proxy;

import jugistanbul.pattern.proxy.operations.AccountOperation;
import jugistanbul.pattern.proxy.operations.AuthOperation;
import jugistanbul.pattern.proxy.operations.CardOperation;
import jugistanbul.pattern.proxy.operations.MoneyOperation;

public interface Bank extends AccountOperation, MoneyOperation, AuthOperation, CardOperation {

}
