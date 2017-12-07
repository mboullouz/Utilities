/*
 * Something about license!
 */
package dp.composite;

/**
 * @author mohamed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HTMLComponent button = new Button();
        HTMLComponent input = new Input();

        Container simpleContainer = new Container();
        simpleContainer.addComponent(input);
        simpleContainer.addComponent(button);
        simpleContainer.addComponent(new Button());

        Container rootContainer = new Container();
        rootContainer.addComponent(simpleContainer);

        rootContainer.toHTML();

        rootContainer.clear();
        System.out.println("Noting to show \n container is cleared");
        rootContainer.toHTML();

    }

}
