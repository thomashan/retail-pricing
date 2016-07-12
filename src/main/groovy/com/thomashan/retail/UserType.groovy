package com.thomashan.retail

import static java.time.ZonedDateTime.now

enum UserType implements Discount {
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
            if (discountContext.registrationDateTime < now() - 2.years) {
                return 0.05 * amount
            }

            return (amount.toInteger() / 100).toInteger() * 5
        }
    }

    abstract BigDecimal calculateDiscount(BigDecimal amount, DiscountContext discountContext)

    static UserType getRandom() {
        return UserType.values()[new Random().nextInt(UserType.values().size())]
    }
}
