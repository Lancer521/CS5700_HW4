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
                updatePossibleValuesInColumn(i, puzzle);
            }
            if(!puzzle.cells[0][i].hasValue()){
                updatePossibleValuesInRow(i, puzzle);
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
            if (puzzle.cells[colIndex][i].hasValue()) {
                list.add(puzzle.cells[colIndex][i].getValue());
            }
        }
        for (int i = 0; i < puzzle.gridSize; i++) {
            for (char c : list) {
                if (puzzle.cells[colIndex][i].possibleValues.contains(c)) {
                    puzzle.cells[colIndex][i].possibleValues.remove(c);
                }
            }
        }
    }

    private void updatePossibleValuesInRow(int rowIndex, Puzzle puzzle) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < puzzle.gridSize; i++) {
            if (puzzle.cells[i][rowIndex].hasValue()) {
                list.add(puzzle.cells[i][rowIndex].getValue());
            }
        }
        for (int i = 0; i < puzzle.gridSize; i++) {
            for (char c : list) {
                if (puzzle.cells[i][rowIndex].possibleValues.contains(c)) {
                    puzzle.cells[i][rowIndex].possibleValues.remove(c);
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
                        puzzle.cells[i][j].possibleValues.remove(c);
                    }
                }
            }
        }
    }
}
