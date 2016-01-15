/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author mohamed
 */
public class FileGenerator {

    public static void generateHTML(String htmlContent) {
        try {
            LocalDateTime timePoint = LocalDateTime.now();
            
            String suffix=""+timePoint.getHour()+"_"+timePoint.getMinute();
            
            File file = new File("C:\\Users\\mohamed\\Desktop\\htmlContent\\page"+suffix+".html");
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
            System.out.println(""+e.getMessage());
        }
    }
}
