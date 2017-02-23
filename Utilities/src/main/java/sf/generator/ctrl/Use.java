/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import java.util.HashSet;
import java.util.Set;

/**
 * Only names of classes to use
 * The UseScanner must be able to find the correct namespace
 * @author mohamed
 */
public class Use {
   
    private Set<String> lines = new HashSet<>();
    public Use(){
        
    }
    
    public void addLine(String line){
        lines.add(line);
    }

    public Set<String> getLines() {
        return lines;
    }

    public void setLines(Set<String> lines) {
        this.lines = lines;
    }

    
    
    
}
