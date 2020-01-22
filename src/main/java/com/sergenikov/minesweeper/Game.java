package com.sergenikov.minesweeper;

import java.util.Scanner;

public class Game {

  private static final String DELIMITER = ",";
  private static final String CMD_EXIT = "exit";
  private static final String CMD_SOLUTION = "solution";

  final Minesweeper minesweeper;
  final Scanner scan;

  public Game(Scanner scan) {
    this.minesweeper = new Minesweeper(10, 10);
    this.scan = scan;
  }

  void start() {

    System.out.println(String.format("Mines: %d", this.minesweeper.getNumberOfMines()));

    this.minesweeper.printSolution();

    // Game loop
    while (true) {

      System.out.print("Enter coordinate (x,y): ");

      String userInput = this.scan.nextLine();

      // Process game control commands
      switch (userInput) {
        case CMD_EXIT:
          System.out.println("Exit command invoked. Shutting down.");
          Application.close();
        case CMD_SOLUTION:
          this.minesweeper.printSolution();
          // todo close application
          continue;
      }

      final String[] split = userInput.split(DELIMITER);

      int x = Integer.parseInt(split[0]);
      int y = Integer.parseInt(split[1]);

      validateInput(x, y);

      if (this.minesweeper.isMine(x, y)) {
        System.out.println("MINE!!!\n");
        this.minesweeper.printSolution();
        System.out.println("Exiting...");
        Application.close();
      }

      this.minesweeper.setOpen(x, y);

      this.minesweeper.printGameGrid();

      System.out.println("ALIVE SO FAR");
    }
  }

  private static void validateInput(int x, int y) {
    // TODO
  }
}
