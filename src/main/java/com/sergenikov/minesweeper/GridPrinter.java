package com.sergenikov.minesweeper;

public class GridPrinter {

  public static void printGrid(final boolean[][] grid) {

    int width = grid.length;
    int height = grid[0].length;

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
  }

  public static void printGrid(final char[][] grid) {

    int width = grid.length;
    int height = grid[0].length;

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
