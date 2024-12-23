package org.example;
/**
 * Класс загрузчика свойств из файла properties.
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private static final String PROPERTIES_FILE = "injector.properties";

    /**
     * Загружает свойства из файла injector.properties в объект Properties.
     *
     * @return объект Properties, содержащий загруженные свойства
     */
    public Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
                return properties;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
