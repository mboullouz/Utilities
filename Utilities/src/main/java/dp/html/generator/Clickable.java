/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
