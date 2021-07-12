package io.nozemi.runescape.net.packets.handlers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public abstract class PacketListener implements BeanFactoryAware {

    //protected EventsProvider eventsProvider;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //this.eventsProvider = beanFactory.getBean(EventsProvider.class);
    }
}
