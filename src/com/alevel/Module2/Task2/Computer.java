package com.alevel.Module2.Task2;

public class Computer implements Runnable {
    private static final String EMPTY_STRING = "";
    private static final int TURN_LENGTH = 2000;
    private final GameState gameState;

    Computer(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void run() {
        while (!gameState.isOver()) {
            System.out.println("bamh!");
            try {
                Thread.sleep(TURN_LENGTH);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String input = this.gameState.getInput().getAndSet(EMPTY_STRING);
            if (input == null || input.isEmpty()) {
                gameState.finishGame();
            }
        }
        System.out.println("Game Over!");
        System.out.println("You lose!");

    }
}

