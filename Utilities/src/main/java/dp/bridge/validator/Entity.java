/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.bridge.validator;

import java.util.List;

/**
 *
 * @author mohamed
 */
public abstract class Entity {
    protected List<Validator> validators;
    public Entity(List<Validator> validators){
        this.validators=validators;
    }
    abstract public boolean isValidate();
}
