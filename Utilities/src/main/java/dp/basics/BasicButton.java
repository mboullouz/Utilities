/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.basics;

/**
 *
 * @author mboullouz
 */
public class BasicButton implements IButton {
    private IElement label;
    private IElement url;
    private String classAttr; 
    
    public BasicButton(IElement labelButton) {
           this.label= labelButton;
    }
    
     
    
    @Override
    public void addTo(IContainer container) {
         container.add(this);
    }


    @Override
    public String drawHTML() {
         return  "<button class='>"
                 +this.classAttr+"'>"+this.label
                 + "</button>";
    }
 
    
}
