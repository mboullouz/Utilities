/*
 */
package dp.abs.factory;

/**
 * @author mohamed
 */
public class Partial {
    public Partial(MenuBuilder menuBuilder) {
        Menu menu = menuBuilder.createMenu();
        menu.draw();
    }
}
