/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mohamed
 */
public class Use {
    private Set<String> lines = new HashSet<>();
    public Use(){
        
    }
    
    public void addLine(String line){
        lines.add(line);
    }

    
    
    
}
