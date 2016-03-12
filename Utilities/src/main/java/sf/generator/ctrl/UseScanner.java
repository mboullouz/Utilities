/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import java.io.File;
import java.util.Iterator;
import java.util.function.Consumer;
import org.apache.commons.io.FileUtils;

/**
 * find the namespace by scanning the Use and by looping over directories and
 * files
 *
 * @author mohamed
 */
public class UseScanner {

    /**
     *
     * @param use
     */
    public void scan(Use use) {
        use.getLines().forEach((String l) -> {
            searchNamespace(l.toLowerCase());
        });
     
    }

    /**
     * @todo Loop over folders and copy namespace if exits
     * @param str
     */
    private void searchNamespace(String str) {

    }

    /**
     * Loop over all directories/and sub direcories for file return first match,
     * null instead
     *
     * @param className
     * @return
     */
    public File searchForClassInFolder(String className) {
        Iterator it = FileUtils.iterateFiles(new File(SfSettings.VENDOR_DIRECTORY_PATH), new String[]{"php,PHP"}, true);
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.getName().equals(className + ".php")) {//fileExtension
                return file;
            }
        }
        return null;
    }
}
