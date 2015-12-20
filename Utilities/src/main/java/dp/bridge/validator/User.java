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
public class User extends Entity  {
   private String email;
   private int id;
    public User(String email, int id, List<Validator> validators) {
        super(validators);
        this.email=email;
        this.id=id;
    }

    @Override
    public boolean isValidate() {
        for(Validator validator: this.validators){
            if(!validator.validate())
                return false;
        }
        return true;
    }
    
}
