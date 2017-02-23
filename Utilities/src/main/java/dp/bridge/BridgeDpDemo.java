/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.bridge;

/**
 *
 * @author mohamed
 */
public class BridgeDpDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shape redCircle = new Circle(10,5,new RedCircle());
        Shape greenCircle = new Circle(11,7, new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
    
}
