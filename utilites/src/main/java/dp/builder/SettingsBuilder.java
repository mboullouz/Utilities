/*
 * Here comes the text of your license
 * Each line should be prefixed with  *
 */
package dp.builder;

/**
 * @author mohamed
 */
public abstract class SettingsBuilder {
    protected Settings settings;

    public Settings getSettings() {
        return settings;
    }

    public void createSettings() {
        settings = new Settings();
    }

    abstract void initValidationAfterOneHour();

    abstract void initMaxConnections();

    abstract void initUsername();

}
