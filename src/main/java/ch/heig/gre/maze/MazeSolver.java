package ch.heig.gre.maze;

import ch.heig.gre.graph.Graph;
import ch.heig.gre.graph.VertexLabelling;

import java.util.List;

/**
 * Solver de labyrinthes.
 */
@FunctionalInterface
public interface MazeSolver {
  /**
   * Valeur indiquant qu'un sommet n'a pas été atteint au cours de la résolution du labyrinthe.
   */
  int UNPROCESSED = -1;

  /**
   * <p>Détermine un chemin (pas forcément optimal) entre deux positions dans un labyrinthe représenté par un
   * graphe.</p>
   *
   * <p>Le chemin retourné est la liste ordonnée de tous les sommets parcourus depuis {@code source}
   * jusqu'à {@code destination} (tous deux inclus).</p>
   *
   * <p>Le paramètre d'entrée-sortie {@code distances} est utilisé pour stocker les distances des sommets traités à la
   * source (ou à la destination), et doit être mis à jour par l'implémentation. Toutes les distances de l'instance
   * fournie sont initialisées à {@link #UNPROCESSED}.</p>
   *
   * <p>Si le graphe fourni n'est pas connexe, le comportement est indéfini.</p>
   *
   * @param graph       Un {@link Graph} représentant le labyrinthe.
   * @param source      Sommet de départ.
   * @param destination Sommet de destination.
   * @param distances   Distances des sommets à la source ou destination (entrée-sortie).
   * @return Une liste (modifiable ou non) représentant le chemin de {@code source} à {@code destination}.
   *
   * @throws NullPointerException     si {@code builder} ou {@code treatments} sont {@code null}.
   * @throws IllegalArgumentException si {@code source} ou  {@code destination} ne sont pas des sommets de
   *                                  {@code graph}.
   */
  List<Integer> solve(Graph graph, int source, int destination, VertexLabelling<Integer> distances);
}
