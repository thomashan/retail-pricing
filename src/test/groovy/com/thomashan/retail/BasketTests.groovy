package com.thomashan.retail

import org.junit.Test

class BasketTests {
    @Test
    void testTotal() {
        Basket basket = new Basket()
        basket.products.add(new Product(productType: ProductType.ELECTRONIC, price: 600))
        basket.products.add(new Product(productType: ProductType.GROCERY, price: 30))

        assert 630 == basket.total()
    }

    @Test
    void testTotalDiscountable() {
        Basket basket = new Basket()
        basket.products.add(new Product(productType: ProductType.ELECTRONIC, price: 123))
        basket.products.add(new Product(productType: ProductType.ELECTRONIC, price: 100))
        basket.products.add(new Product(productType: ProductType.GROCERY, price: 30))

        assert 223 == basket.totalDiscountable()
    }
}
