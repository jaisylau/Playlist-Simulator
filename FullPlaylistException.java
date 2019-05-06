/**
 * exception class that is thrown when this Playlist is at maximum capacity
 * precondition - this Playlist has been instantiated
 */
public class FullPlaylistException extends Exception {
    private String message = "The playlist is full. Please remove a song and try again.";

    /**
     * constructs a FullPlaylistException
     * postcondition - this FullPlaylistException has been instantiated
     */
    public FullPlaylistException(){}

    /**
     * returns the String representation of this FullPlaylistException
     * precondition - this FullPlaylistException has been instantiated
     * @return the String representation of this FullPlaylistException
     */
    public String toString(){
        return message;
    }
}