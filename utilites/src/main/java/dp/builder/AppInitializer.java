/*
 * Here comes the text of your license
 * Each line should be prefixed with  *
 */
package dp.builder;

/**
 * @author mohamed
 */
public class AppInitializer {
    private SettingsBuilder settingsBluider;

    public void setSettingBuilder(SettingsBuilder sBuilder) {
        settingsBluider = sBuilder;
    }

    public Settings getSettings() {
        return settingsBluider.getSettings();
    }

    public void constructSettings() {
        settingsBluider.createSettings();
        settingsBluider.initMaxConnections();
        settingsBluider.initValidationAfterOneHour();
        settingsBluider.initUsername();
    }
}
