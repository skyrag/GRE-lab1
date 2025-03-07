package ch.heig.gre.groupF;

import ch.heig.gre.maze.MazeBuilder;
import ch.heig.gre.maze.MazeGenerator;
import ch.heig.gre.maze.Progression;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

// TODO: renommer le package (Shift + F6) selon la lettre attribuée à votre groupe

public final class DfsGenerator implements MazeGenerator {
  @Override
  public void generate(MazeBuilder builder, int from) {
    //throw new UnsupportedOperationException("Not implemented yet");

    if (!builder.topology().vertexExists(from)) {
      throw new UnsupportedOperationException("Vertex does not exist");
    }

    Stack<Integer> stack = new Stack<>();

    //push the first vertex
    stack.push(from);
    //visited_vertices.set(from, true);
    builder.progressions().setLabel(from, Progression.PROCESSING);

    while (!stack.empty()) {

      Integer current_vertex = stack.peek();
      builder.progressions().setLabel(current_vertex, Progression.PROCESSING);
      List<Integer> neigbors = builder.topology().neighbors(current_vertex);
      //Randomly chose the next vertex
      Collections.shuffle(neigbors);
      boolean no_neighbor = true;

      for (Integer i : neigbors) {
        //the vertex hasn't been visited yet
        if (builder.progressions().getLabel(i) == Progression.PENDING) {
          no_neighbor = false;
          stack.add(i);
          builder.removeWall(current_vertex, i);
          break;
        }
      }
      if (no_neighbor) {
        builder.progressions().setLabel(current_vertex, Progression.PROCESSED);
        stack.pop();
      }
    }
    
  }

  @Override
  public boolean requireWalls() {
    //throw new UnsupportedOperationException("Not implemented yet");
    return true;
  }
}
