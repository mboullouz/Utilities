/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.html.generator;

import common.FileManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohamed
 */
public class Page {

    List<IContainer> elements;

    public Page() {
        this.elements = new ArrayList<>();
    }
    
    public void addContainer(IContainer c){
        elements.add(c);
    }

    public void toHTML() {
        String headPage = "<html><head>Test page!</head><body>\n\t";
        String htmlString = headPage+"";
        for(IContainer c: elements){
            htmlString+=c.toHTML();
        }
        htmlString += "\n <b>Page generated!</b>\n </body>\n</html>";
        FileManager.generateHTML(htmlString,"page.html");
    }
}
