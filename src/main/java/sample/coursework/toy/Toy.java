package sample.coursework.toy;

public class Toy extends Manager {

    private Type toyType;
    private Size toySize;
    private int toyPrice;

    public Toy(Type toyType, Size toySize, int toyPrice) {
        this.toyType = toyType;
        this.toyPrice = toyPrice;
        this.toySize = toySize;
    }

    public Type getToyType() {
        return toyType;
    }

    public Size getToySize() {
        return toySize;
    }

    public int getToyPrice() {
        return toyPrice;
    }

    public String getInfo() {
        return (toySize + " " + toyType + " for " + toyPrice + " dollars ;");
    }
}
