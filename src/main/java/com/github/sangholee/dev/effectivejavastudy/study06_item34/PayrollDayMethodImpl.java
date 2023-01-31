package com.github.sangholee.dev.effectivejavastudy.study06_item34;

public enum PayrollDayMethodImpl {
    MONDAY {
        @Override
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay = minutesWorked <= MINS_PER_SHIFT
                    ? 0
                    : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;

            return basePay + overtimePay;
        }
    },
    TUESDAY {
        @Override
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay = minutesWorked <= MINS_PER_SHIFT
                    ? 0
                    : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;

            return basePay + overtimePay;
        }
    },
    WEDNESDAY {
        @Override
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay = minutesWorked <= MINS_PER_SHIFT
                    ? 0
                    : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;

            return basePay + overtimePay;
        }
    },
    THURSDAY {
        @Override
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay = minutesWorked <= MINS_PER_SHIFT
                    ? 0
                    : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;

            return basePay + overtimePay;
        }
    },
    FRIDAY {
        @Override
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay = minutesWorked <= MINS_PER_SHIFT
                    ? 0
                    : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;

            return basePay + overtimePay;
        }
    },
    SATURDAY {
        @Override
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay = basePay / 2;

            return basePay + overtimePay;
        }
    },
    SUNDAY {
        @Override
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay = basePay / 2;

            return basePay + overtimePay;
        }
    };

    private static final int MINS_PER_SHIFT = 8 * 60;

    abstract int pay(int minutesWorked, int payRate);
}
