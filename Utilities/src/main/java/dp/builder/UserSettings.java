/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package dp.builder;

/**
 *
 * @author mohamed
 */
public class UserSettings extends SettingsBuilder{
    private String role="ROOT"; //simulate something we can get from a DB!
    @Override
    void initValidationAfterOneHour() {
        if(role.equals("ROOT")){
             System.out.println("Init User Validation As ROOT !\n");
            settings.setAllowValidationAfterOneHour(true);
        }
        else {
            settings.setAllowValidationAfterOneHour(false);
              System.out.println("Init User Validation : normal user!\n");
        }
    }

    @Override
    void initMaxConnections() {
        System.out.println("Init User max connections to: 5 !\n");
        settings.setMaxConnections(5);
    }

    @Override
    void initUsername() {
        System.out.println("Init User # Username is now: USER !\n");
        settings.setUsername("USER");
    }
    
}
