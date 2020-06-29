package jugistanbul.pattern.proxy;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal amount = new BigDecimal(0);

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Money minus(Money money) {
        return Money.of(amount.subtract(money.amount));
    }

    public Money plus(Money money) {
        return Money.of(amount.add(money.amount));
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
