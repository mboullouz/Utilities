/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.bridge.validator;

/**
 *
 * @author mohamed
 */
class IdentityValidator implements Validator {

    private int id;

    public IdentityValidator(Integer id) {
        this.id=id;
    }
    @Override
    public boolean validate() {
       return this.id%2==0;  
    }
    
}
