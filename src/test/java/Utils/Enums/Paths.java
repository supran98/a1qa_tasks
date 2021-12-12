package Utils.Enums;

public enum Paths {
    RESOURCES("src/test/resources/");

    private String path;
    Paths(String p) {
        path = p;
    }
    public String get() {
        return path;
    }
}
