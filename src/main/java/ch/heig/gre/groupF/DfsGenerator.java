package ch.heig.gre.groupF;

import ch.heig.gre.maze.MazeBuilder;
import ch.heig.gre.maze.MazeGenerator;
import ch.heig.gre.maze.Progression;

import java.util.*;


public final class DfsGenerator implements MazeGenerator {
  @Override
  public void generate(MazeBuilder builder, int from) {
    Stack<Integer> stack = new Stack<>();
    builder.progressions().setLabel(from, Progression.PROCESSED);
    stack.push(from);
    Random rand = new Random();

    while (!stack.isEmpty()) {
      int v = stack.pop();
      List<Integer> neighbours = builder.topology().neighbors(v);

      Collections.shuffle(neighbours, rand);

      neighbours.removeIf(neighbour -> !builder.progressions().getLabel(neighbour).equals(Progression.PENDING));

      if (!neighbours.isEmpty()) {
        int neighbour = neighbours.get(rand.nextInt(neighbours.size()));
        stack.push(v);
        builder.removeWall(neighbour, v);
        builder.progressions().setLabel(neighbour, Progression.PROCESSED);
        stack.push(neighbour);
      }
    }
  }

  @Override
  public boolean requireWalls() {
    return true;
  }
}
