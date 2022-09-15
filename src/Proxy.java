import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Proxy<T> {

    private T obj;

    public Proxy(T obj) {
        this.obj = obj;
    }

    public void setName(String name) {
        System.out.println("Установка имени для объекта");
        try {
            Method method = obj.getClass().getDeclaredMethod("setName", String.class);
            method.invoke(obj, name);
            System.out.println("Установка имени для объекта завершена успешно");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Установка имени для объекта завершена с ошибкой: " + e.getMessage());
        }
    }
}
