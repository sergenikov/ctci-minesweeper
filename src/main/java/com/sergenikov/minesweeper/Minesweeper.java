package com.sergenikov.minesweeper;

import java.util.concurrent.ThreadLocalRandom;

public class Minesweeper {

  public static final char UNOPENED_CELL = '?';
  public static final char OPENED_CELL = '+';

  private boolean[][] solutionGrid;
  private char[][] userGrid;
  private int numberOfMines;
  private int width;
  private int height;
  private MineFinder mineFinder;

  public Minesweeper(int width, int height) {
    this.width = width;
    this.height = height;
    this.solutionGrid = new boolean[this.width][this.height];
    this.userGrid = new char[this.width][this.height];
    this.numberOfMines = this.initMines(Math.min(this.width, this.height));
    this.initGameGrid(this.userGrid);
    this.printGameGrid(this.userGrid, this.width, this.height);
    this.mineFinder = new MineFinder(this.solutionGrid, this.userGrid);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public MineFinder getMineFinder() {
    return this.mineFinder;
  }

  public int getNumberOfMines() {
    return numberOfMines;
  }

  public boolean isMine(int x, int y) {
    return this.solutionGrid[x][y];
  }

  public void printSolution() {
    this.printSolution(this.solutionGrid, this.width, this.height);
  }

  public void printGameGrid() {
    this.printGameGrid(this.userGrid, this.width, this.height);
  }

  public void setOpen(int x, int y) {
    this.userGrid[x][y] = Minesweeper.OPENED_CELL;
  }

  /**
   * Init user-facing grid
   *
   * @param userGrid - grid that's presented to the user to avoid revealing the locations of the
   *     mines
   */
  private void initGameGrid(final char[][] userGrid) {
    for (int i = 0; i < width; i++) { // rows
      for (int j = 0; j < height; j++) { // cols
        userGrid[i][j] = Minesweeper.UNOPENED_CELL;
      }
    }
  }

  /**
   * Generate random coordinate within the grid and set that to true to signify presence of a mine
   *
   * @param numberOfMines - mines to initialize
   * @return number of mines actually created
   */
  private int initMines(int numberOfMines) {

    int mineCount = 0;

    while (mineCount < numberOfMines) {
      int randomX = ThreadLocalRandom.current().nextInt(0, this.width - 1);
      int randomY = ThreadLocalRandom.current().nextInt(0, this.height - 1);

      if (this.solutionGrid[randomX][randomY]) {
        continue;
      }

      this.solutionGrid[randomX][randomY] = true;
      mineCount++;
    }
    return mineCount;
  }

  private void printSolution(final boolean[][] grid, int width, int height) {

    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SOLUTION>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    // pad the grid coordinates printout
    System.out.print("  ");

    for (int i = 0; i < width; i++) {
      System.out.printf("%d ", i);
    }

    System.out.println();
    System.out.print("  ");

    for (int i = 0; i < width * 2; i++) {
      System.out.print("-");
    }

    System.out.println();

    for (int i = 0; i < width; i++) { // rows

      System.out.printf("%d|", i);

      for (int j = 0; j < height; j++) { // cols
        System.out.print(String.format("%d ", grid[i][j] ? 1 : 0));
      }

      System.out.println();
    }

    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
  }

  private void printGameGrid(final char[][] grid, int width, int height) {

    // pad the grid coordinates printout
    System.out.print("  ");

    for (int i = 0; i < width; i++) {
      System.out.printf("%d ", i);
    }

    System.out.println();
    System.out.print("  ");

    for (int i = 0; i < width * 2; i++) {
      System.out.print("-");
    }

    System.out.println();

    for (int i = 0; i < width; i++) { // rows

      System.out.printf("%d|", i);

      for (int j = 0; j < height; j++) { // cols
        System.out.print(String.format("%c ", grid[i][j]));
      }

      System.out.println();
    }
  }
}
