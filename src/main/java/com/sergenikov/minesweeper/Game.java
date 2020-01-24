package com.sergenikov.minesweeper;

import java.util.Scanner;

public class Game {

  private static final String COORDINATES_DELIMITER = ",";
  private static final String CMD_EXIT = "exit";
  private static final String CMD_SOLUTION = "solution";

  private final Minesweeper minesweeper;
  private final Scanner scan;

  public Game(Scanner scan) {
    this.minesweeper = new Minesweeper(10, 10);
    this.scan = scan;
  }

  void start() {

    System.out.println(String.format("Mines: %d", this.minesweeper.getNumberOfMines()));

    this.minesweeper.printSolution();

    int x, y;

    // Game loop
    while (true) {

      System.out.print("Enter coordinate (x,y): ");

      String userInput = this.scan.nextLine();

      // Process game control commands
      switch (userInput) {
        case CMD_EXIT:
          System.out.println("Shutting down.");
          Application.close();
        case CMD_SOLUTION:
          this.minesweeper.printSolution();
          // todo close application
          continue;
      }

      String[] split = userInput.split(COORDINATES_DELIMITER);

      x = Integer.parseInt(split[0]);
      y = Integer.parseInt(split[1]);

      validateInput(x, y);

      if (this.minesweeper.isMine(x, y)) {
        System.out.println("BOOM!!!\n");
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
