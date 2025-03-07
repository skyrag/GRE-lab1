package ch.heig.gre.groupF;

import ch.heig.gre.graph.Graph;
import ch.heig.gre.graph.VertexLabelling;
import ch.heig.gre.maze.MazeSolver;
import ch.heig.gre.maze.Progression;

import java.util.*;

public final class BfsSolver implements MazeSolver {
  @Override
  public List<Integer> solve(Graph graph, int source, int destination, VertexLabelling<Integer> treatments) {
    //throw new UnsupportedOperationException("Not implemented yet");

    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> solution = new ArrayList<>();

    stack.push(source);


    while (true) {

      Integer current_vertex = stack.peek();

      if (current_vertex == destination) {
        break;
      }

      for (Integer i : graph.neighbors(current_vertex)) {
        stack.push(i);
      }
    }

    return solution;
  }
}
