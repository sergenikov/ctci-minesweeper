package com.sergenikov.minesweeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveInfo {

  private List<Pair<Integer, Integer>> opened;
  private Map<Integer, List<Pair<Integer, Integer>>> cellsWithMines;

  public MoveInfo() {
    this.opened = new ArrayList<>();
    this.cellsWithMines = new HashMap<>();
    this.init();
  }

  private void init() {
    for (int i = 1; i < 9; i++) {
      this.cellsWithMines.put(i, new ArrayList<>());
    }
  }

  public void addOpened(Pair<Integer, Integer> pair) {
    this.opened.add(pair);
  }

  public void addCellWithMine(int count, Pair<Integer, Integer> cell) {
    this.cellsWithMines.get(count).add(cell);
  }

  public List<Pair<Integer, Integer>> getCellsWithMineCount(int count) {
    return this.cellsWithMines.get(count);
  }

  public List<Pair<Integer, Integer>> getOpened() {
    return opened;
  }
}
