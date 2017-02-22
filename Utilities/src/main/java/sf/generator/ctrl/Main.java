/*
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
       Controller controllerOne= SfJsonConverter.jsonToController();
        System.out.println("test generate PHP \n "+controllerOne.toPHP());
        FileManager.generateHTML(controllerOne.toPHP(),controllerOne.getName()+".php"); 
    }
    
}
