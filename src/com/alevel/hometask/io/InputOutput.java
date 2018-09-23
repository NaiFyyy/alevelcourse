package com.alevel.hometask.io;

import java.io.*;

class InputOutput {
    private String input;
    private int lines;
    private String output;

    InputOutput(String input, int lines, String output) {
        this.input = input;
        this.lines = lines;
        this.output = output;
    }

    void copyFile() {

        try (InputStream inStream = new FileInputStream(input);
             OutputStream outStream = new FileOutputStream(output)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
            String line;
            int i = 0;
            while (i < lines) {
                if ((line = br.readLine()) != null) {
                    System.out.println(line);
                    byte[] toBytes = (line + "\n").getBytes();
                    outStream.write(toBytes);
                    i++;
                } else {
                    System.out.println("Number of lines is more than file has.");
                    break;
                }
            }
            outStream.close();
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}

