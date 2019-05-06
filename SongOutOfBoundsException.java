/**
 * exception class that is thrown when user enters a position that is not in the range
 */
public class SongOutOfBoundsException extends Exception {
    private String message = "Entered position is not within range";

    /**
     * constructs a SongOutOfBoundsException
     * postcondition - a SongOutOfBoundsException is instantiated
     */
    public SongOutOfBoundsException(){}

    /**
     * method that returns the String representation of this SongOutOfBoundsException
     * precondition - this SongOutOfBoundsException has been instantiated
     * @return String representation of this SongOutOfBoundsException
     */
    public String toString(){
        return message;
    }
}
