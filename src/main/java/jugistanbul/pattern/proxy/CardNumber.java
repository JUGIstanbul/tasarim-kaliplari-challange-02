package jugistanbul.pattern.proxy;

import java.util.Objects;
import java.util.UUID;

public class CardNumber {

    private String number;

    public CardNumber(String number) {
        this.number = number;
    }

    public static CardNumber generate() {
        return new CardNumber(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardNumber that = (CardNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
