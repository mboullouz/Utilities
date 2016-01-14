/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.basics;

/**
 *
 * @author mohamed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IButton btnOne = new BasicButton("Edit", "/a/b", "btn btn-primary");
        IButton btnTwo = new BasicButton("Delete", "/x/y", "btn btn-danger");
        IContainer dropdown = new Dropdown();
        dropdown.add(btnOne);
        dropdown.add(btnTwo); 
        dropdown.drawHTML();
    }
    
}
