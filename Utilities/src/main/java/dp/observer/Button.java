/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohamed
 */
public class Button implements Observable{
    boolean state=false;
    List<Observer> observersList = new ArrayList<>();
    
    @Override
    public void addObserver(Observer O){
         observersList.add(O);
    };
    public void changeStatus(){
        this.state=true;
        updateAllOberservers(); 
    }
    public void  updateAllOberservers(){
        for(Observer observer:observersList){
            observer.update(this);
        }
    }
 
}
