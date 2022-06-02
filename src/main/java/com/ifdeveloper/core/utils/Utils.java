package com.ifdeveloper.core.utils;

import java.util.Random;
import java.util.UUID;

public class Utils {

    private static final Integer MAX_INT_VALUE = 1000;
    private static final Integer MAX_LONG_VALUE = 5000;

    public static String getUUIDValue() {
        return UUID.randomUUID().toString();
    }

    public static Integer getIntValue() {
        Random random = new Random();
        return random.nextInt(MAX_INT_VALUE);
    }

    public static Long getLongValue() {
        Random random = new Random();
        return Long.valueOf(random.nextInt(MAX_LONG_VALUE));
    }
}
