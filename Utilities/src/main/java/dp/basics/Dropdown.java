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
public  class Dropdown {
    
    private IButton topButton;
    private List<IMenuItem> menuItems;
    public Dropdown(IElement btnLabel){
        this.menuItems= new ArrayList<>();
        this.topButton = new BasicButton(btnLabel);
    }
}
