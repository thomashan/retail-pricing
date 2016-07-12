package com.thomashan.retail

import org.junit.Test

import java.time.ZonedDateTime

class CustomerTypeTests {
    @Test
    void testEmployee_ShouldReceive30PercentDiscount() {
        assert 3 == CustomerType.EMPLOYEE.calculateDiscount(10, null)
    }

    @Test
    void testAffiliate_ShouldReceive10PercentDiscount() {
        assert 1 == CustomerType.AFFILIATE.calculateDiscount(10, null)
    }

    @Test
    void testNormal_ShouldReceive5PercentDiscount_IfRegisteredForMoreThanTwoYears() {
        DiscountContext discountContext = new DiscountContext(ZonedDateTime.now().minusYears(2))

        assert 0.5 == CustomerType.NORMAL.calculateDiscount(10, discountContext)
    }

    @Test
    void testNormal_ShouldReceiveZeroDiscountForAmountLessThan100Dollars_IfRegisteredForTwoYears() {
        DiscountContext discountContext = new DiscountContext(ZonedDateTime.now())

        assert 0 == CustomerType.NORMAL.calculateDiscount(10, discountContext)
    }

    @Test
    void testNormal_ShouldReceive5DollarDiscountFor100Dollars_IfRegisteredForLessThanTwoYears() {
        DiscountContext discountContext = new DiscountContext(ZonedDateTime.now())

        assert 5 == CustomerType.NORMAL.calculateDiscount(100, discountContext)
    }
}
