package day10.excep.demo2;

/**
 * @author wsl
 * @version 2020091114:10
 */
public class MyRuntimeException extends RuntimeException{
    public MyRuntimeException() {
    }

    public MyRuntimeException(String message) {
        super(message);
    }
}
