package com.thomashan.retail

import java.time.ZonedDateTime

enum CustomerType implements Discount {
    EMPLOYEE{
        @Override
        BigDecimal calculateDiscount(BigDecimal amount, DiscountContext discountContext) {
            return 0.3 * amount
        }
    },
    AFFILIATE{
        @Override
        BigDecimal calculateDiscount(BigDecimal amount, DiscountContext discountContext) {
            return 0.1 * amount
        }
    },
    NORMAL{
        @Override
        BigDecimal calculateDiscount(BigDecimal amount, DiscountContext discountContext) {
            if (discountContext.registrationDateTime < ZonedDateTime.now().minusYears(2)) {
                return 0.05 * amount
            }

            return (amount.toInteger() / 100).toInteger() * 5
        }
    }

    abstract BigDecimal calculateDiscount(BigDecimal amount, DiscountContext discountContext)
}
