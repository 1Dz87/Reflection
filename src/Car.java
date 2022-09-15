public class Car {

    private String name;

    public int value;

    public static Car makeCar(String name, int value) {
        return new Car(name, value);
    }

    private Car (String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    private void smth() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String name, int value) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
