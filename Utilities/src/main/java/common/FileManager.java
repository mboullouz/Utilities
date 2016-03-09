package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import sf.generator.ctrl.Action;

/**
 *
 * @author mohamed
 */
public class FileManager {
    public static final String JSON_FILE_PATH="C:\\Users\\mohamed\\Desktop\\htmlContent\\data.json";
    public static void generateHTML(String htmlContent) {
        try {
            LocalDateTime timePoint = LocalDateTime.now();

            String suffix = "" + timePoint.getHour() + "_" + timePoint.getMinute();

            File file = new File("C:\\Users\\mohamed\\Desktop\\htmlContent\\page.html");
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
    
    public static Action loadJson() {
        String jsonString=null;
        try {
            jsonString = FileManager.loadFileAsString(JSON_FILE_PATH);
            Logger.getLogger(Action.class.getName()).log(Level.INFO, jsonString);
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            Action readValue = mapper.readValue(jsonString, Action.class);
            return readValue;
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, "Can't deserialize Json", ex);
           
        }
        return null;
    }
}
