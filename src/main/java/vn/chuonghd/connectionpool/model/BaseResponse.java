package vn.chuonghd.connectionpool.model;

/**
 * Created by huynhduychuong on 4/1/2016.
 */
public class BaseResponse<T> {
    private String status = "1";
    private String messageCode = "0";
    private String messageInfo = "Transaction Successful";

    private T body;

    public BaseResponse() {

    }
    public BaseResponse(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }
}
