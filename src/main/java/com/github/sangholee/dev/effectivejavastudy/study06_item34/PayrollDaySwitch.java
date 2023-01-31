package com.github.sangholee.dev.effectivejavastudy.study06_item34;

public enum PayrollDaySwitch {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay = switch (this) {
            case SATURDAY, SUNDAY -> basePay / 2;
            default -> minutesWorked <= MINS_PER_SHIFT
                    ? 0
                    : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        };

        return basePay + overtimePay;
    }

}
