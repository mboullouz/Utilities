 


package dp.html.generator;

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
        
    }

    @Override
    public String toHTML() {
        String htmlString =  "<div class='container'> \n \t<ul>"+ this.headBtn.getElementHTML();//Draw first
        for(IMenuItem element : menuItems){
           htmlString+= element.wrapHTML(); //@todo use stringBuffer
        }
        htmlString+="</ul>\n</div> \n";
        for(IMenuItem element : menuItems){
           htmlString+= element.getElementJs();  
        } 
        return htmlString;
    }
}
