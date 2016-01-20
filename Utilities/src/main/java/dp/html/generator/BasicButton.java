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
public class BasicButton implements IMenuItem {
    private String label;
    private String url;
    private String classAttr; 
    private String elementId;
    public String  jsCode="";
    public BasicButton(String labelButton, String url, String classAttr) {
           this.label= labelButton;
           this.url=url;
           this.classAttr= classAttr;
           this.elementId=this.toString();    
    }
    @Override
    public void addTo(IContainer container) {
         container.add(this);
    }
    @Override
    public String getElementHTML() {
         getElementJs();//Attatch click behavior!
         return  "<button "
                 +"id='"+this.elementId+"'"
                 + "class='"+this.classAttr+"' href='"+this.url+"'> \n \t"+this.label+"\n"
                 + "</button> \n";
    }

    @Override
    public String wrapHTML() {
       return "<li>\n\t"+this.getElementHTML()+"</li>\n";
    }

    @Override
    public String getElementJs() {       
        return this.jsCode;       
    }

    @Override
    public void attachJsFunction(String jsFunction) {
        this.jsCode="<script> document.getElementById('"+this.elementId+"').onclick ="+jsFunction+"</script>";
    }
    
}
