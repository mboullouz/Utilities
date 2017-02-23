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
abstract public class Shape{
    /**
     * La liaison est faite au niveau d'abstraction le plus elevé
     * la variable drawApi est protégé pour permettre utililisation depuis
     * les classes fille
     */
    protected DrawAPI drawApi;
    
    /**
     * Le constructeur ne prend pas en paramètre les variables x,r
     * car sont spécifiques aux classes filles
     * @param drawApi 
     */
    public Shape(DrawAPI drawApi){
         
        this.drawApi=drawApi;
    }
    /**
     * Créer le contrat de l'implémentation de la caractéristique Draw
     */
    abstract public void draw();

    
}
