/**
 * class that tests the methods of the Playlist class and allows a user to manipulate a single Playlist object by performing operations on it
 */

import java.util.Scanner;
public class PlaylistOperations{
    /**
     * main method that allows a user to manipulate Playlist currentPlay by performing operations on it
     * @param args
     * @throws FullPlaylistException - a desired SongRecord cannot be added to Playlist currentPlay because it is full
     * @throws IllegalArgumentException - user did not enter an option from the menu
     */
    public static void main(String args[]) throws FullPlaylistException {
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        Playlist currentPlay=new Playlist();
        char input;
        boolean quit=false;
        while(quit==false){
            System.out.println("A) Add Song\nB) Print Songs by Artist\nG) Get Song\nR) Remove Song\nP) Print All Songs\nS) Size\nQ) Quit");
            input=sc.next().charAt(0);
            if(input=='A'||input=='a'){
                String t,a;
                int m,s,p;
                System.out.print("Enter the song title: ");
                t=sc.next();
                System.out.print("\nEnter the song artist: ");
                a=sc.next();
                System.out.print("\nEnter the song length(minutes): ");
                m=sc.nextInt();
                System.out.print("\nEnter the song length (seconds): ");
                s=sc.nextInt();
                if(s<0||s>60){
                    System.out.println("Invalid second. Please enter an integer in between 0 and 59, inclusively.");
                    s=sc.nextInt();
                }
                System.out.print("\nEnter the position: ");
                p=sc.nextInt();
                SongRecord newSong=new SongRecord(t,a,m,s);
                currentPlay.addSong(newSong,p);
            }
            else if(input=='B'||input=='b'){
                String desiredArtist;
                System.out.print("Enter the artist: ");
                desiredArtist=sc.next();
                Playlist byArtist=currentPlay.getSongsByArtist(desiredArtist);
                header();
                System.out.println(byArtist);
            }
            else if(input=='G'||input=='g'){
                int p;
                System.out.print("Enter the position: ");
                p=sc.nextInt();
                SongRecord get=currentPlay.getSong(p);
                if (get!=null){
                    header();
                    System.out.println(p+"\t"+get);
                }
            }
            else if(input=='R'||input=='r'){
                int p;
                System.out.print("Enter the position: ");
                p=sc.nextInt();
                if (currentPlay.getSong(p)!=null) {
                    System.out.println(currentPlay.getSong(p).getTitle() + " by " + currentPlay.getSong(p).getArtist() + " has been removed");
                }
                currentPlay.removeSong(p);
            }
            else if(input=='P'||input=='p'){
                header();
                currentPlay.printAllSongs();
            }
            else if(input=='S'||input=='s'){
                System.out.println("There are "+currentPlay.size()+" song(s) in the current playlist");
            }
            else if(input=='Q'||input=='q'){
                quit=true;
            }
            else{
                try{
                    throw new IllegalArgumentException("Invalid Input");
                }
                catch (IllegalArgumentException e){
                    System.out.println("Please select an option from the menu.");
                }
            }
        }
    }

    /**
     * method that prints the header before any SongRecord or Playlist data are presented
     * postcondition - a neat header for the table of SongRecords in Playlist currentPlay
     */
    public static void header(){
        System.out.println("Song#\tTitle\t\t\tArtist\t\tLength");
        System.out.println("--------------------------------------------");
    }
}
