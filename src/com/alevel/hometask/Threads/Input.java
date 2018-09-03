package com.alevel.hometask.Threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Input implements Runnable {
    private String previousInput = "";
    private String currentInput = "";
    private String newString = "";
    private boolean running = true;
    private StringBuilder sb = new StringBuilder();

    private void terminate() {
        running = false;
    }

    void addString(String s) {
        sb.append(s).append(System.lineSeparator());
        newString = s;
    }

    @Override
    public void run() {
        while (running) {
            currentInput = sb.toString();
            try {
                if (!currentInput.equals(previousInput)) {
                    writeonfile();
                }
                if (newString.equals("quit")) {
                    terminate();
                } else {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void writeonfile() {
        try {
            if (!newString.equals("quit")) {
                Files.write(Paths.get("output.txt"), currentInput.getBytes());
                previousInput = currentInput;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}