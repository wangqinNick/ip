package seedu.duck.parser;

import seedu.duck.exception.ParseException;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.duck.util.Message.MESSAGE__NOT_STANDARD_TIME_FORMAT;


public class ParseTime {
    public static final String REGEX = "-";
    private static final int BY_INDEX = 3;
    private static final int DAY_INDEX = 0;
    private static final int MONTH_INDEX = 1;
    private static final int YEAR_INDEX = 2;

    /**
     * Parses user input into command for execution.
     *
     * @param timeString time YYYY-MM-DD in string format
     * @return Date object
     */
    public static LocalDate parseStringToLocalTime(String timeString) {
        Pattern pattern = Pattern.compile("[0-9][0-9][0-9][0-9]-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])");
        timeString = timeString.substring(BY_INDEX);
        Matcher matcher = pattern.matcher(timeString);
        LocalDate localDate = null;
        try {
            // check if format is correct
            if (!matcher.matches()){
                throw new ParseException(MESSAGE__NOT_STANDARD_TIME_FORMAT);
            } else {
                //parse
                String[] str = timeString.split(REGEX);
                localDate = LocalDate.of(Integer.parseInt(str[DAY_INDEX]),
                        Integer.parseInt(str[MONTH_INDEX]),
                        Integer.parseInt(str[YEAR_INDEX]));
            }
        } catch (ParseException pe) {
            System.out.println(MESSAGE__NOT_STANDARD_TIME_FORMAT);
        }
        return localDate;
    }
}
