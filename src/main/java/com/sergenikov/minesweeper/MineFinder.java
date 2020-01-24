package com.sergenikov.minesweeper;

import java.util.*;
import java.util.stream.Collectors;

class MineFinder {

  private final int OPEN_CELLS = 0;

  private final Queue<Pair<Integer, Integer>> queue;
  private final Set<Pair<Integer, Integer>> visitedSet;
  private final boolean[][] solutionGrid;
  private final char[][] gameGrid;
  private int width;
  private int height;

  MineFinder(boolean[][] solutionGrid, char[][] gameGrid) {
    this.queue = new LinkedList<>();
    this.visitedSet = new HashSet<>();
    this.solutionGrid = solutionGrid;
    this.gameGrid = gameGrid;
    this.width = gameGrid.length;
    this.height = gameGrid[0].length;
  }

  /**
   * Main idea similar to BFS algorithm.
   *
   * @param x - x coordinate of the starting cell
   * @param y - y coordinate of the starting cell
   * @return - list of opened cells without mines
   */
  public MoveInfo countMines(int x, int y) {

    final MoveInfo moveInfo = new MoveInfo();

    final Pair<Integer, Integer> startingCell = new Pair<>(x, y);

    this.visitedSet.add(startingCell);

    this.queue.add(startingCell);

    while (!this.queue.isEmpty()) {

      Pair<Integer, Integer> currentCell = this.queue.poll();

      final List<Pair<Integer, Integer>> adjacentCells =
          this.generateValidAdjacentCells(currentCell.x, currentCell.y);

      int adjacentBombs = this.countAdjacentBombs(adjacentCells);

      if (adjacentBombs > 0) {
        this.gameGrid[currentCell.x][currentCell.y] = (char) (adjacentBombs + '0');
        moveInfo.addCellWithMine(adjacentBombs, currentCell);
      }

      for (Pair<Integer, Integer> adjacentCell : adjacentCells) {

        if (!this.visitedSet.contains(adjacentCell) && !this.isBombNearby(currentCell)) {
          this.visitedSet.add(adjacentCell);
          this.queue.add(adjacentCell);
        }
      }

      if (!this.isBombNearby(currentCell)) {
        this.gameGrid[currentCell.x][currentCell.y] = Minesweeper.OPENED_CELL;
        moveInfo.addOpened(currentCell);
      }
    }

    return moveInfo;
  }

  private boolean isBombNearby(Pair<Integer, Integer> currentCell) {
    return Character.isDigit(this.gameGrid[currentCell.x][currentCell.y]);
  }

  private int countAdjacentBombs(final List<Pair<Integer, Integer>> adjacentCells) {
    int count = 0;
    for (Pair<Integer, Integer> adjacentCell : adjacentCells) {
      if (this.isBomb(adjacentCell)) {
        count++;
      }
    }
    return count;
  }

  private boolean isBomb(Pair<Integer, Integer> adjacentCell) {
    return this.solutionGrid[adjacentCell.x][adjacentCell.y];
  }

  private List<Pair<Integer, Integer>> generateValidAdjacentCells(int x, int y) {
    return this.generateAdjacentCells(x, y).stream()
        .filter(cell -> cell.x < this.width && cell.y < this.height)
        .filter(cell -> cell.x >= 0 && cell.y >= 0)
        .collect(Collectors.toList());
  }

  private List<Pair<Integer, Integer>> generateAdjacentCells(int x, int y) {

    final List<Pair<Integer, Integer>> cells = new ArrayList<>();

    cells.add(new Pair<>(x + 1, y));
    cells.add(new Pair<>(x - 1, y));
    cells.add(new Pair<>(x, y + 1));
    cells.add(new Pair<>(x, y - 1));

    cells.add(new Pair<>(x - 1, y - 1));
    cells.add(new Pair<>(x + 1, y - 1));
    cells.add(new Pair<>(x - 1, y + 1));
    cells.add(new Pair<>(x + 1, y + 1));

    return cells;
  }
}
