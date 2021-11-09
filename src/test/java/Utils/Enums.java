package Utils;

public class Enums {
    public enum StatusCodes {
        ERROR(404), OK(200), CREATED(201);

        private int status_code;
        StatusCodes(int code) {
            status_code = code;
        }
        public int get() {
            return status_code;
        }
    }
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
    public enum Data {
        PROPS("data.properties"),
        JSONDATA("TestData.json");

        private String filename;
        Data(String f) {
            filename = f;
        }
        public String get() {
            return filename;
        }
    }
}
