package com.andrewfleer.day6;

import com.andrewfleer.utils.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomsFormCheckerTest {
    CustomsForm customsForm;
    FileUtil fileUtil;
    List<String> inputs;

    @Before
    public void initialize() {
        customsForm = new CustomsForm();
        fileUtil = new FileUtil();

        try {
            inputs = fileUtil.readFileToList("day6Input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateGroups() {
        List groups = customsForm.createCustomsGroups(inputs);

        assert(483 == groups.size());
    }

    @Test
    public void testCreateYesMap() {
        List<String> testList = new ArrayList<>();
        testList.add("aabceflq");

        Map yesMap = customsForm.buildYesMap(testList);

        assert(7 == yesMap.size());
    }

    @Test
    public void testGetYessesPerGroup() {
        List<List> testGroupList = new ArrayList<>();
        List<String> group1 = new ArrayList<>();
        group1.add("abcde");
        group1.add("bbaeh");

        List<String> group2 = new ArrayList<>();
        group2.add("thequickbrownfoxjumpsoverthelazydog");

        testGroupList.add(group1);
        testGroupList.add(group2);

        List<Integer> yesList = customsForm.getYessesPerGroup(testGroupList);

        assert(2 == yesList.size()
                && 6 == yesList.get(0)
                && 26 == yesList.get(1));

    }

    @Test
    public void testSumTotal() {
        List<Integer> testList = new ArrayList<>();

        testList.add(5);
        testList.add(15);
        testList.add(6);

        assert(26 == customsForm.sumTotal(testList));
    }
}
