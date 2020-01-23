package com.sergenikov.minesweeper;

import java.util.Objects;

public class Pair<F, S> {

  public F x;
  public S y;

  public Pair(F x, S y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(x, pair.x) && Objects.equals(y, pair.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Pair{" + "x=" + x + ", y=" + y + '}';
  }
}
