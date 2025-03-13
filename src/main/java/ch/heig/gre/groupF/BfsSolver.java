package ch.heig.gre.groupF;

import ch.heig.gre.graph.Graph;
import ch.heig.gre.graph.VertexLabelling;
import ch.heig.gre.maze.MazeSolver;
import ch.heig.gre.maze.Progression;

import java.util.*;

public final class BfsSolver implements MazeSolver {
  @Override
  public List<Integer> solve(Graph graph, int source, int destination, VertexLabelling<Integer> treatments) {
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> parent = new HashMap<>();
    treatments.setLabel(source, 0);
    parent.put(source, null);
    queue.add(source);

    while (!queue.isEmpty()) {

      int current = queue.poll();
      if (current == destination) {
        return getPath(destination, parent);
      }

      for ( int i : graph.neighbors(current)) {
        if (!parent.containsKey(i)) {
          queue.add(i);
          parent.put(i, current);
          treatments.setLabel(i, treatments.getLabel(current) + 1);
        }
      }
    }
    return Collections.emptyList();
  }


  private List<Integer> getPath(int destination, Map<Integer, Integer> parent) {
    List<Integer> path = new ArrayList<>();
    for (Integer at = destination; at != null; at = parent.get(at)) {
      path.add(at);
    }
    Collections.reverse(path);
    return path;
  }
}


