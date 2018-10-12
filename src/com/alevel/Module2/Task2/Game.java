package com.alevel.Module2.Task2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        GameState gameState = new GameState();
        Scanner scanner = new Scanner(System.in);

        Computer computer = new Computer(gameState);
        Player player = new Player(gameState, scanner);
        executorService.execute(player);
        executorService.execute(computer);

        try {
            gameState.awaitGameOver();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

        executorService.shutdownNow();

        System.exit(0);
    }
}

