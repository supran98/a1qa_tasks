package Utils.Enums;

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
