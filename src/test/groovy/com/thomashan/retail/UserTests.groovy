package com.thomashan.retail

import org.junit.Before
import org.junit.Test

import static java.time.ZonedDateTime.now

class UserTests {
    private User user

    @Before
    void setUp() {
        user = new User()
        user.add(new Product(productType: ProductType.ELECTRONIC, price: 25))
        user.add(new Product(productType: ProductType.ELECTRONIC, price: 50))
        user.add(new Product(productType: ProductType.GROCERY, price: 200))
        user.add(new Product(productType: ProductType.ELECTRONIC, price: 75))
    }

    @Test
    void testEmployee() {
        user.userType = UserType.EMPLOYEE

        assert 305 == user.netPayableAmount
    }

    @Test
    void testAffiliate() {
        user.userType = UserType.AFFILIATE

        assert 335 == user.netPayableAmount
    }

    @Test
    void testNormal_Valued() {
        user.userType = UserType.NORMAL
        user.registeredDateTime = now() - 2.years

        assert 342.5 == user.netPayableAmount
    }

    @Test
    void testNormal_Recent() {
        user.userType = UserType.NORMAL
        user.registeredDateTime = now()

        assert 345 == user.netPayableAmount
    }
}
