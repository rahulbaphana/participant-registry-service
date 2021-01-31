package com.participant.registry.support;

import com.participant.registry.domain.participant.exception.InvalidDateOfBirthFormatException;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateUtil {
    private static final SimpleDateFormat dd_MM_yyyy_Z = new SimpleDateFormat("dd-MM-yyyy Z");
    private static final SimpleDateFormat dd_MM_yyyy = new SimpleDateFormat("dd-MM-yyyy");

    public static Date dateOfBirthFormat(String dateOfBirth) {
        try {
            return dd_MM_yyyy_Z.parse(dateOfBirth + " UTC");
        } catch (ParseException e) {
            throw new InvalidDateOfBirthFormatException("Invalid date of birth : " + dateOfBirth);
        }
    }

    public static String stringForDateOfBirthFormat(Date dateOfBirth) {
        return dd_MM_yyyy.format(dateOfBirth);
    }
}
