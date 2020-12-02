package com.andrewfleer.day1;

import com.andrewfleer.utils.FileUtil;

import java.util.List;

public class RepairReport {
    private static final String fileName = "day1Input.txt";
    public static void main (String[] args) {
        FileUtil fileUtil = new FileUtil();

        try {
            List inputs = fileUtil.readFileToList(fileName);
            Integer[] desiredNumbers = findNumbersThatEqualSum(inputs, 2020);
            if(desiredNumbers != null) {
                Integer product = multiplyFoundNumbers(desiredNumbers);
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer multiplyFoundNumbers(Integer[] desiredNumbers) {
        return desiredNumbers[0] * desiredNumbers[1];
    }

    private static Integer[] findNumbersThatEqualSum(List inputs, int desiredValue) {
        Object[] inputArray = inputs.toArray();
        Integer[] foundNumbers = null;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                int value1 = Integer.parseInt(inputArray[i].toString());
                int value2 = Integer.parseInt(inputArray[j].toString());
                if (value1 + value2 == desiredValue) {
                    foundNumbers = new Integer[] {value1, value2};
                }
            }
        }

        return foundNumbers;
    }
}
