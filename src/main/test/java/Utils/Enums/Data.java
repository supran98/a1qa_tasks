package Utils.Enums;

public enum Data {
    PROPS("config.properties"),
    JSONDATA("TestData.json");

    private String filename;
    Data(String f) {
        filename = f;
    }
    public String get() {
        return filename;
    }
}
