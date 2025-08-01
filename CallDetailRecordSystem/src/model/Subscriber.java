package model;

public class Subscriber {
    private String mobileNumber;
    private String name;

    public Subscriber(String mobileNumber, String name) {
        this.mobileNumber = mobileNumber;
        this.name = name;
    }

    public String getMobileNumber() { return mobileNumber; }
    public String getName() { return name; }
}
