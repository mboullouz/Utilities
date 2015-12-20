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
public class EmailValidator implements Validator {
    private String toValidate;
    public EmailValidator(String toValidate) {
        this.toValidate=toValidate;
    }

    @Override
    public boolean validate() {
       return toValidate.contains("@") && toValidate.contains(".");  
    }
    
}
