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
public class Room implements Observer{

    @Override
    public void update(Observable o) {
        System.out.println("Make walls yellow !");
    }
    
}
