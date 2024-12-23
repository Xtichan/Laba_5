package org.example;
import org.example.AutoInjectable;
/**
 * Класс SomeBean служит для работы с пользовательскими аннотациями AutoInjectable
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    /**
     * Метод для использования имеющихся полей
     */
    public void foo() {
        field1.doSomething();
        field2.doSomething();
    }
}
