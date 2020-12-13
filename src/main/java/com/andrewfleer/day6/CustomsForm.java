package com.andrewfleer.day6;

import com.andrewfleer.utils.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomsForm {
    private static final String fileName = "day6Input.txt";

    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();

        try {
            List inputs = fileUtil.readFileToList(fileName);

            List groups = createCustomsGroups(inputs);
            List<Integer> yesses = getUnanimousYessesPerGroup(groups);

            Integer total = sumTotal(yesses);

            System.out.println(total);

        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public static Integer sumTotal(List<Integer> yesses) {
        int total = 0;

        for (Integer yes : yesses) {
            total = total + yes;
        }

        return total;
    }

    public static List<Integer> getYessesPerGroup(List<List> groups) {
        List<Integer> yesses = new ArrayList<Integer>();

        for (List<String> groupData : groups) {
            Map yesMap = buildYesMap(groupData);

            yesses.add(yesMap.size());
        }

        return yesses;
    }

    public static List<Integer> getUnanimousYessesPerGroup(List<List> groups) {
        List<Integer> yesses = new ArrayList<Integer>();

        for (List<String> groupData : groups) {
            Map<Character, Integer> yesMap = buildYesMap(groupData);
            Integer unanimousCount = 0;

            for (Map.Entry<Character, Integer> entry : yesMap.entrySet()) {
                if (entry.getValue() == groupData.size()) {
                    unanimousCount++;
                }
            }
            yesses.add(unanimousCount);
        }

        return yesses;
    }

    public static Map buildYesMap(List<String> groupData) {
        Map<Character, Integer> yesMap = new HashMap();
        for (String groupDatum : groupData) {
            for (int i = 0; i < groupDatum.length(); i++) {
                Integer count = yesMap.get(groupDatum.charAt(i));
                if (count == null) {
                    yesMap.put(groupDatum.charAt(i),1);
                } else {
                    yesMap.put(groupDatum.charAt(i), count + 1);
                }
            }
        }

        return yesMap;
    }

    public static List createCustomsGroups(List<String> inputs) {
        List groups = new ArrayList();
        List<String> groupData = new ArrayList<String>();

        for (String input : inputs) {
            if (null != input && !input.isEmpty()) {
                groupData.add(input);
            } else {
                groups.add(groupData);
                groupData = new ArrayList<>();
            }
        }

        //Add that last group
        groups.add(groupData);

        return groups;
    }
}