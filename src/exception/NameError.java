package exception;


public class NameError extends RuntimeException{
    // не придумал других exception, поэтому оставил это,
    // но добавил проверку на первый символ
    public NameError(String message){
        super(message);
    }

}

