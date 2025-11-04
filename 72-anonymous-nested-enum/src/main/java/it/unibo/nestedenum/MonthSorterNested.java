package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    public enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        Month(final int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }

        public static Month fromString(final String month) {
            ArrayList<Month> monthArray = new ArrayList<>();
            String input;
            
            if (month == null) {
                throw new IllegalArgumentException("month cannot be null");
            } else {
                input = month.trim().toUpperCase();
                for (Month e : Month.values()) {
                    if (e.toString().startsWith(input)) {
                        monthArray.add(e);
                    };
                }
                if (monthArray.size() == 0) {
                    throw new IllegalArgumentException("as no month with such name");
                } else if (monthArray.size() > 1) {
                    throw new IllegalArgumentException("there are many months starts with " +  month);
                } else {
                    return monthArray.getFirst();
                }
            }
            // todo mettere gli else
     
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return  (m1, m2) -> {
            try {
                Month M1 = Month.fromString(m1);
                Month M2 = Month.fromString(m2);
                return Integer.compare(M1.days, M2.days);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid month name", e);
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return  (m1, m2) -> {
            try {
                Month M1 = Month.fromString(m1);
                Month M2 = Month.fromString(m2);
                return Integer.compare(M1.ordinal(), M2.ordinal());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid month name", e);
            }
        };
    }
}
