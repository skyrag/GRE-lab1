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
    Map<Integer, Integer> parent = new HashMap<>(); // store the parent and the current cell
    treatments.setLabel(source, 0);
    parent.put(source, null); // the source has no parent
    queue.add(source);

    while (!queue.isEmpty()) {

      int current = queue.poll();
      if (current == destination) {
        List<Integer> path = new ArrayList<>();

        //creates the path from our map
        for (Integer at = destination; at != null; at = parent.get(at)) {
          path.add(at);
        }

        //reverses our list so that we begin from our source
        Collections.reverse(path);
        return path;
      }

      for ( int i : graph.neighbors(current)) {
        if (!parent.containsKey(i)) {
          queue.add(i);
          parent.put(i, current); // store in map to know the path back to the source
          treatments.setLabel(i, treatments.getLabel(current) + 1); // increases the label which increases with the distance form source
        }
      }
    }
    return Collections.emptyList();
  }
}


