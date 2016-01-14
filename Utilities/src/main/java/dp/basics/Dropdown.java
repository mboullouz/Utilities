/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.basics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mboullouz
 */
public  class Dropdown implements IContainer{
    
    private IButton topButton;
    private List<IElement> menuItems;
    public Dropdown(IElement btnLabel){
        this.menuItems= new ArrayList<>();
        this.topButton = new BasicButton(btnLabel);
    }

    @Override
    public void add(IElement element) {
        menuItems.add(element);
    }

    @Override
    public void drawHTML() {
        for(IElement element : menuItems){
            element.drawHTML();
        }
    }
}
