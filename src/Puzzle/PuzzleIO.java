package Puzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ty on 11/15/2016 at 4:26 PM.
 * Controls the reading-in/parsing and saving of puzzles
 */
public class PuzzleIO {

    public static Puzzle getPuzzle(String inputFile) {

        Puzzle puzzle = null;
        String line;
        String rawPuzzle = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            line = br.readLine();
            if (line == null) return null;
            int size = Integer.parseInt(line);

            line = br.readLine();
            if (line == null) return null;
            List<Character> list = new ArrayList<>();
            for (char c : line.toCharArray()) {
                if(c != ' '){
                    list.add(c);
                }
            }

            puzzle = new Puzzle(size, list);

            while ((line = br.readLine()) != null) {
                String[] array = line.split(" ");
                for (String str : array) {
                    rawPuzzle += str;
                }
            }

            char[] rawPuzzleCharacters = rawPuzzle.toCharArray();
            int charIndex = 0;

            for (int i = 0; i < puzzle.gridSize; i++){
                for (int j = 0; j < puzzle.gridSize; j++){
                    puzzle.cells[i][j].value = rawPuzzleCharacters[charIndex++];
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return puzzle;
    }

    public void outputPuzzle(Puzzle puzzle) {

    }

}
