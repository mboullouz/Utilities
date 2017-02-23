

package dp.html.generator;

/**
 *
 * @author mboullouz
 */
public interface Clickable extends IElement{
    /**
     * @return Js to append in the end of file!
     * @todo add something related to events and clicks 
     */
    String getElementJs(); 
    void attachJsFunction(String jsFunction);
}
