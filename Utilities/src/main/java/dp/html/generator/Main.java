/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.html.generator;

/**
 *
 * @author mohamed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IMenuItem btnOne = new BasicButton("Edit", "/a/b", "btn btn-primary");
        IMenuItem btnTwo = new BasicButton("Delete", "/x/y", "btn btn-danger");
        btnOne.attachJsFunction("function(){confirm('OK ? or OK? :)');}");
        IContainer dropdown = new Dropdown();
        dropdown.add(btnOne);
        dropdown.add(btnTwo);
         
        Page page = new Page();
        page.addContainer(dropdown);
        page.toHTML();
    }

}
