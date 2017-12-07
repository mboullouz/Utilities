/*
 * Here comes the text of your license
 * Each line should be prefixed with  *
 */
package dp.builder;

/**
 * @author mohamed
 */
public class DepartmentSettings extends SettingsBuilder {
    private int numberOfEmployees = 20;

    @Override
    void initValidationAfterOneHour() {
        System.out.println("Init department validations !\n");
        settings.setAllowValidationAfterOneHour(false);
    }

    @Override
    void initMaxConnections() {
        System.out.println("Init department MaxConnection!\n");
        settings.setMaxConnections(numberOfEmployees * 5);
    }

    @Override
    void initUsername() {

        settings.setUsername("");
    }

}
