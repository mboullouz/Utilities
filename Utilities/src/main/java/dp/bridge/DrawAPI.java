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
public interface DrawAPI {
    /**
     * Creation du contrat
     * DrawAPI est le Bridge entre l'abstraction 'Shape' est les fonctionnalités
     *  -RedCircle 
     *  -GreenCircle
     * @param x
     * @param r 
     */
    public void draw(int x,int r);
}
