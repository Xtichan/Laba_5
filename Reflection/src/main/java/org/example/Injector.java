package org.example;
/**
 * Класс, отвечающий за внедрение зависимостей с использованием механизма рефлексии и файлов properties.
 */
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    private Properties properties;

    /**
     * Создает новый экземпляр класса Injector и загружает свойства из файлов properties.
     */
    public Injector() {
        PropertyLoader propertyLoader = new PropertyLoader();
        this.properties = propertyLoader.loadProperties();
    }

    /**
     * Внедряет зависимости для указанного объекта, основываясь на аннотации @AutoInjectable и свойствах из файла properties.
     *
     * @param object объект, для которого нужно внедрить зависимости
     * @param <T>    тип объекта
     * @return внедренный объект с проинициализированными зависимостями
     */
    public <T> T inject(T object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                Class<?> fieldType = field.getType();
                String implementationClassName = properties.getProperty(fieldType.getName());
                try {
                    Class<?> implementationClass = Class.forName(implementationClassName);
                    Object instance = implementationClass.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(object, instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
