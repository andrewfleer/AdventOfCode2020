package com.andrewfleer.day1;

import com.andrewfleer.utils.FileUtil;

import java.util.List;

public class RepairReport {
    private static final String fileName = "day1Input.txt";
    public static void main (String[] args) {
        FileUtil fileUtil = new FileUtil();

        try {
            List inputs = fileUtil.readFileToList(fileName);
            //Integer[] desiredNumbers = findTwoNumbersThatEqualSum(inputs, 2020);
            Integer[] desiredNumbers = findThreeNumbersThatEqualSum(inputs, 2020);
            if(desiredNumbers != null) {
                Integer product = multiplyFoundNumbers(desiredNumbers);
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer multiplyFoundNumbers(Integer[] desiredNumbers) {
        Integer size = desiredNumbers.length;
        Integer product = 1;
        for (int i = 0; i < size; i++) {
            product = product * desiredNumbers[i];
        }

        return product;
    }

    private static Integer[] findTwoNumbersThatEqualSum(List inputs, int desiredValue) {
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

    private static Integer[] findThreeNumbersThatEqualSum(List inputs, int desiredValue) {
        Object[] inputArray = inputs.toArray();
        Integer[] foundNumbers = null;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                for (int k = j + 1; k < inputArray.length; k++) {
                    int value1 = Integer.parseInt(inputArray[i].toString());
                    int value2 = Integer.parseInt(inputArray[j].toString());
                    int value3 = Integer.parseInt(inputArray[k].toString());
                    if (value1 + value2 + value3 == desiredValue) {
                        foundNumbers = new Integer[]{value1, value2, value3};
                    }
                }
            }
        }

        return foundNumbers;
    }
}
