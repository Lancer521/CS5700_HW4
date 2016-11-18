package Puzzle;

import java.util.List;

/**
 * Created by Ty on 11/15/2016 at 4:39 PM.
 * A Puzzle.Puzzle is composed of Cells. It only knows how many cells exist and constrains what symbols may be used.
 */
public class Puzzle {

    public static final int UNTESTED = 0;
    public static final int SOLVABLE = 1;
    public static final int UNSOLVABLE = 2;
    public static final int BAD_PUZZLE = 3;
    public static final int MULTIPLE_SOLUTIONS = 4;

    public int gridSize;
    public List<Character> symbols;
    public Cell cells[][];
    public int result;
    //TODO: consider storing solutions here // Probably not because then a Puzzle would have to contain a puzzle...

    public Puzzle(int size, List<Character> symbols){
        gridSize = size;
        this.symbols = symbols;
        initializeCells(size);
    }

    private void initializeCells(int size){
        cells = new Cell[size][];
        for(int i = 0; i < size; i++){
            cells[i] = new Cell[size];
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell();
            }
        }
    }

}
