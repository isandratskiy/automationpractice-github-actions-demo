package extensions;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import resolver.UserResolver;

import java.lang.annotation.*;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Execution(CONCURRENT)
@ExtendWith({SetupSelenideExtension.class, UserResolver.class})
public @interface BaseSetup {
}
