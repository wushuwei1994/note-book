package com.carrywei.file;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
//        String resourcePath = FileTest.class.getResource("").toString();
//        System.out.println(resourcePath);
//        System.out.println(resourcePath.substring(6, 9));
        File file = new File("D:/newDir/a");
        System.out.println(file.exists());
        System.out.println(file.mkdirs());

    }
}
