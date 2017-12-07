/*
 */
package sf.generator.ctrl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mohamed
 */
public class Controller {
    private List<Use> uses;
    private String name;
    private String namespace;
    private Set<Action> actions;

    public Controller(String name, String namespace, List<Use> uses) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);//capitalize uper
        this.namespace = namespace;
        this.uses = uses;
        this.actions = new HashSet<>();
    }

    /**
     * Default constructor pour Jackson decerialisation
     */
    public Controller() {

    }

    public String toPHP() {
        String result;
        String strUses = "";
        strUses = uses.stream().map((s) -> s + ";\n").reduce(strUses, String::concat);
        String strActions = "";
        strActions = actions.stream().map((a) -> a.toPHP() + "\n\n").reduce(strActions, String::concat);
        result = "<?php \nnamespace " + namespace + "; \n" + strUses + "\n"
                + "class " + name + " extends Controller { \n"
                + strActions + " \n } \n";

        return result;
    }

    public void addAction(Action a) {
        actions.add(a);
    }

    public List<Use> getUses() {
        return uses;
    }

    public void setUses(List<Use> uses) {
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
