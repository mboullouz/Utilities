/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mohamed
 */
public class Action {
    private String name;
    private Set<String> params;
    private String viewUrl;
    private Map<String,String> arrayReturn;
    public Action(String name,String viewUrl, Set<String> params){
        this.name=name;
        this.viewUrl= viewUrl;
        this.params= params;
        this.arrayReturn= new HashMap<>();
    }
    public void addParam(String p){this.params.add(p);}
    public void addReturnValue(String key, String value){
        this.arrayReturn.put(key, value);
    }
  
    
}
