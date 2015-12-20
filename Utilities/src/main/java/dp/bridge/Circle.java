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
public class Circle extends Shape {

    /**
     * Définition des varaibles spécifique à la classe Circle
     */
    private int x, r;

    public Circle(int x, int r, DrawAPI drawApi) {
        super(drawApi);
        this.x = x;
        this.r = r;
    }

    @Override
    public void draw() {
        /**
         *Passage par l'interface de liaison (Bridge) de la classe mère (Abstraction)
         */
        super.drawApi.draw(this.x, this.r);
    }

}
