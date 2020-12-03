package com.andrewfleer.day2;

import com.andrewfleer.utils.FileUtil;
import org.springframework.util.StringUtils;

import java.util.List;

public class PasswordChecker {
    private static final String fileName = "day2Input.txt";

    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();

        try {
            List inputs = fileUtil.readFileToList(fileName);

            //int validPasswords = findValidPasswordsPart1(inputs);
            int validPasswords = findValidPasswordsPart2(inputs);

            System.out.println(validPasswords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findValidPasswordsPart1(List<String> inputs) {
        int validPasswords = 0;
        for (String input : inputs) {
            String[] params = input.split(" ");
            String requirements = params[0];
            String letter = params[1];
            String password = params[2];

            String[] minAndMax = requirements.split("-");
            letter = letter.substring(0,1);

            if (isPasswordValidPart1(letter, password, minAndMax)) {
                validPasswords++;
            }
        }

        return validPasswords;
    }

    public static boolean isPasswordValidPart1(String letter, String password, String[] minAndMax) {
        boolean passwordValid = false;
        int min = Integer.parseInt(minAndMax[0]);
        int max = Integer.parseInt(minAndMax[1]);

        int count = StringUtils.countOccurrencesOf(password, letter);

        if (count >= min && count <= max) {
            passwordValid = true;
        }

        return passwordValid;
    }

    private static int findValidPasswordsPart2(List<String> inputs) {
        int validPasswords = 0;
        for (String input : inputs) {
            String[] params = input.split(" ");
            String requirements = params[0];
            String letter = params[1];
            String password = params[2];

            String[] positions = requirements.split("-");
            letter = letter.substring(0,1);

            if (isPasswordValidPart2(letter, password, positions)) {
                validPasswords++;
            }
        }

        return validPasswords;
    }

    public static boolean isPasswordValidPart2(String letter, String password, String[] positions) {
        boolean passwordValid = false;
        int firstPosition = Integer.parseInt(positions[0]);
        int secondPosition = Integer.parseInt(positions[1]);
        char character = letter.charAt(0);

        // First make sure the password is long enough
        // If not, assume false;
        if (password.length() < secondPosition) {
            return passwordValid;
        }

        // Have to subtract 1, because the input is not zero-indexed
        // also ^ is an XOR operator
        if ((password.charAt(firstPosition - 1) == character) ^
                (password.charAt(secondPosition - 1) == character)) {
            passwordValid = true;
        }


        return passwordValid;
    }
}
