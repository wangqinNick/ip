package seedu.duck.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * <h3>Date Time</h3>
 * A <b>Date Time</b> contains both <i>date</i> and <i>time</i> information. This is used to hold the <i>datetime</i>
 * information of the task's deadline.
 */
public class DateTime {
    public static final String FORMAT = "<date dd/mm/yyyy> <time hh:mma>";
    public static final String DATE_FORMAT = "dd/MM/yyyy"; // Date format to be displayed
    public static final String TIME_FORMAT = "hh:mma"; // Time format to be displayed

    private static final String DATE_SORT_FORMAT = "yyyyMMdd"; // Date format for sorting
    private static final String TIME_SORT_FORMAT = "HHmm"; // Time format for sorting

    private LocalDate date;
    private LocalTime time;

    public DateTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    /**
     * Returns the <code>date</code> as a string with the format {@value DATE_FORMAT}.
     *
     * @return The <code>date</code> in a string format
     */
    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    /**
     * Returns the <code>time</code> as a string with the format {@value TIME_FORMAT}.
     *
     * @return The <code>time</code> in a string format
     */
    public String getTime() {
        return time.format(DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    /**
     * Returns the <code>date</code> as a string with the format {@value DATE_SORT_FORMAT}.
     * This format is primarily used for sorting tasks by date.
     *
     * @return The <code>date</code> in a string format
     */
    public String getDateInSortFormat() {
        return date.format(DateTimeFormatter.ofPattern(DATE_SORT_FORMAT));
    }

    /**
     * Returns the <code>date</code> as a string with the format {@value TIME_SORT_FORMAT}.
     * This format is primarily used for sorting tasks by time.
     *
     * @return The <code>date</code> in a string format
     */
    public String getTimeInSortFormat() {
        return time.format(DateTimeFormatter.ofPattern(TIME_SORT_FORMAT));
    }

    /**
     * Checks if the <code>date</code> attribute is the same as the specified <code>date</code>.
     * @param date The <i>date</i> in question
     * @return <code>TRUE</code> if <code>date</code> is the same as the specified <code>date</code>, and
     * <code>FALSE</code> otherwise.
     */
    public boolean isOn(LocalDate date) {
        return this.date.isEqual(date);
    }

    /**
     * Checks if the <code>date</code> attribute is before the specified <code>date</code>.
     * @param date The <i>date</i> in question
     * @return <code>TRUE</code> if <code>date</code> is before the specified <code>date</code>, and
     * <code>FALSE</code> otherwise.
     */
    public boolean isBefore(LocalDate date) {
        return this.date.isBefore(date);
    }

    /**
     * Checks if the <code>date</code> attribute is after the specified <code>date</code>.
     * @param date The <i>date</i> in question
     * @return <code>TRUE</code> if <code>date</code> is after the specified <code>date</code>, and
     * <code>FALSE</code> otherwise.
     */
    public boolean isAfter(LocalDate date) {
        return this.date.isAfter(date);
    }

    /**
     * Checks if the <code>time</code> attribute is <b>not</b> <code>NULL</code>.
     *
     * @return <code>TRUE</code> if <code>time</code> is not <code>NULL</code>, and <code>FALSE</code> otherwise.
     */
    private boolean hasTime() {
        return time != null;
    }

    /**
     * Checks if the <code>date</code> is the same as the current day's <i>date</i>.
     *
     * @return <code>TRUE</code> if the <code>date</code> is the same as the current day's <i>date</i>, and
     * <code>FALSE</code> otherwise
     */
    private boolean isToday() {
        return this.date.isEqual(LocalDate.now());
    }

    /**
     * Checks if the <code>date</code> is the same as the next day's <i>date</i>.
     *
     * @return <code>TRUE</code> if the <code>date</code> is the same as the next day's <i>date</i>, and
     * <code>FALSE</code> otherwise
     */
    private boolean isTomorrow() {
        return this.date.minusDays(1).isEqual(LocalDate.now());
    }

    /**
     * Checks if the current <i>date</i> and <i>time</i> have passed the <code>date</code> and <code>time</code>.
     * <br> i.e. The <b>Date Time</b> has expired.
     *
     * @return <code>TRUE</code> if the <b>Date Time</b> has expired, and <code>FALSE</code> otherwise
     */
    private boolean isDue() {
        return LocalDate.now().isAfter(date)
                || (hasTime() && isToday() && LocalTime.now().isAfter(time));
    }

    /**
     * Converts the <code>date</code> into a string format.
     *
     * @return The <code>date</code> in a string format.
     */
    private String dateToString() {
        if (isToday()) {
            return "today";
        } else if (isTomorrow()) {
            return "tomorrow";
        } else {
            return getDate();
        }
    }

    /**
     * Converts the <code>time</code> into a string format.
     * If <code>time</code> is <code>NULL</code>, an empty string is returned instead.
     *
     * @return The <code>time</code> in a string format.
     */
    private String timeToString() {
        return hasTime() ? getTime() : "";
    }

    /**
     * Converts <b>Date Time</b> into its string representation, containing its <code>date</code> and
     * <code>time</code> information, and an indicator to show if the datetime has already passed.
     *
     * @return The string representation of <b>Date Time</b>
     */
    public String toShow() {
        var toShow = dateToString() + " " + timeToString();
        return (isDue()) ? toShow + " [OVER!!]" : toShow;
    }


    /**
     * Converts <b>Date Time</b> into its string representation, containing its <code>date</code> and
     * <code>time</code> information, and an indicator to show if the datetime has already passed.
     *
     * @return The string representation of <b>Date Time</b>
     */
    @Override
    public String toString() {
        return getDate() + " " + timeToString();
    }

}
