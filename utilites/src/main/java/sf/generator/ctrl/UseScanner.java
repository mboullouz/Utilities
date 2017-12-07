/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * find the namespace by scanning the Use and by looping over directories and
 * files
 *
 * @author mohamed
 */
public class UseScanner {

    private File fileFound = null;

    /**
     * @param use
     */
    public void scan(Use use) {

        use.getLines().forEach((String l) -> {
            fileFound = searchForClassInFolder(l.toLowerCase());
        });

    }

    @SuppressWarnings("resource")
    public String getLineContainingNamespace() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(fileFound);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.toLowerCase().contains("namespace")) {
                    return line;
                }
            }
        } catch (FileNotFoundException e) {
            scanner.close();
        }
        return "";
    }

    /**
     * Loop over all directories/and sub direcories for file return first match,
     * null instead
     *
     * @param className
     * @return
     */
    public File searchForClassInFolder(String className) {
        for (File file : new File(SfSettings.VENDOR_DIRECTORY_PATH).listFiles()) {
            if (file.getName().toUpperCase().contains("PHP")) {
                return file;
            }
        }
        return null;
    }
}
