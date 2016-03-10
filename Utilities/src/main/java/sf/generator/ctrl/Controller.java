/*
 */
package sf.generator.ctrl;

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
        this.name=name.substring(0, 1).toUpperCase() + name.substring(1);//capitalize uper
        this.namespace= namespace;
        this.uses= uses;
        this.actions= new HashSet<>();
    }
    /**
     * Default constructor pour Jackson decerialisation
     */
    public Controller(){
        
    }
    public String toPHP(){
        String result ;
        String strUses="";
        for(String s:uses){
            strUses+=s+";\n";
        }
        String strActions="";
        for(Action a:actions){
            strActions+=a.toPHP()+"\n\n";
        }
        result= "<?php \nnamespace "+namespace+"; \n"+strUses+"\n"
                +"class "+name +" extends Controller { \n"
                +strActions+" \n } \n";
        
        return result;
    }
    
    public void addAction(Action a){
        actions.add(a);
    }
     public List<String> getUses() {
        return uses;
    }

    public void setUses(List<String> uses) {
        this.uses = uses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }
}
