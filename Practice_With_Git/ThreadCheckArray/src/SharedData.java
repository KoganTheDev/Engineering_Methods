/**
 * Represents shared data between threads, used for thread-safe communication
 * and tracking the progress and results of a multi-threaded operation.
 */
public class SharedData {
    /** The input array to be processed by the threads. */
    private int[] array;

    /** A boolean array indicating which indices contribute to a valid result. */
    private boolean[] winArray;

    /** A flag indicating whether a solution has been found. */
    private boolean flag;

    /** The target sum for the operation. */
    private final int b;

    /** The name of the thread that found the solution, if any. */
    private String winningThread = null;

    /**
     * Constructs a new SharedData object.
     *
     * @param array the input array to be processed
     * @param b     the target sum to check for
     */
    public SharedData(int[] array, int b) {
        this.array = array;
        this.b = b;
    }

    /**
     * Gets the boolean array indicating which indices contribute to a valid result.
     *
     * @return the boolean array representing winning indices
     */
    public boolean[] getWinArray() {
        return winArray;
    }

    /**
     * Sets the boolean array indicating which indices contribute to a valid result.
     *
     * @param winArray the boolean array representing winning indices
     */
    public void setWinArray(boolean[] winArray) {
        this.winArray = winArray;
    }

    /**
     * Gets the input array to be processed by the threads.
     *
     * @return the input array
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Gets the target sum for the operation.
     *
     * @return the target sum
     */
    public int getB() {
        return b;
    }

    /**
     * Checks if a solution has been found.
     *
     * @return {@code true} if a solution has been found, {@code false} otherwise
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Sets the flag indicating whether a solution has been found.
     *
     * @param flag {@code true} if a solution has been found, {@code false} otherwise
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Gets the name of the thread that found the solution.
     *
     * @return the name of the winning thread, or {@code null} if no solution has been found
     */
    public String getWinningThread() {
        return winningThread;
    }

    /**
     * Sets the name of the thread that found the solution.
     *
     * @param winningThread the name of the thread that found the solution
     */
    public synchronized void setWinningThread(String winningThread) {
        this.winningThread = winningThread;
    }
}
