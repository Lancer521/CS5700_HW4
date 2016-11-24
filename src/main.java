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
         * instantiate two identical puzzles: one original, one solution.  Call solver.apply()
         * on the solution puzzle.
         */
        Puzzle p1 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0001.txt");
        Puzzle p2 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0002.txt");
        Puzzle p3 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0901.txt");
        Puzzle p4 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0902.txt");
        Puzzle p5 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0903.txt");
        Puzzle p6 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0904.txt");
        Puzzle p7 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0001.txt");
        Puzzle p8 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0002.txt");
        Puzzle p9 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0101.txt");
        Puzzle p10 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0201.txt");
        Puzzle p11 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0202.txt");
        Puzzle p12 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0203.txt");
        Puzzle p13 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0301.txt");
        Puzzle p14 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0302.txt");
        Puzzle p15 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0304.txt");
        Puzzle p16 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0305.txt");
        Puzzle p17 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0306.txt");
        Puzzle p18 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0307.txt");
        Puzzle p19 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0308.txt");
        Puzzle p20 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0401.txt");
        Puzzle p21 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-16x16-0001.txt");
        Puzzle p22 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-16x16-0101.txt");
        Puzzle p23 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-16x16-0201.txt");
        Puzzle p24 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-16x16-0301.txt");
        Puzzle p25 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-16x16-0401.txt");
        Puzzle p26 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-16x16-0901.txt");
        Puzzle p27 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-25x25-0201.txt");
        Puzzle p28 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-25x25-0301.txt");
        Puzzle p29 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-25x25-0401.txt");
        Puzzle p30 = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-25x25-0901.txt");


        Solver solver = new Solver();
        System.out.println("PUZZLE 1:\n");
        p1.result = solver.solve(p1);
        PuzzleIO.outputPuzzle("src/Output/puzzle1.txt", p1);
        System.out.println(p1.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 2:\n");
        p2.result = solver.solve(p2);
        PuzzleIO.outputPuzzle("src/Output/puzzle2.txt", p2);
        System.out.println(p2.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 3:\n");
        p3.result = solver.solve(p3);
        PuzzleIO.outputPuzzle("src/Output/puzzle3.txt", p3);
        System.out.println(p3.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 4:\n");
        p4.result = solver.solve(p4);
        PuzzleIO.outputPuzzle("src/Output/puzzle4.txt", p4);
        System.out.println(p4.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 5:\n");
        p5.result = solver.solve(p5);
        PuzzleIO.outputPuzzle("src/Output/puzzle5.txt", p5);
        System.out.println(p5.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 6:\n");
        p6.result = solver.solve(p6);
        PuzzleIO.outputPuzzle("src/Output/puzzle6.txt", p6);
        System.out.println(p6.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 7:\n");
        p7.result = solver.solve(p7);
        PuzzleIO.outputPuzzle("src/Output/puzzle7.txt", p7);
        System.out.println(p7.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 8:\n");
        p8.result = solver.solve(p8);
        PuzzleIO.outputPuzzle("src/Output/puzzle8.txt", p8);
        System.out.println(p8.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 9:\n");
        p9.result = solver.solve(p9);
        PuzzleIO.outputPuzzle("src/Output/puzzle9.txt", p9);
        System.out.println(p9.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 10:\n");
        p10.result = solver.solve(p10);
        PuzzleIO.outputPuzzle("src/Output/puzzle10.txt", p10);
        System.out.println(p10.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 11:\n");
        p11.result = solver.solve(p11);
        PuzzleIO.outputPuzzle("src/Output/puzzle11.txt", p11);
        System.out.println(p11.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 12:\n");
        p12.result = solver.solve(p12);
        PuzzleIO.outputPuzzle("src/Output/puzzle12.txt", p12);
        System.out.println(p12.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 13:\n");
        p13.result = solver.solve(p13);
        PuzzleIO.outputPuzzle("src/Output/puzzle13.txt", p13);
        System.out.println(p13.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 14:\n");
        p14.result = solver.solve(p14);
        PuzzleIO.outputPuzzle("src/Output/puzzle14.txt", p14);
        System.out.println(p14.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 15:\n");
        p15.result = solver.solve(p15);
        PuzzleIO.outputPuzzle("src/Output/puzzle15.txt", p15);
        System.out.println(p15.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 16:\n");
        p16.result = solver.solve(p16);
        PuzzleIO.outputPuzzle("src/Output/puzzle16.txt", p16);
        System.out.println(p16.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 17:\n");
        p17.result = solver.solve(p17);
        PuzzleIO.outputPuzzle("src/Output/puzzle17.txt", p17);
        System.out.println(p17.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 18:\n");
        p18.result = solver.solve(p18);
        PuzzleIO.outputPuzzle("src/Output/puzzle18.txt", p18);
        System.out.println(p18.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 19:\n");
        p19.result = solver.solve(p19);
        PuzzleIO.outputPuzzle("src/Output/puzzle19.txt", p19);
        System.out.println(p19.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 20:\n");
        p20.result = solver.solve(p20);
        PuzzleIO.outputPuzzle("src/Output/puzzle20.txt", p20);
        System.out.println(p20.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 21:\n");
        p21.result = solver.solve(p21);
        PuzzleIO.outputPuzzle("src/Output/puzzle21.txt", p21);
        System.out.println(p21.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 22:\n");
        p22.result = solver.solve(p22);
        PuzzleIO.outputPuzzle("src/Output/puzzle22.txt", p22);
        System.out.println(p22.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 23:\n");
        p23.result = solver.solve(p23);
        PuzzleIO.outputPuzzle("src/Output/puzzle23.txt", p23);
        System.out.println(p23.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 24:\n");
        p24.result = solver.solve(p24);
        PuzzleIO.outputPuzzle("src/Output/puzzle24.txt", p24);
        System.out.println(p24.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 25:\n");
        p25.result = solver.solve(p25);
        PuzzleIO.outputPuzzle("src/Output/puzzle25.txt", p25);
        System.out.println(p25.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 26:\n");
        p26.result = solver.solve(p26);
        PuzzleIO.outputPuzzle("src/Output/puzzle26.txt", p26);
        System.out.println(p26.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 27:\n");
        p27.result = solver.solve(p27);
        PuzzleIO.outputPuzzle("src/Output/puzzle27.txt", p27);
        System.out.println(p27.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 28:\n");
        p28.result = solver.solve(p28);
        PuzzleIO.outputPuzzle("src/Output/puzzle28.txt", p28);
        System.out.println(p28.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 29:\n");
        p29.result = solver.solve(p29);
        PuzzleIO.outputPuzzle("src/Output/puzzle29.txt", p29);
        System.out.println(p29.getPuzzleResultString() + "\n");

        System.out.println("PUZZLE 30:\n");
        p30.result = solver.solve(p30);
        PuzzleIO.outputPuzzle("src/Output/puzzle30.txt", p30);
        System.out.println(p30.getPuzzleResultString() + "\n");

        System.out.println("OVERALL REPORT:");
        System.out.println("1 : " + p1.getPuzzleResultString());
        System.out.println("2 : " + p2.getPuzzleResultString());
        System.out.println("3 : " + p3.getPuzzleResultString());
        System.out.println("4 : " + p4.getPuzzleResultString());
        System.out.println("5 : " + p5.getPuzzleResultString());
        System.out.println("6 : " + p6.getPuzzleResultString());
        System.out.println("7 : " + p7.getPuzzleResultString());
        System.out.println("8 : " + p8.getPuzzleResultString());
        System.out.println("9 : " + p9.getPuzzleResultString());
        System.out.println("10: " + p10.getPuzzleResultString());
        System.out.println("11: " + p11.getPuzzleResultString());
        System.out.println("12: " + p12.getPuzzleResultString());
        System.out.println("13: " + p13.getPuzzleResultString());
        System.out.println("14: " + p14.getPuzzleResultString());
        System.out.println("15: " + p15.getPuzzleResultString());
        System.out.println("16: " + p16.getPuzzleResultString());
        System.out.println("17: " + p17.getPuzzleResultString());
        System.out.println("18: " + p18.getPuzzleResultString());
        System.out.println("19: " + p19.getPuzzleResultString());
        System.out.println("20: " + p20.getPuzzleResultString());
        System.out.println("21: " + p21.getPuzzleResultString());
        System.out.println("22: " + p22.getPuzzleResultString());
        System.out.println("23: " + p23.getPuzzleResultString());
        System.out.println("24: " + p24.getPuzzleResultString());
        System.out.println("25: " + p25.getPuzzleResultString());
        System.out.println("26: " + p26.getPuzzleResultString());
        System.out.println("27: " + p27.getPuzzleResultString());
        System.out.println("28: " + p28.getPuzzleResultString());
        System.out.println("29: " + p29.getPuzzleResultString());
        System.out.println("30: " + p30.getPuzzleResultString());
    }
}
