/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package dp.builder;

/**
 *
 * @author mohamed
 */
public class Settings {
    
    private boolean allowValidationAfterOneHour=false;
    private int maxConnections=10;
    private String username="ADMIN";

    public void setAllowValidationAfterOneHour(boolean allowValidationAfterOneHour) {
        this.allowValidationAfterOneHour = allowValidationAfterOneHour;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
     
}
