package com.carrywei.shell;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ShellTest {
    boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

    public void showDir() throws IOException, Exception {
        String homeDirectory = System.getProperty("user.home");
        Process process;
        if (isWindows) {
            process = Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s", homeDirectory));
        } else {
            process = Runtime.getRuntime()
                    .exec(String.format("sh -c ls %s", homeDirectory));
        }
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    public void processBuild() throws IOException, Exception {
        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows) {
            builder.command("cmd.exe", "/c", "git add *");
        } else {
            builder.command("sh", "-c", "ls");
        }
//        builder.directory(new File(System.getProperty("user.home")));
        builder.directory(new File("C:\\Users\\Administrator\\Desktop\\1"));

        Process process = builder.start();
        StreamGobbler streamGobbler1 = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler1);

        builder.command("cmd.exe", "/c", "git status");
        process = builder.start();
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);



        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    public static void main(String[] args) {
        try {
//            new ShellTest().showDir();
            String projectPath = "D:\\code\\java\\frameworkdemo\\framework\\core-constant";
            String mvnCommand = "mvn package";
            new ShellTest().mvnCommand(mvnCommand, projectPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行maven命令
     * @param mvnCommand
     * @param pathName
     */
    public static boolean mvnCommand(String mvnCommand, String pathName) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            if (true) {
                builder.command("cmd.exe", "/c", mvnCommand);
            } else {
                builder.command("sh", "-c", mvnCommand);
            }
            builder.directory(new File(pathName));
            Process process = builder.start();
            StringBuilder sb = new StringBuilder();
            try (InputStream input = process.getInputStream()) {
                InputStreamReader isr = new InputStreamReader(input);
                char[] data = new char[1024];
                while ((isr.read(data)) != -1) {
                    sb.append(data);
                }
                System.out.println(sb.toString());
            }

//            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
//            Executors.newSingleThreadExecutor().submit(streamGobbler);
//            int exitCode = process.waitFor();
//            System.out.println(exitCode);
//            assert exitCode == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
