package io.nozemi.runescape.content;

import io.nozemi.runescape.handlers.impl.Button;
import io.nozemi.runescape.handlers.impl.ButtonHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public abstract class ButtonRegisterer implements InitializingBean {

    private static final Logger logger = LogManager.getLogger(ButtonRegisterer.class);

    protected final ButtonHandler buttonHandler;

    @Autowired
    public ButtonRegisterer(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
    }

    @Override
    public void afterPropertiesSet() {
        Arrays.stream(this.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(Button.class))
                .forEach(method -> {
                    buttonHandler.registerButton(method);
                    logger.info("Registered button {}", method.getName());
                });
    }
}
