package com.thomashan.retail

class Basket {
    List<Product> products = []

    BigDecimal getTotal() {
        return products.sum { it.price }
    }

    BigDecimal getTotalDiscountable() {
        return products.findAll { it.productType != ProductType.GROCERY }.sum { it.price }
    }

    BigDecimal getNetPayableAmount(UserType customerType, DiscountContext discountContext) {
        return total - customerType.calculateDiscount(totalDiscountable, discountContext)
    }
}
