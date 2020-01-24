package com.sergenikov.minesweeper;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MineFinderTest {

  private MineFinder mineFinder;

  @Before
  public void setup() {}

  @Test
  public void countMines_should_return_oneMineNoneOpen_when_oneNearbyMine() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, true, false},
          {false, false, false},
          {false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    MoveInfo moveInfo = this.mineFinder.countMines(0, 0);

    assertEquals(0, moveInfo.getOpened().size());
    assertEquals(1, moveInfo.getCellsWithMineCount(1).size());
  }

  @Test
  public void countMines_should_return_twoMineNoneOpen_when_twoMinesNearby() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, true, false},
          {true, false, false},
          {false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    MoveInfo moveInfo = this.mineFinder.countMines(0, 0);

    assertEquals(0, moveInfo.getOpened().size());
    assertEquals(1, moveInfo.getCellsWithMineCount(2).size());
  }

  @Test
  public void countMines_should_return_threeMineNoneOpen_when_threeMinesNearby() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, true, false},
          {true, true, false},
          {false, false, false}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    MoveInfo moveInfo = this.mineFinder.countMines(0, 0);

    assertEquals(0, moveInfo.getOpened().size());
    assertEquals(0, moveInfo.getCellsWithMineCount(1).size());
    assertEquals(0, moveInfo.getCellsWithMineCount(2).size());
    assertEquals(1, moveInfo.getCellsWithMineCount(3).size());
  }

  @Test
  public void countMines_should_return_openCells_when_cellsHaveNoAdjacentMinesUntilReachMines() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, false, false},
          {false, false, false},
          {false, false, true}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    MoveInfo moveInfo = this.mineFinder.countMines(0, 0);

    assertEquals(5, moveInfo.getOpened().size());
    assertEquals(3, moveInfo.getCellsWithMineCount(1).size());

    final List<Pair<Integer, Integer>> cellsWithMineCount = moveInfo.getCellsWithMineCount(1);

    final List<Pair<Integer, Integer>> expectedPairsWithCount =
        Arrays.asList(new Pair<>(1, 1), new Pair<>(2, 1), new Pair<>(1, 2));

    assertEquals(expectedPairsWithCount, cellsWithMineCount);
  }

  @Test
  public void countMines_should_return_openCells_when_overlappingCountRequired() {

    boolean[][] solutionGrid =
        new boolean[][] {
          {false, false, false},
          {false, false, false},
          {true, false, true}
        };

    char[][] gameGrid =
        new char[][] {
          {'?', '?', '?'},
          {'?', '?', '?'},
          {'?', '?', '?'}
        };

    this.mineFinder = new MineFinder(solutionGrid, gameGrid);

    MoveInfo moveInfo = this.mineFinder.countMines(0, 0);

    assertEquals(3, moveInfo.getOpened().size());
    assertEquals(2, moveInfo.getCellsWithMineCount(1).size());
    assertEquals(2, moveInfo.getCellsWithMineCount(2).size());

    assertEquals(
        Arrays.asList(new Pair<>(0, 1), new Pair<>(2, 1)), moveInfo.getCellsWithMineCount(1));

    assertEquals(
        Arrays.asList(new Pair<>(1, 1), new Pair<>(1, 2)), moveInfo.getCellsWithMineCount(2));
  }
}
