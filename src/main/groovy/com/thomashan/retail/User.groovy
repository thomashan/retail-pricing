package com.thomashan.retail

import java.time.ZonedDateTime

import static java.time.ZonedDateTime.now

class User {
    ZonedDateTime registeredDateTime = now()
    Basket basket = new Basket()
    UserType userType

    BigDecimal getNetPayableAmount() {
        basket.getNetPayableAmount(userType, new DiscountContext(registeredDateTime))
    }

    void add(Product product) {
        basket.products.add(product)
    }
}
