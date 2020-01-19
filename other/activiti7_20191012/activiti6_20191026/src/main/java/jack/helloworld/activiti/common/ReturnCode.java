package jack.helloworld.activiti.common;

public enum ReturnCode {

    SUCCESS(0, "成功"),
    FAILURE(1, "失败"),
    PARAM_ERROR(2, "参数错误"),
    DB_DATA_ERROR(3, "数据库数据错误");

    private Integer code;

    private String message;

    ReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
