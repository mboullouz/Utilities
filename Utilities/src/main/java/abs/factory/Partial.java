/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package abs.factory;

/**
 *
 * @author mohamed
 */
public class Partial {
    public Partial(MenuBuilder menuBuilder){
        Menu menu = menuBuilder.createMenu();
        menu.draw();
    }
}
