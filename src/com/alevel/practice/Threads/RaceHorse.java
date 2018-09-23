package com.alevel.practice.Threads;

import java.util.Random;

import static com.alevel.practice.Threads.Hippodrome.RACE_LENGTH;

public class RaceHorse implements Runnable {

    private final String name;

    private final Hippodrome hippodrome;

    private int position = 0;

    RaceHorse(String name, Hippodrome hippodrome) {
        this.name = name;
        this.hippodrome = hippodrome;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (position < RACE_LENGTH) {
            try {
                Thread.sleep(random.nextInt(100) + 400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            position += random.nextInt(100) + 200;
        }
        hippodrome.finish(this);
    }

    public String getName() {
        return name;
    }
}
