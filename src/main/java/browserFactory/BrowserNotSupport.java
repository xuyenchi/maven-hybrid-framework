package browserFactory;

public class BrowserNotSupport extends IllegalStateException {
    public BrowserNotSupport(String browserName){
        super(String.format("Browser not supported: %s", browserName));
    }
}
