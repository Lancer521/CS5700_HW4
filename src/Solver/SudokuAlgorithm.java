package Solver;

/**
 * Created by Ty on 11/16/2016.
 */
public abstract class SudokuAlgorithm {

    public final void start(){
        //TODO: add timing and count mechanisms, etc
    }

    public abstract void findApplicableCells();

    public abstract void applyMethod();

    public final void finish(){

    }
}
