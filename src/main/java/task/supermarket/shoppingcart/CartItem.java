package task.supermarket.shoppingcart;

import java.math.BigDecimal;

public interface CartItem {
    String getName();

    BigDecimal getPrice();

    BigDecimal getDiscount();

    void setDiscount(BigDecimal discount);
}
