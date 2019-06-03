import java.util.Comparator;

public class ArtistComparator implements Comparator<Song> {
    public ArtistComparator(){

    }
    public int compare(Song one, Song two){
        if(one.getArtist().compareTo(two.getArtist()) != 0){
            return one.getArtist().compareTo(two.getArtist());
        } else {
            return one.getYear() - two.getYear();
        }
    }
}