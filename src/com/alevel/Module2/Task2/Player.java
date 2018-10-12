package com.alevel.Module2.Task2;

import java.util.Scanner;

public class Player implements Runnable {
    private final GameState gameState;
    private final Scanner scanner;

    public Player(GameState gameState, Scanner scanner) {
        this.gameState = gameState;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (!gameState.isOver()) {
            gameState.getInput().set(scanner.nextLine());
        }
    }
}
