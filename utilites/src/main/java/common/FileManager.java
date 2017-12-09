package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mohamed
 */
public class FileManager {


    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String loadFileAsString(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    /**
     * Load file relative to class
     * No line separator is appended!
     * @param clazz to use a resource
     * @param fileName to load
     * @return a list of lines
     */
    public static List<String> fileToLines(Class<?> clazz, String fileName) {
        List<String> lines;
        try (Scanner scanner = new Scanner(clazz.getResourceAsStream("/" + fileName)).useDelimiter("\\A");) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.next());
            }
        }
        return lines;
    }

    /**
     *
     * @param clazz resource class
     * @param fileName file
     * @return the file as a string including line seprator char
     */
    public static String fileToString(Class<?> clazz, String fileName) {
        final StringBuilder sb = new StringBuilder();
        final List<String> lines = fileToLines(clazz, fileName);
        int i = 0;
        for (String s : lines) {
            sb.append(s);
            /* Skip adding 'new-line symbol' to last line */
            if (i < lines.size() - 1) {
                sb.append("\r");
            }
            i++;
        }
        return sb.toString();
    }


}
