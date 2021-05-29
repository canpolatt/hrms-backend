package hrms.management.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{
    public ErrorDataResult(T data, String message) {
        super(data,false, message);
    }
    public ErrorDataResult(T data){
        super(data,false); //front-end kısmında sıkıntı çıkmaması için boş bir şablon
    }
    public ErrorDataResult(String message) {
        super(null,false, message);
    }
    public ErrorDataResult() {
        super(null,false);
    }
}