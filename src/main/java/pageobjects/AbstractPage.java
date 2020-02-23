package pageobjects;

import com.google.common.flogger.FluentLogger;
import lombok.SneakyThrows;

import static com.google.common.flogger.FluentLogger.forEnclosingClass;

public abstract class AbstractPage {
    protected static final FluentLogger logger = forEnclosingClass();

    @SneakyThrows
    public <T extends AbstractPage> T atPage(Class<T> pageClass) {
        return pageClass.newInstance();
    }
}
