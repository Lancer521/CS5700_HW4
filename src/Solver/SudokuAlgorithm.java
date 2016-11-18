package Solver;

import Puzzle.Puzzle;

/**
 * Created by Ty on 11/16/2016.
 * Abstract superclass which follows the template pattern
 * Will be extended to implement several different techniques for solving Sudoku
 * See techniques here: http://angusj.com/sudoku/hints.php
 */
public abstract class SudokuAlgorithm {

    public final void solve(Puzzle puzzle){
        start();
        applyMethod(puzzle);
        finish();
    }

    private void start(){
        //TODO: add timing and count mechanisms, etc
    }

    protected abstract void applyMethod(Puzzle puzzle);

    private void finish(){
        //TODO: end timing and count mechanisms, check if solved, etc
    }
}
