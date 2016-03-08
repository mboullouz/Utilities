/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.FileManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamed
 */
public class Action {

    private String name;
    private Set<String> params;
    private String viewUrl;
    private Map<String, String> arrayReturn;

    public Action(String name, String viewUrl, Set<String> params) {
        this.name = name;
        this.viewUrl = viewUrl;
        this.params = params;
        this.arrayReturn = new HashMap<>();
    }

    public void addParam(String p) {
        this.params.add(p);
    }

    public void addReturnValue(String key, String value) {
        this.arrayReturn.put(key, value);
    }

    public void loadJson() {
        String json=null;
        try {
            json = FileManager.loadFileAsString("some\file");
            Logger.getLogger(Action.class.getName()).log(Level.INFO, json);
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object readValue = mapper.readValue(json, Object.class);
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, "Can't deserialize Json", ex);
        }
    }
 

}
