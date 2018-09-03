package com.alevel.hometask.Nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class NewInputOutput {

    private String input;
    private int lines;
    private String output;

    NewInputOutput(String input, int lines, String output) {
        this.input = input;
        this.lines = lines;
        this.output = output;
    }

    void CopyFail() {
        try {
            int i = 0;
            final List<String> strings = Files.readAllLines(Paths.get(input));
            RandomAccessFile stream = new RandomAccessFile(output, "rw");
            FileChannel channel = stream.getChannel();

            for (String s : strings) {
                if (i < lines) {
                    byte[] strBytes = (s + "\n").getBytes();
                    ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
                    buffer.put(strBytes);
                    buffer.flip();
                    channel.write(buffer);
                    System.out.println(s);
                } else {
                    System.out.println("Number of lines is more than file has.");
                    break;
                }
                stream.close();
                channel.close();

            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println(("Error!!!"));
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}