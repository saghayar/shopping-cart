package task.supermarket.shoppingcart;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public enum OfferStrategy {
    BUY_2_GET_1_FREE {
        @Override
        BigDecimal execute(CartItem item, Integer quantity) {
            return item.getPrice()
                       .multiply(BigDecimal.valueOf(quantity / 3));
        }
    },

    BUY_1_GET_HALF_OFF {
        @Override
        BigDecimal execute(CartItem item, Integer quantity) {
            BigDecimal divide = new BigDecimal(quantity / 2)
                    .divide(new BigDecimal(2), new MathContext(2, RoundingMode.HALF_UP));
            return item.getPrice().multiply(divide);
        }
    };

    abstract BigDecimal execute(CartItem item, Integer quantity);
}
