package com.thomashan.retail

class Basket {
    List<Product> products = []

    BigDecimal total() {
        return products.sum { it.price }
    }

    BigDecimal totalDiscountable() {
        return products.findAll { it.productType != ProductType.GROCERY }.sum { it.price }
    }
}
