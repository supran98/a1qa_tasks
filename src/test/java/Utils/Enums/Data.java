package Utils.Enums;

public enum Data {
    JSONDATA("TestData.json"), PROPERTIES("config.properties");

    private String filename;
    Data(String f) {
        filename = f;
    }
    public String get() {
        return filename;
    }
}
