import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestWatcherExtension implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test succeeded: "+context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test failed: "+context.getDisplayName()+ " cause: "+cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, java.util.Optional<String> reason){
        System.out.println("Test disabled: "+context.getDisplayName()+ " reason: "+reason);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause){
        System.out.println("Test aborted: "+context.getDisplayName()+ " cause: "+cause.getMessage());
    }
}
