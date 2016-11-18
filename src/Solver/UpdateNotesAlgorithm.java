package Solver;

import Puzzle.Puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 * For each "empty" cell, searches through its row, column, and block, and updates its list of possible values
 * There is almost certainly room for optimization here
 */
public class UpdateNotesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle) {
        int blockSize = ((Double) Math.sqrt(puzzle.gridSize)).intValue();

        for (int i = 0; i < puzzle.gridSize; i++) {
            if (!puzzle.cells[i][0].hasValue()) {
                updatePossibleValuesInRow(i, puzzle);
            }
            if(!puzzle.cells[0][i].hasValue()){
                updatePossibleValuesInColumn(i, puzzle);
            }
        }
        for(int i = 0; i < puzzle.gridSize; i += blockSize){
            for(int j = 0; j < puzzle.gridSize; j += blockSize){
                updatePossibleValuesInBlock(i, j, puzzle, blockSize);
            }
        }
    }

    private void updatePossibleValuesInColumn(int colIndex, Puzzle puzzle) {
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

    private void updatePossibleValuesInRow(int rowIndex, Puzzle puzzle) {
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

    private void updatePossibleValuesInBlock(int colIndex, int rowIndex, Puzzle puzzle, int blockSize) {

        List<Character> list = new ArrayList<>();
        for (int i = colIndex; i < colIndex + blockSize; i++) {
            for (int j = rowIndex; j < rowIndex + blockSize; j++) {
                if (puzzle.cells[i][j].hasValue()) {
                    list.add(puzzle.cells[i][j].getValue());
                }
            }
        }
        for (int i = colIndex; i < colIndex + blockSize; i++) {
            for (int j = rowIndex; j < rowIndex + blockSize; j++) {
                for (char c : list) {
                    if (puzzle.cells[i][j].possibleValues.contains(c)) {
                        puzzle.cells[i][j].possibleValues.remove((Character) c);
                    }
                }
            }
        }
    }
}
