/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mohamed
 */
public class Controller {
    private List<String> uses;
    private String name;
    private String namespace;
    
    private Set<Action> actions;
    
    public Controller(String name, String namespace,List<String> uses){
        this.name=name;
        this.namespace= namespace;
        this.uses= uses;
        this.actions= new HashSet<>();
    }
    
    public void addAction(Action a){
        actions.add(a);
    }
    
}
