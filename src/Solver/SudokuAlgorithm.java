package Solver;

import Puzzle.Puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 * Abstract superclass which follows the template pattern
 * Will be extended to implement several different techniques for solving Sudoku
 * See techniques here: http://angusj.com/sudoku/hints.php
 */
public abstract class SudokuAlgorithm {

    public final void solve(Puzzle puzzle){
        start();
        for(int rowIndex = 0; rowIndex < puzzle.gridSize; rowIndex++){
            for(int colIndex = 0; colIndex < puzzle.gridSize; colIndex++){
                applyMethod(puzzle, rowIndex, colIndex);
//                System.out.println("(" + rowIndex + ", " + colIndex + ")");
//                puzzle.printToConsole();
            }
        }
        finish();
    }

    private void start(){
        //TODO: add timing and count mechanisms, etc
    }

    // This must be public for testing
    public abstract void applyMethod(Puzzle puzzle, int currRow, int currCol);

    private void finish(){
        //TODO: end timing and count mechanisms, check if solved, etc
    }

    protected final void updatePossibleValuesInColumn(int colIndex, Puzzle puzzle) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < puzzle.gridSize; i++) {
            if (puzzle.cells[i][colIndex].hasValue()) {
                list.add(puzzle.cells[i][colIndex].getValue());
            }
        }
        for (int i = 0; i < puzzle.gridSize; i++) {
            for (char c : list) {
                if (puzzle.cells[i][colIndex].possibleValues.contains(c)) {
                    puzzle.cells[i][colIndex].possibleValues.remove((Character) c);
                }
            }
        }
    }

    protected final void updatePossibleValuesInRow(int rowIndex, Puzzle puzzle) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < puzzle.gridSize; i++) {
            if (puzzle.cells[rowIndex][i].hasValue()) {
                list.add(puzzle.cells[rowIndex][i].getValue());
            }
        }
        for (int i = 0; i < puzzle.gridSize; i++) {
            for (char c : list) {
                if (puzzle.cells[rowIndex][i].possibleValues.contains(c)) {
                    puzzle.cells[rowIndex][i].possibleValues.remove((Character) c);
                }
            }
        }
    }

    /**
     * To work properly, the indices should be for the top-left cell of the block
     * @param rowIndex Index to the top row of the block
     * @param colIndex Index to the left-most column of the block
     * @param puzzle Puzzle to be updated
     */
    protected final void updatePossibleValuesInBlock(int rowIndex, int colIndex, Puzzle puzzle) {

        List<Character> list = new ArrayList<>();
        for (int i = colIndex; i < colIndex + puzzle.blockSize && i < puzzle.gridSize; i++) {
            for (int j = rowIndex; j < rowIndex + puzzle.blockSize && j < puzzle.gridSize; j++) {
                if (puzzle.cells[i][j].hasValue()) {
                    list.add(puzzle.cells[i][j].getValue());
                }
            }
        }
        for (int i = colIndex; i < colIndex + puzzle.blockSize && i < puzzle.gridSize; i++) {
            for (int j = rowIndex; j < rowIndex + puzzle.blockSize && j < puzzle.gridSize; j++) {
                for (char c : list) {
                    if (puzzle.cells[i][j].possibleValues.contains(c)) {
                        puzzle.cells[i][j].possibleValues.remove((Character) c);
                    }
                }
            }
        }
    }
}
