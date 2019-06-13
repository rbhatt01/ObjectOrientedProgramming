import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileTest {
    private List<Point> points;
    public static void main (String[]args) {
        //final String filename = getFilename(args);
        final String filename = "positions.txt";
        List<Point> points = new ArrayList<>();
        try {
            File reader = new File(filename);
            Scanner s = new Scanner(reader);
            processFile(s,points);
            BufferedWriter writer = new BufferedWriter(new FileWriter("drawMe.txt"));
            points = points.stream().filter(p -> p.getZ() <= 2.0).map(point -> point.scale(0.5)).
                    map(point -> point.translate(new Point(-150, -37, 0))).collect(Collectors.toList());
            for (int i = 0; i < points.size(); i ++) {
                writer.write(points.get(i).getX() + ", "+ points.get(i).getY()+ ", "+ points.get(i).getZ()+ "\n");
            }
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void processLine(String line, List <Point> points )
    {

        String[] words = line.split(",\\s");
        if (words.length == 0)
        {
            return;
        }
        points.add(new Point(Double.parseDouble(words[0]), Double.parseDouble(words[1]), Double.parseDouble(words[2])));
    }

    public static void processFile(Scanner input, List<Point> points)
    {
        while (input.hasNextLine())
        {
            processLine(input.nextLine(), points);
        }
    }

    private static String getFilename(String[] args)
	{
		if (args.length < 1)
		{
			System.err.println("Log file not specified.");
			System.exit(1);
		}

		return args[0];
	}
}
