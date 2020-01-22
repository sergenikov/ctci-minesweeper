package com.sergenikov.minesweeper;

import java.util.Scanner;

public class Application {

  static Scanner scan;

  public static void main(String[] args) {

    Application.scan = new Scanner(System.in);

    final Game game = new Game(scan);

    game.start();
  }

  public static void close() {
    Application.close(0);
  }

  public static void close(int status) {
    scan.close();
    System.exit(status);
  }
}
