import java.lang.reflect.Array;

/**
 * class implements an abstract data type for a playlist of songs supporting common operations on such lists of audio files
 */
public class Playlist {
    private SongRecord[] playlist;
    private int num;

    /**
     * constructs a playlist with no SongRecords in it
     * postcondition - this Playlist has been initialized to an empty array of SongRecords
     */
    public Playlist(){
        playlist=new SongRecord[50];
        num=0;
    }

    /**
     * method that returns this Playlist's playlist
     * @return this Playlist's playlist
     */
    public SongRecord[] getPlaylist() {
        return playlist;
    }

    /**
     * method that sets the num of this playlist to an integer
     * @param i desired size of playlist
     * postcondition - num is set to the desired integer i
     */
    public void setNum(int i){
        num=i;
    }

    /**
     * method creates and returns clone
     * @return a clone of the desired playlist
     */
    public Playlist clone(){
        Playlist clone=new Playlist();
        for(int n=0;n<num;n++){
            clone.getPlaylist()[n]=playlist[n].clone();
        }
        clone.setNum(num);
        return clone;
    }



    /**
     * method that compares this Playlist to another for equality
     * @param obj - a Playlist in which this Playlist is being compared to
     * @return a boolean value that indicates whether or not this Playlist has the same SongRecords in the same order as another Playlist
     */
    public boolean equals(Playlist obj){
        boolean same=true;
        for(int n=0;n<num;n++){
            if (!this.playlist[n].equals(obj.getPlaylist()[n])){
                same=false;
            }
        }
        return (same&&(this.num==obj.size()));
    }

    /**
     * method that returns the number of SongRecord in this Playlist
     * precondition - this SongRecord has been instantiated
     * @return the number of SongRecord in this Playlist
     */
    public int size(){
        return num;
    }
    /**
     * method that adds a song to this Playlist
     * @param song - the new SongRecord to add to this Playlist
     * @param position - the position in the playlist where song will be inserted
     * precondition - SongRecord song has been instantiated, position is in between 1 and the size+1, number of SongRecords in this Playlist is less than the max capacity
     * postcondition - new SongRecord is stored at desired position, all SongRecords at positions greater than or equal to the desired position has been shifted back one position
     * @throws IllegalArgumentException - the entered position is not within the valid range
     * @throws FullPlaylistException - there is no more room inside of the Playlist to store the new SongRecord
     *
     */
    public void addSong(SongRecord song,int position) throws FullPlaylistException {
        try {
            if (num!=50){
                int s=num;
                s++;
                if (position<0 || position>s) {
                    try{
                        throw new IllegalArgumentException("Entered position is not within range - A");
                    }
                    catch(IllegalArgumentException e){
                        return;
                    }
                }
                else{
                    position=position-1;
                    if (playlist[position]!=null){
                        int x;
                        for(int n=position;n<num;n++){
                            x=n+1;
                            playlist[x]=playlist[n];
                        }
                    }
                    playlist[position]=song;
                    num++;
                    System.out.println("\nSong Added: "+playlist[position].getTitle()+" by "+playlist[position].getArtist());
                }
                return;
            }
            throw new FullPlaylistException();
        }
        catch(FullPlaylistException e){
            System.out.println(e);
            return;
        }
    }

    /**
     * method that removes a song at the desired position
     * @param position position of the song that user wants to remove from playlist
     * precondition - SongRecord song has been instantiated, position is in between 1 and the size
     * postcondition - SongRecord at desired position has been removed, all SongRecords at positions greater than or equal to the desired position has been shifted forward one position
     * @throws SongOutOfBoundsException - the entered position is not within the valid range
     */
    public void removeSong(int position){
        try {
            if (position > 0 && position <= num) {
                position=position-1;
                for (int n=position;n<num;n++){
                    int x=n+1;
                    playlist[n]=playlist[x];
                }
                num--;
                return;
            }
            throw new SongOutOfBoundsException();
        }
        catch(SongOutOfBoundsException e){
            return;
        }
    }

    /**
     * method that returns the song at a desired position
     * @param position position that the desired song is at
     * precondition - this Playlist has been instantiated, position is in between 1 and the size
     * @return the desired SongRecord at position
     * @throws SongOutOfBoundsException - the entered position is not within the valid range
     */
    public SongRecord getSong(int position) {
        try {
            if (position > 0 && position <= num) {
                position = position - 1;
                return playlist[position];
            }
            throw new SongOutOfBoundsException();
        }
        catch(SongOutOfBoundsException e){
            System.out.println(e);
            return null;
        }
    }

    /**
     * method that prints all the songs in this playlist
     * precondition - this SongRecord has been instantiated
     * postcondition - a neatly formatted table of SongRecords in this Playlist on its line and matched with their respective position numbers
     */
    public void printAllSongs(){
        System.out.println(this);
    }

    /**
     * method that returns a playlist with SongRecords that are only by the desired artist
     * @param artist the desired artist that recorded all the SongRecords in the returned playlist
     * postcondition - the original Playlist has been instantiated
     * @return a playlist with SongRecords only by artist
     */
    public Playlist getSongsByArtist(String artist){
        Playlist byArtist=this.clone();
        for (int n=0;n<byArtist.size();n++){
            if ((byArtist.getPlaylist()[n].getArtist().equals(artist))==false){
                int x=n+1;
                byArtist.removeSong(x);
            }
        }
        return byArtist;
    }

    /**
     * method that converts this playlist into a String object
     * @return String object representation of this Playlist
     */
    public String toString(){
        String whole="";
        for(int n=0;n<num;n++){
            int s=n;
            s++;
            whole=whole+(s+"\t"+playlist[n]+"\n");
        }
        return whole;
    }
}
