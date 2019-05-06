/**
 * class implements an abstract data type for a song supporting common operations on such audio files
 */
public class SongRecord {
    private String title;
    private String artist;
    private int min;
    private int sec;

    /**
     * constructs a SongRecord that has a title t, by artist a, and goes for min m and sec s
     * @param t - the title of the new SongRecord
     * @param a - the artist of the new SongRecord
     * @param m - the min of the new SongRecord
     * @param s - the sec of the new SongRecord
     * postcondition - this SongRecord has been instantiated with title t, artist a, min m, and sec s
     */
    public SongRecord(String t,String a,int m,int s) {
        title = t;
        artist = a;
        min=m;
        sec = s;
    }

    /**
     * method that returns the title of this SongRecord
     * precondition - this SongRecord has been instantiated
     * @return title of this SongRecord
     */
    public String getTitle() {
        return title;
    }

    /**
     * method that returns the artist of this SongRecord
     * precondition - this SongRecord has been instantiated
     * @return artist of this SongRecord
     */
    public String getArtist() {
        return artist;
    }

    /**
     * method that returns the min of this SongRecord
     * precondition - this SongRecord has been instantiated
     * @return min of this SongRecord
     */
    public int getMin() {
        return min;
    }

    /**
     * method that returns the sec of this SongRecord
     * precondition - this SongRecord has been instantiated
     * @return title of sec SongRecord
     */
    public int getSec() {
        return sec;
    }

    /**
     * method that clones this SongRecord
     * precondition - this SongRecord has been instantiated
     * @return the clone of this SongRecord
     */
    public SongRecord clone(){
        SongRecord copy=new SongRecord(title,artist,min,sec);
        return copy;
    }

    /**
     * method that determines if this SongRecord is equal to another SongRecord
     * @param song the SongRecord that is this SongRecord is being compared to
     * precondition - this SongRecord and SongRecord song have been instantiated
     * @return boolean value determining whether the two SongRecords are equal to one another or not
     */
    public boolean equals(SongRecord song){
        if (this.title.equals(song.getTitle())&&this.artist.equals(song.getArtist())&&this.min==song.getMin()&&this.sec==song.getSec())
            return true;
        else
            return false;
    }

    /**
     * method that converts this SongRecord into a String object
     * precondition - this SongRecord has been instantiated
     * @return String object representation of this SongRecord
     */
    public String toString() {
        return ("\t" + title + "\t" + artist + "\t" + min + ":" + sec);
    }
}
