package com.thomashan.retail

import groovy.transform.ToString

import java.time.ZonedDateTime

import static java.time.ZonedDateTime.now

@ToString
class User {
    ZonedDateTime registeredDateTime = now()
    Basket basket = new Basket()
    UserType userType

    BigDecimal getTotal() {
        return basket.total
    }

    BigDecimal getNetPayableAmount() {
        return basket.getNetPayableAmount(userType, new DiscountContext(registeredDateTime))
    }

    void add(Product product) {
        basket.products.add(product)
    }
}
