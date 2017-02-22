package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author mohamed
 */
public class FileManager {
    public static final String ACTION_JSON_FILE_PATH="C:\\Users\\mohamed\\Desktop\\htmlContent\\action.json";
    public static final String CONTROLLER_JSON_FILE_PATH="C:\\Users\\mohamed\\Desktop\\htmlContent\\controller.json";

    public static void generateHTML(String htmlContent, String generatedFileName) {
        try {
            LocalDateTime timePoint = LocalDateTime.now();

            String suffix = "" + timePoint.getHour() + "_" + timePoint.getMinute();

            File file = new File("C:\\Users\\mohamed\\Desktop\\htmlContent\\"+generatedFileName);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(htmlContent);
            bufferWriter.close();
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }
    /**
     * Crédit SO
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
    
   
}
