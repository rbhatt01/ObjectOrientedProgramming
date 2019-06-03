import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
      ArtistComparator test = new ArtistComparator();
      assertEquals(test.compare(songs[0], songs[0]), 0);
      assertEquals(test.compare(songs[0], songs[1]), -14);
      assertEquals(test.compare(songs[3], songs[4]), 4);
   }

   @Test
   public void testLambdaTitleComparator()
   {
      Comparator<Song> comp = (one, two) -> one.getTitle().compareTo(two.getTitle());
      assertEquals(comp.compare(songs[0], songs[0]), 0);
      assertEquals(comp.compare(songs[0], songs[1]), 8);
      assertEquals(comp.compare(songs[3], songs[2]), -18);
   }

   @Test
   public void testYearExtractorComparator()
   {
      Comparator<Song> comp = Comparator.comparing(Song :: getYear);
      comp = comp.reversed();
      assertEquals(comp.compare(songs[0], songs[1]), 0);
      assertEquals(comp.compare(songs[4], songs[5]), -1);
      assertEquals(comp.compare(songs[1], songs[2]), 1);

   }

   @Test
   public void testComposedComparator()
   {
      Comparator<Song> artist = Comparator.comparing(Song :: getArtist);
      Comparator<Song> year = Comparator.comparing(Song :: getYear);
      ComposedComparator test = new ComposedComparator(artist, year);
      assertEquals(test.compare(songs[3], songs[7]), 1);
      assertEquals(test.compare(songs[7], songs[3]), -1);
      assertEquals(test.compare(songs[7], songs[7]), 0);
      assertEquals(test.compare(songs[1], songs[2]), 17);

   }

   @Test
   public void testThenComparing()
   {
      Comparator<Song> comp = (one, two) -> one.getTitle().compareTo(two.getTitle());
      comp = comp.thenComparing(Comparator.comparing(Song :: getArtist));
      assertEquals(comp.compare(songs[3], songs[5]), 1);
      assertEquals(comp.compare(songs[5], songs[3]), -1);
      assertEquals(comp.compare(songs[1], songs[1]), 0);
   }

   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      songList.sort(new ArtistComparator());

      assertEquals(songList, expectedList);
   }
}
