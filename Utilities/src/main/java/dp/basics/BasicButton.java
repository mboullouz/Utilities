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
    private String label;
    private String url;
    private String classAttr; 
    
    public BasicButton(String labelButton, String url, String classAttr) {
           this.label= labelButton;
           this.url=url;
           this.classAttr= classAttr;
    }
    
     
    
    @Override
    public void addTo(IContainer container) {
         container.add(this);
    }


    
    public String wrapHTML() {
         return  "<button "
                 + "class='"+this.classAttr+"' href='"+this.url+"'> \n \t"+this.label+"\n"
                 + "</button> \n";
    }

    @Override
    public String getHTML() {
       return "<li>\n\t"+this.wrapHTML()+"</li>\n";
    }

   
 
    
}
