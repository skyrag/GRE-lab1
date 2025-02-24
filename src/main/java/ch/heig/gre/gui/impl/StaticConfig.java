package ch.heig.gre.gui.impl;

import ch.heig.gre.graph.VertexLabelling;
import javafx.scene.paint.Color;

public final class StaticConfig {
  private StaticConfig(){}

  public static int startPoint(ObservableMaze graph) {
    return 0;
  }

  public static int wallThickness(int cellSide) {
    return Math.max(cellSide / 20, 1);
  }

  public static Color wallColor() {
    return Color.BLACK;
  }

  public static Color generatorColor(ObservableMaze maze, int v) {
    return switch(maze.getLabel(v)) {
      case PROCESSED -> Color.WHITE;
      case PENDING -> Color.BLACK;
      case PROCESSING -> Color.RED;
    };
  }

  public static Color solverCellColor(ObservableMaze maze, VertexLabelling<Integer> distances, VertexLabelling<Integer> path, int v) {
    double n = maze.width() * maze.height() / 2.5;
    if (path.getLabel(v) > 0) {
      return Color.NAVAJOWHITE.interpolate(Color.DARKRED, path.getLabel(v) / n);
    }

    if (distances.getLabel(v) >= 0) {
      return Color.PALETURQUOISE.interpolate(Color.DARKSLATEGRAY, distances.getLabel(v) / n);
    }

    return StaticConfig.generatorColor(maze, v);
  }
}
