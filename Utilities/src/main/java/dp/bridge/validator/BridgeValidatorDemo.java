/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.bridge.validator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohamed
 */
public class BridgeValidatorDemo {
    public static void main(String[] args){
        String email= "med@op.com";
        Integer id=12;
        List<Validator> validatorList= new ArrayList<>();
        validatorList.add(new EmailValidator(email));
        validatorList.add(new IdentityValidator(id));
        
        Entity user = new User(email,13, validatorList);
        if(user.isValidate())
            System.out.println("L'utilisateur est valide !");
        else
            System.out.println("not valide *__* ");
    }
}
