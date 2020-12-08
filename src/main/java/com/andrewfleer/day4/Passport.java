package com.andrewfleer.day4;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Data
public class Passport {
    private Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private Pattern hexPattern = Pattern.compile("^\\#[\\da-f]{6}");

    private String birthYear;
    private String issueYear;
    private String expirationYear;
    private String height;
    private String hairColor;
    private String eyeColor;
    private String passportId;
    private String countryId;

    public boolean isValid() {
        return (validBirthYear()
                && validIssueYear()
                && validExpirationYear()
                && validHeight()
                && validHairColor()
                && validEyeColor()
                && validPassportId());
    }

    private boolean validBirthYear() {
        boolean valid = false;
        try {
            int intValue = Integer.parseInt(birthYear);

            if (intValue >= 1920 && intValue <= 2002) {
                valid = true;
            }
        } catch(Exception e) {
            // do nothing
        }

        return valid;
    }

    private boolean validIssueYear() {
        boolean valid = false;
        try {
            int intValue = Integer.parseInt(issueYear);

            if (intValue >= 2010 && intValue <= 2020) {
                valid = true;
            }
        } catch(Exception e) {
            // do nothing
        }

        return valid;
    }

    private boolean validExpirationYear() {
        boolean valid = false;
        try {
            int intValue = Integer.parseInt(expirationYear);

            if (intValue >= 2020 && intValue <= 2030) {
                valid = true;
            }
        } catch(Exception e) {
            // do nothing
        }

        return valid;
    }

    private boolean validHeight() {
        boolean valid = false;
        if (height != null) {

            int heightDigits = Integer.parseInt(height.replaceAll("[\\D]", ""));
            String measurement = height.substring(height.length() - 2);
            if (numberPattern.matcher(measurement).matches()) {
                return valid;
            }
            HeightValue heightValue = HeightValue.valueOf(measurement.toUpperCase());

            switch (heightValue) {
                case CM:
                    if (heightDigits >= 150 && heightDigits <= 193) {
                        valid = true;
                    }
                    break;
                case IN:
                    if (heightDigits >= 59 && heightDigits <= 76) {
                        valid = true;
                    }
                    break;
                default:
                    valid = false;
            }
        }

        return valid;
    }

    private boolean validHairColor() {
        return null != hairColor
                && hairColor.length() == 7
                && hexPattern.matcher(hairColor).matches();
    }

    private boolean validEyeColor() {
        try {
            return null != eyeColor
                    && null != EyeColor.valueOf(eyeColor.toUpperCase());
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validPassportId() {
        return null != passportId
                && passportId.length() == 9
                && numberPattern.matcher(passportId).matches();
    }
}
