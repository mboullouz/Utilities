package dp.html.generator;

/**
 * @author mboullouz
 */
public interface IContainer {
    void add(IMenuItem element);

    void drawHTML();

    String toHTML();
}
