package Utils.Enums;

public enum ContentTypes {
    TYPE_JSON("application/json; charset=utf-8");

    private String type;
    ContentTypes(String t) {
        type = t;
    }
    public String get() {
        return type;
    }
}
