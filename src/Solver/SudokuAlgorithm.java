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
        for(int rowIndex = 0; rowIndex < puzzle.gridSize; rowIndex++){
            for(int colIndex = 0; colIndex < puzzle.gridSize; colIndex++){
                applyMethod(puzzle, rowIndex, colIndex);
                updateNotes(puzzle, rowIndex, colIndex);
//                System.out.println("(" + rowIndex + ", " + colIndex + ")");
//                puzzle.printToConsole();
                //TODO: UPDATE AFFECTED CELLS
            }
        }
    }

    // This must be public for testing
    public abstract void applyMethod(Puzzle puzzle, int currRow, int currCol);

    public final void updateNotes(Puzzle puzzle, int rowIndex, int colIndex) {
        updatePossibleValuesInRow(puzzle, rowIndex);
        updatePossibleValuesInColumn(puzzle, colIndex);
        updatePossibleValuesInBlock(puzzle, getBlockIndex(puzzle, rowIndex), getBlockIndex(puzzle, colIndex));
    }

    /**
     * Return the top-most row index or left-most column index in the block
     * @param puzzle Puzzle to be examined
     * @param currIndex Row or column index of the current
     * @return top-most row index or left-most column index in the block
     */
    public final int getBlockIndex(Puzzle puzzle, int currIndex) {
        for (int i = 1; i <= puzzle.blockSize; i++) {
            if(currIndex < i * puzzle.blockSize){
                return (i - 1) * puzzle.blockSize;
            }
        }
        return -1;
    }

    protected final void updatePossibleValuesInColumn(Puzzle puzzle, int colIndex) {
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

    protected final void updatePossibleValuesInRow(Puzzle puzzle, int rowIndex) {
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
     * TODO: get the blockRow and blockCol inside method rather than in calling methods
     * @param puzzle Puzzle to be updated
     * @param rowIndex Index to the top row of the block
     * @param colIndex Index to the left-most column of the block
     */
    protected final void updatePossibleValuesInBlock(Puzzle puzzle, int rowIndex, int colIndex) {

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
