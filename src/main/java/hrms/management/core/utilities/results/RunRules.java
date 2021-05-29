package hrms.management.core.utilities.results;

public class RunRules {
    public static Result  run(Result... things) {
        for(Result thing : things) {
            if(!thing.isSuccess()) {
                return thing;
            }
        }
        return new SuccessResult();
    }
}
