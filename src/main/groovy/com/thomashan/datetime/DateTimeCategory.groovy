package com.thomashan.datetime

import java.time.Duration
import java.time.Period
import java.time.temporal.TemporalAmount

@Category(Number)
class DateTimeCategory {
    static TemporalAmount getYear(Number self) {
        return Period.ofYears(self)
    }

    static TemporalAmount getYears(Number self) {
        return Period.ofYears(self)
    }

    static TemporalAmount getMonth(Number self) {
        return Period.ofMonths(self)
    }

    static TemporalAmount getMonths(Number self) {
        return Period.ofMonths(self)
    }

    static TemporalAmount getD(Number self) {
        return Period.ofDays(self)
    }

    static TemporalAmount getH(Number self) {
        return Duration.ofHours(self)
    }

    static TemporalAmount getMin(Number self) {
        return Duration.ofMinutes(self)
    }

    static TemporalAmount getS(Number self) {
        return Duration.ofSeconds(self)
    }

    static TemporalAmount getNs(Number self) {
        return Duration.ofNanos(self)
    }
}
