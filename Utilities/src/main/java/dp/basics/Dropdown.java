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
    
    private List<IElement> menuItems;
    private IButton headBtn;
    
    public Dropdown(){
        this.menuItems= new ArrayList<>();
        this.headBtn = new BasicButton("Action", "#", "btn");
       
    }

    @Override
    public void add(IElement element) {
        menuItems.add(element);
    }

    @Override
    public void drawHTML() {
        String htmlString = "<div class='container'> \n"+ this.headBtn.drawHTML();//Draw first
        for(IElement element : menuItems){
           htmlString+= element.drawHTML(); //@todo use stringBuffer
        }
        htmlString+="</div> \n";
        System.out.println(htmlString); //For test!
    }
}
