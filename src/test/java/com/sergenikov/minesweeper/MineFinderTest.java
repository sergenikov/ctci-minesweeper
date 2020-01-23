package com.sergenikov.minesweeper;

import org.junit.Before;
import org.junit.Test;

public class MineFinderTest {

  private MineFinder mineFinder;

  @Before
  public void setup() {}

  @Test
  public void countMines_should_return_noMines_when_noneAroundGivenCell() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, false, false},
          {false, false, false},
          {false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    GridPrinter.printGrid(solutionGrid);
    GridPrinter.printGrid(gameGrid);

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    this.mineFinder.countMines(1, 1);
  }

  @Test
  public void countMines_should_return_oneMine_when_oneAroundGivenCell() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, false, false},
          {true, false, false},
          {false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    GridPrinter.printGrid(solutionGrid);
    GridPrinter.printGrid(gameGrid);

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    this.mineFinder.countMines(1, 1);

    GridPrinter.printGrid(gameGrid);
  }

  @Test
  public void countMines_should_return_oneMine_when_oneAroundGivenCellIn4x4Grid() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, false, false, false},
          {true, false, false, false},
          {false, false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?', '?'},
          {'?', '?', '?', '?'},
          {'?', '?', '?', '?'}
        };

    GridPrinter.printGrid(solutionGrid);
    GridPrinter.printGrid(gameGrid);

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    this.mineFinder.countMines(1, 1);

    GridPrinter.printGrid(gameGrid);
  }

  @Test
  public void countMines_should_return_twoMines_when_twoAroundGivenCellIn3x3Grid() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, false, false},
          {true, false, true},
          {false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    GridPrinter.printGrid(solutionGrid);
    GridPrinter.printGrid(gameGrid);

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    this.mineFinder.countMines(1, 1);

    GridPrinter.printGrid(gameGrid);
  }

  @Test
  public void countMines_should_return_twoMines_when_twoAroundIn4x4Grid() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, false, false, false},
          {true, false, true, false},
          {false, false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?', '?'},
          {'?', '?', '?', '?'},
          {'?', '?', '?', '?'}
        };

    GridPrinter.printGrid(solutionGrid);
    GridPrinter.printGrid(gameGrid);

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    this.mineFinder.countMines(1, 1);

    GridPrinter.printGrid(gameGrid);
  }

  @Test
  public void countMines_should_return_allMines_when_twoAroundIn5x5Grid() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, true, false, false, false},
          {true, false, true, false, false},
          {false, false, false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?', '?', '?'},
          {'?', '?', '?', '?', '?'},
          {'?', '?', '?', '?', '?'}
        };

    GridPrinter.printGrid(solutionGrid);
    GridPrinter.printGrid(gameGrid);

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    this.mineFinder.countMines(1, 1);

    GridPrinter.printGrid(gameGrid);
  }
}
