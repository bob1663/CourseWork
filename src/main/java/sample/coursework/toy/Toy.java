package sample.coursework.toy;

public class Toy extends Manager {

    private String toyType;
    private String toySize;
    private int toyPrice;

    public Toy(String toyType, String toySize, int toyPrice) {
        this.toyType = toyType;
        this.toyPrice = toyPrice;
        this.toySize = toySize;
    }


    public String getInfo() {
        return (toySize + " " + toyType + " for " + toyPrice + " dollars ;");
    }
}
