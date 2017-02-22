/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package dp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohamed
 */
public class Container implements HTMLComponent {

    private List<HTMLComponent> components;

    public Container() {
        init();
    }
    
    public final void init() {
        this.components = new ArrayList<>();
    }

    public Container(List<HTMLComponent> components) {
        this.components = components;
    }

    public void addComponent(HTMLComponent component) {
        this.components.add(component);
    }

    public void clear() {
        init();
    }

    @Override
    public void toHTML() {
        for (HTMLComponent component : components) {
            component.toHTML();
        }
    }

}
