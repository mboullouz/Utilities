/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package dp.builder;

/**
 *
 * @author mohamed
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppInitializer appInitializer = new AppInitializer();
        SettingsBuilder departmentSettings = new DepartmentSettings();
        SettingsBuilder userSettings = new UserSettings();

        System.out.println("Start intializing Depatments settings \n ...");
        appInitializer.setSettingBuilder(departmentSettings);
        appInitializer.constructSettings();
        System.out.println("End intializing Depatments settings \n ==\n");

        System.out.println("Start intializing USER settings \n ...");
        appInitializer.setSettingBuilder(userSettings);
        appInitializer.constructSettings();
        System.out.println("End intializing User settings \n ==\n");
    }

}
