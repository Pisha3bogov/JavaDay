import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        File file = new File("sourceList.txt");
        if (file.exists()) {
            System.out.println("File exist ... Ok ...");
        }
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
        }
        File outFile = new File("outFile.txt");
        if (outFile.createNewFile()) {
            System.out.println("Output file created");
        } else
            System.out.println("File created");
        try (FileWriter writer = new FileWriter(outFile)) {
            int count = 1;
            for (String line : strings) {
                line = delDate(line);
                line = replaceName(line);

                writer.write(count + ") " + line + "\n" + "\n");
                count++;

            }
        }
    }

    public static String delDate(String str) {
        return str.replaceAll("[^а-яА-я\s]", "");
    }

    public static String replaceName(String str) {
        StringBuffer result = new StringBuffer();
        String[] array = str.split(" ");
        array[1] = array[1].charAt(0) + ".";
        array[2] = array[2].charAt(0) + ".";
        for (String s : array) {
            result.append(s).append(" ");
        }
        return result.toString();
    }
}