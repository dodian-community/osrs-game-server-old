package io.nozemi.runescape.handlers.impl;

import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ButtonHandler implements Handler, BeanFactoryAware {

    private static final Logger logger = LogManager.getLogger(ButtonHandler.class);

    private Map<Button, Method> buttonHandlers = new HashMap<>();

    private BeanFactory beanFactory;

    @Override
    public void initialize() {

    }

    public void registerButton(Method method) {
        if(!method.isAnnotationPresent(Button.class)) {
            logger.error("Failed to register button method, because there was no Button annotation...");
            return;
        }

        Button buttonInfo = method.getAnnotation(Button.class);
        this.buttonHandlers.put(buttonInfo, method);
    }

    public void handleButton(Player player, int parentId, int childId, int option, int item) {
        Set<Map.Entry<Button, Method>> handlers = buttonHandlers.entrySet();
        List<Map.Entry<Button, Method>> handlerList = handlers.stream()
                .filter(handler -> handler.getKey().parentId() == parentId && handler.getKey().childId() == childId)
                .collect(Collectors.toList());


        if(handlerList.size() <= 0) {
            logger.info("ParentID: {} | ChildID: {} | Option: {} | Item: {}", parentId, childId, option, item);
        } else {
            handlerList.forEach(handler -> {
                try {
                    Object instance = beanFactory.getBean(handler.getValue().getDeclaringClass());
                    handler.getValue().invoke(instance, player, option, item);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("Failed to handle button (parentId: {}, childId: {}, option: {}, item: {})",
                            parentId, childId, option, item, e);
                }
            });
        }
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
