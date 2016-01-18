/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.html.generator;

import common.FileGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mboullouz
 */
public  class Dropdown implements IContainer{
    
    private List<IMenuItem> menuItems;
    private Clickable headBtn;
    
    public Dropdown(){
        this.menuItems= new ArrayList<>();
        this.headBtn = new BasicButton("Action", "#", "btn");
       
    }

    @Override
    public void add(IMenuItem element) {
        menuItems.add(element);
    }

    @Override
    public void drawHTML() {
        String headPage="<html><head>Test page!</head><body>\n\t";
        String htmlString = headPage+
               "<div class='container'> \n \t<ul>"+ this.headBtn.getElementHTML();//Draw first
        for(IMenuItem element : menuItems){
           htmlString+= element.wrapHTML(); //@todo use stringBuffer
        }
        htmlString+="</ul>\n</div> \n";
        for(IMenuItem element : menuItems){
           htmlString+= element.getElementJs(); //@todo use stringBuffer
        } 
        htmlString+="\n</body>\n</html>";
        FileGenerator.generateHTML(htmlString);
    }
}
