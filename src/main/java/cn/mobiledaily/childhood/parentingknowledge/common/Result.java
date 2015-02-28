package cn.mobiledaily.childhood.parentingknowledge.common;

/**
 * Created by Johnson on 2015/2/28.
 */
public class Result {
    private static final Integer SUCCESS = 1;
    private static final Integer FAIL = 0;
    private static final String SUCCESS_MESSAGE = "ok";
    private Integer ret;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer result, String message, Object data) {
        this.ret = result;
        this.msg = message;
        this.data = data;
    }

    public static Result failResult(Object data) {
        return new Result(FAIL, data.toString(), null);
    }

    public static Result successResult(Object data) {
        return new Result(SUCCESS, SUCCESS_MESSAGE, data);
    }

    public static Result successResultWithoutData() {
        return new Result(SUCCESS, SUCCESS_MESSAGE, null);
    }

    public Result(Object data) {
        this(SUCCESS, SUCCESS_MESSAGE, data);
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}