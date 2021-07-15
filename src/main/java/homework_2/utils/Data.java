package homework_2.utils;

public class Data {
    private Status status;
    private Type type;
    private String inValue;
    private String result;

    public Data() {
        this.status = Status.START;
    }

    public void setError(String msg) {
        setResult(msg);
        setStatus(Status.ERROR);
    }

    public String getInValue() {
        return inValue;
    }

    public void setInValue(String inValue) {
        this.inValue = inValue;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
