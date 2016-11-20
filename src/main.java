import Puzzle.Puzzle;
import Puzzle.PuzzleIO;
import Solver.Solver;

/**
 * Created by Ty on 11/15/2016 at 4:24 PM.
 *
 */
public class Main {

    public static void main(String[] args){

        /**
         * Rather than attempt a deep copy on each puzzle to preserve the original state,
         * instantiate two identical puzzles: one original, one solution.  Call solver.solve()
         * on the solution puzzle.
         */
        Puzzle p1 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0001.txt");
        Puzzle p2 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0001.txt");
        Puzzle p3 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-25x25-0901.txt");

        Solver solver = new Solver();
        solver.solve(p1);
        solver.solve(p2);
        solver.solve(p3);
    }
}
