package com.example.newjiraback.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

class UtDateTest {

    @Test
    void dateNow() {
        OffsetDateTime dateTime = OffsetDateTime.now();
        OffsetDateTime dateNow = UtDate.dateNow();

        Assertions.assertEquals(dateTime.getDayOfMonth(), dateNow.getDayOfMonth());
        Assertions.assertEquals(dateTime.getMonth(), dateNow.getMonth());
        Assertions.assertEquals(dateTime.getYear(), dateNow.getYear());
        Assertions.assertEquals(dateTime.getHour(), dateNow.getHour());
        Assertions.assertEquals(dateTime.getMinute(), dateNow.getMinute());
        Assertions.assertEquals(dateTime.getSecond(), dateNow.getSecond());
    }
}