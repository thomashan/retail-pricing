package com.thomashan.retail

import groovy.transform.TupleConstructor

import java.time.ZonedDateTime

@TupleConstructor
class DiscountContext {
    final ZonedDateTime registrationDateTime
}
