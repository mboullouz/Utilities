/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.observer;

/**
 *
 * @author mohamed
 */
public class Execution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Light light = new Light();
        Room room = new Room();
        Button btn = new Button();
        
        //link
        btn.addObserver(room);
        btn.addObserver(light);
        
        btn.changeStatus();
    }
    
}
