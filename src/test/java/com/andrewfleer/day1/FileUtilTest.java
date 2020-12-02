package com.andrewfleer.day1;

import com.andrewfleer.utils.FileUtil;
import org.junit.Test;

import java.util.List;

public class FileUtilTest {

    @Test
    public void shouldFindFile() {
        FileUtil fileUtil = new FileUtil();

        List list = null;
        try {
            list = fileUtil.readFileToList("day1Input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert(list != null && !list.isEmpty());
    }
}
