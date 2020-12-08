package com.andrewfleer.day4;

import com.andrewfleer.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PassportChecker {
    private static final String fileName = "day4Input.txt";

    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();

        try {
            List inputs = fileUtil.readFileToList(fileName);

            List<Passport> passports = createPassports(inputs);

            int validPassports = getValidPassports(passports);

            System.out.println(validPassports);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getValidPassports(List<Passport> passports) {
        int validPassports = 0;

        if (passports != null && !passports.isEmpty()) {
            for (Passport passport : passports) {
                if (passport.isValid()) {
                    validPassports++;
                }
            }
        }

        return validPassports;
    }

    private static List<Passport> createPassports(List<String> inputs) {
        List<Passport> passports = new ArrayList<Passport>();
        List<String> passportData = new ArrayList<String>();
        if (null != inputs && !inputs.isEmpty()) {
            for (String input : inputs) {
                if (null != input && !input.isEmpty()) {
                    passportData.add(input);
                } else {
                    Passport passport = createPassport(passportData);
                    passports.add(passport);
                    passportData.clear();
                }
            }
        }

        //Build that final passport
        Passport passport = createPassport(passportData);
        passports.add(passport);

        return passports;
    }

    private static Passport createPassport(List<String> passportData) {
        Passport passport = new Passport();
        if (null != passportData && !passportData.isEmpty()) {
            for (String tempString : passportData) {
                String[] strings = tempString.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    String datum = strings[i];
                    String[] splitDatum = datum.split(":");
                    String key = splitDatum[0];
                    String value = splitDatum[1];

                    PassportDatum passportDatum = PassportDatum.valueOf(key.toUpperCase());
                    switch(passportDatum) {
                        case CID:
                            passport.setCountryId(value);
                            break;
                        case PID:
                            passport.setPassportId(value);
                            break;
                        case BYR:
                            passport.setBirthYear(value);
                            break;
                        case IYR:
                            passport.setIssueYear(value);
                            break;
                        case EYR:
                            passport.setExpirationYear(value);
                            break;
                        case HGT:
                            passport.setHeight(value);
                            break;
                        case HCL:
                            passport.setHairColor(value);
                            break;
                        case ECL:
                            passport.setEyeColor(value);
                            break;
                        default:
                            break;
                    }

                }
            }
        }

        return passport;
    }
}
