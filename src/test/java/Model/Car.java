package Model;

public class Car {
    private final int id;
    private String make;
    private String model;
    private String year;
    private String trim;
    private String engine_info;
    private String tm_info;

    public Car(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngineInfo() {
        return engine_info;
    }

    public void setEngineInfo(String engine_info) {
        this.engine_info = engine_info;
    }

    public String getTmInfo() {
        return tm_info;
    }

    public void setTmInfo(String tm_info) {
        this.tm_info = tm_info;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }
}
