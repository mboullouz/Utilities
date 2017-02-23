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
public interface IElement {
    void addTo(IContainer container);
    String getElementHTML();
}
