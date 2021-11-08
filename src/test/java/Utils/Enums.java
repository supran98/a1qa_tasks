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
}
