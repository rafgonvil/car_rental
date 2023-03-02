package com.rent.car.api.utils;

public enum CarType {
    PREMIUM("Premium"),
    SUV("Suv"),
    SMALL("small");

    private final String value;

    CarType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CarType fromValue(String v) {
        for (CarType c : CarType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
