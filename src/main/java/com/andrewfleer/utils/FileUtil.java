package com.andrewfleer.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

    public List readFileToList(String fileName) throws IOException, URISyntaxException {
        List list = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()), Charset.defaultCharset());

        return list;
    }
}
