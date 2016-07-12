package com.thomashan.retail

interface Discount {
    BigDecimal calculateDiscount(BigDecimal amount, DiscountContext discountContext)
}
