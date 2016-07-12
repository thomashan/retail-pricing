package com.thomashan.retail

import org.junit.Test

import static java.time.ZonedDateTime.now

class UserTypeTests {
    @Test
    void testEmployee_ShouldReceive30PercentDiscount() {
        assert 3 == UserType.EMPLOYEE.calculateDiscount(10, null)
    }

    @Test
    void testAffiliate_ShouldReceive10PercentDiscount() {
        assert 1 == UserType.AFFILIATE.calculateDiscount(10, null)
    }

    @Test
    void testNormal_ShouldReceive5PercentDiscount_IfRegisteredForMoreThanTwoYears() {
        DiscountContext discountContext = new DiscountContext(now() - 2.years)

        assert 0.5 == UserType.NORMAL.calculateDiscount(10, discountContext)
    }

    @Test
    void testNormal_ShouldReceiveZeroDiscountForAmountLessThan100Dollars_IfRegisteredForTwoYears() {
        DiscountContext discountContext = new DiscountContext(now())

        assert 0 == UserType.NORMAL.calculateDiscount(10, discountContext)
    }

    @Test
    void testNormal_ShouldReceive5DollarDiscountFor100Dollars_IfRegisteredForLessThanTwoYears() {
        DiscountContext discountContext = new DiscountContext(now())

        assert 5 == UserType.NORMAL.calculateDiscount(100, discountContext)
    }
}
