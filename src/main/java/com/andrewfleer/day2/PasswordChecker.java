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

            int validPasswords = findValidPasswords(inputs);

            System.out.println(validPasswords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findValidPasswords(List<String> inputs) {
        int validPasswords = 0;
        for (String input : inputs) {
            String[] params = input.split(" ");
            String requirements = params[0];
            String letter = params[1];
            String password = params[2];

            String[] minAndMax = requirements.split("-");
            letter = letter.substring(0,1);

            if (isPasswordValid(letter, password, minAndMax)) {
                validPasswords++;
            }
        }

        return validPasswords;
    }

    public static boolean isPasswordValid(String letter, String password, String[] minAndMax) {
        boolean passwordValid = false;
        int min = Integer.parseInt(minAndMax[0]);
        int max = Integer.parseInt(minAndMax[1]);

        int count = StringUtils.countOccurrencesOf(password, letter);

        if (count >= min && count <= max) {
            passwordValid = true;
        }

        return passwordValid;
    }
}
