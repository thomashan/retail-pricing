package com.thomashan.retail

import groovy.util.logging.Slf4j

import java.math.MathContext
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

import static java.time.ZonedDateTime.now

@Slf4j
class Demo {
    static void main(String[] args) {
        new Demo().run()
    }

    void run() {
        ZonedDateTime now = now()
        User user = new User()
        user.userType = UserType.random
        user.registeredDateTime = randomZonedDateTime(now - 4.years, now)

        randomNumber(4, 10).toInteger().times {
            Product product = new Product()
            product.price = BigDecimal.valueOf(randomNumber(10, 100)).round(new MathContext(2))
            product.productType = ProductType.random

            user.add(product)
        }

        log.info("User: $user")
        user.basket.products.each { product ->
            log.info("Product: $product")
        }
        log.info("Total: ${user.total}")
        log.info("Net payable amount: ${user.netPayableAmount}")
    }

    private static Double randomNumber(double min, double max) {
        Random random = new Random()

        return (max - min) * random.nextDouble() + min
    }

    private static ZonedDateTime randomZonedDateTime(ZonedDateTime min, ZonedDateTime max) {
        Instant random = Instant.ofEpochSecond(randomNumber(min.toEpochSecond(), max.toEpochSecond()).toLong());

        return ZonedDateTime.ofInstant(random, ZoneId.systemDefault())
    }
}
