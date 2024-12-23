package org.example;
import java.lang.annotation.*;
/**
 * Класс AutoInjectable является пользовательской аннотацией в Java.
 * То есть он используется для обозначения полей, которые должны быть автоматически внедрены зависимостями.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoInjectable {
}
