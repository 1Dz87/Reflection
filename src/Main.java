import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car c = Car.makeCar("Lada", 1);
        Proxy<Car> proxy = new Proxy<>(c);
        proxy.setName("OKA");

        System.out.println(c);
    }

    public static void methods(Class clazz, Object c) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        for (Method meth : clazz.getDeclaredMethods()) {
            if (meth.getName().equals("setName")
                    && meth.getParameterCount() > 1) {
                meth.invoke(c, "ОКА", 5);
            }
        }
        System.out.println(c);
        Method m = clazz.getDeclaredMethod("smth");
        System.out.println(m);
        Method pubM = clazz.getMethod("getName");
        System.out.println(pubM);
        Method set = clazz.getMethod("setName", String.class, Integer.class);
        System.out.println(set);
    }

    public static void fields(Class clazz, Object c) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotatedType().getType().getTypeName().equals("int")) {
                try {
                    int value = field.getInt(c);
                    System.out.println(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(field);
        }
    }

    public static void constr(Class clazz) {
        for (Constructor constr : clazz.getDeclaredConstructors()) {
            for (Parameter param : constr.getParameters()) {
                System.out.println(param.getName());
            }
            System.out.println();
        }

        try {
            Car car = (Car)clazz.getDeclaredConstructors()[0].newInstance();
            System.out.println(car);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
