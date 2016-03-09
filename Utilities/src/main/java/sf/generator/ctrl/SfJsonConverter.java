/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.FileManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convertir les classe depuis le JSON
 * @author mohamed
 */
public class SfJsonConverter { 
    
    private static ObjectMapper mapper = new ObjectMapper();
    
    public static  Action jsonToAction() {
        String jsonString=null;
        try {
            jsonString = FileManager.loadFileAsString(FileManager.ACTION_JSON_FILE_PATH);
            Logger.getLogger(Action.class.getName()).log(Level.INFO, jsonString);
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Action readValue = mapper.readValue(jsonString, Action.class);
            return readValue;
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, "Can't deserialize Json \n", ex);
           
        }
        return null;
    }
    
    public static  Controller jsonToController() {
        String jsonString=null;
        try {
            jsonString = FileManager.loadFileAsString(FileManager.CONTROLLER_JSON_FILE_PATH);
            Logger.getLogger(Controller.class.getName()).log(Level.INFO, jsonString);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Controller readValue = mapper.readValue(jsonString, Controller.class);
            return readValue;
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "Can't deserialize Json \n", ex);
           
        }
        return null;
    }
}
