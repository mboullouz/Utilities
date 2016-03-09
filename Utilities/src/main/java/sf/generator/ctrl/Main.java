/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import common.FileManager;

/**
 *
 * @author mohamed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Action actionOne= SfJsonConverter.jsonToAction();
        System.out.println("test generate PHP \n "+actionOne.toPHP());
        FileManager.generateHTML(actionOne.toPHP()); 
    }
    
}
