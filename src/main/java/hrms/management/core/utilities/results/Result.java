package hrms.management.core.utilities.results;

public class Result { // super type # soyut olarak dusunebiliriz
    private boolean success;
    private String message;

    public Result(boolean success){
        this.success=success;
    }
    public Result(boolean success, String message){
        this(success);
        this.message=message;
    }
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
