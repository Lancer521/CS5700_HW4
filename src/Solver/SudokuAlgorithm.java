package Solver;

/**
 * Created by Ty on 11/16/2016.
 *
 */
public abstract class SudokuAlgorithm {

    public final void solve(){
        start();
        applyMethod();
        finish();
    }

    private void start(){
        //TODO: add timing and count mechanisms, etc
    }

    protected abstract void applyMethod();

    private void finish(){
        //TODO: end timing and count mechanisms, etc
    }
}
