package ch.jmnetwork.cookieclicker.util;

import java.util.Properties;

public class PropertiesHandler {

    Properties props = new Properties();
    File f;

    /**
     * Constructor
     *
     * @param propertiesLocation the properties file to save to
     */
    public PropertiesHandler(String propertiesLocation) {
        f = new File(propertiesLocation);

        try {
            if (f.exists()) {
                props.loadFromXML(new FileInputStream(f));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PropertiesHandler(File properties) {
        f = properties;

        try {
            if (f.exists()) {
                props.loadFromXML(new FileInputStream(f));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperty(String key, String value) {
        System.out.println("[set] " + key + ": " + value);
        props.setProperty(key, value);
    }

    /**
     * Returns the Property stored in the properties
     *
     * @param key Key to return
     * @return value of the key
     */
    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        System.out.println("[read] " + key + ": " + props.getProperty(key, defaultValue));
        return props.getProperty(key, defaultValue);
    }

    /**
     * Saves properties to specified XML File
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveProperties() {
        try {
            props.storeToXML(new FileOutputStream(f), "JProperties Handler 1.0 www.jmnetwork.ch");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
