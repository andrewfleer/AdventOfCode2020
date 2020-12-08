package com.andrewfleer.day4;

import lombok.Data;

@Data
public class Passport {
    private String birthYear;
    private String issueYear;
    private String expirationYear;
    private String height;
    private String hairColor;
    private String eyeColor;
    private String passportId;
    private String countryId;

    public boolean isValid() {
        return (null != birthYear
                && null != issueYear
                && null != expirationYear
                && null != height
                && null != hairColor
                && null != eyeColor
                && null != passportId);
    }
}
