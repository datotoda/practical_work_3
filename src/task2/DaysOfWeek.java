package task2;

import java.util.ArrayList;
import java.util.List;

public enum DaysOfWeek {
    MONDAY("ორშ", "ორშაბათი", 1),
    TUESDAY("სამ", "სამშაბათი", 2),
    WEDNESDAY("ოთხ", "ოთხშაბათი", 3),
    THURSDAY("ხუთ", "ხუთშაბათი", 4),
    FRIDAY("პარ", "პარასკევი", 5),
    SATURDAY("შაბ", "შაბათი", 6),
    SUNDAY("კვ", "კვირა", 7);

    public final String shortValue;
    private final String geoValue;
    private final Integer dayNumber;

    DaysOfWeek(String shortValue, String geoValue, Integer dayNumber) {
        this.shortValue = shortValue;
        this.geoValue = geoValue;
        this.dayNumber = dayNumber;
    }

    public DaysOfWeek getNextDay() { return this.getDaysOfWeekByDayNumber(this.dayNumber + 1); }
    public DaysOfWeek getPreviousDay() { return this.getDaysOfWeekByDayNumber(this.dayNumber - 1); }
    public boolean isWeekend() { return this.equals(DaysOfWeek.SATURDAY) || this.equals(DaysOfWeek.SUNDAY); }

    public static void describeDay(DaysOfWeek day) {
        switch (day) {
            case MONDAY:
                System.out.println("ორშაბათი");
                break;
            case TUESDAY:
                System.out.println("სამშაბათი");
                break;
            case WEDNESDAY:
                System.out.println("ოთხშაბათი");
                break;
            case THURSDAY:
                System.out.println("ხუთშაბათი");
                break;
            case FRIDAY:
                System.out.println("პარასკევი");
                break;
            case SATURDAY:
                System.out.println("შაბათი");
                break;
            case SUNDAY:
                System.out.println("კვირა");
                break;
        }
    }

    public static void printWeekdays() {
        List<DaysOfWeek> list = new ArrayList<>();
        list.add(DaysOfWeek.MONDAY);
        list.add(DaysOfWeek.TUESDAY);
        list.add(DaysOfWeek.WEDNESDAY);
        list.add(DaysOfWeek.THURSDAY);
        list.add(DaysOfWeek.FRIDAY);

        for (DaysOfWeek daysOfWeek : list) {
            System.out.println(daysOfWeek.geoValue);
        }
    }

    public static void printWeekends() {
        List<DaysOfWeek> list = new ArrayList<>();
        list.add(DaysOfWeek.SATURDAY);
        list.add(DaysOfWeek.SUNDAY);

        for (DaysOfWeek daysOfWeek : list) {
            System.out.println(daysOfWeek.geoValue);
        }
    }

    private DaysOfWeek getDaysOfWeekByDayNumber(Integer i) {
        switch (i % 7) {
            case 0: return DaysOfWeek.SUNDAY;
            case 1: return DaysOfWeek.MONDAY;
            case 2: return DaysOfWeek.TUESDAY;
            case 3: return DaysOfWeek.WEDNESDAY;
            case 4: return DaysOfWeek.THURSDAY;
            case 5: return DaysOfWeek.FRIDAY;
            case 6: return DaysOfWeek.SATURDAY;
        }
        return DaysOfWeek.MONDAY;
    }
}
