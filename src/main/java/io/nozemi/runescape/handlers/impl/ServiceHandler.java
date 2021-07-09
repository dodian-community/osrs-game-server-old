package io.nozemi.runescape.handlers.impl;

import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.service.Service;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceHandler implements Handler {

    private final List<Service> services;

    public ServiceHandler(List<Service> services) {
        this.services = services;
    }

    @Override
    public void initialize() {
        services.forEach(Service::setup);
        services.forEach(Service::start);
    }

    public <T extends Service> Optional<T> service(Class<? extends T> serviceType, boolean allowSubclass) {
        if (allowSubclass) {
            return (Optional<T>) services.stream().filter(s -> serviceType.isAssignableFrom(s.getClass())).findAny();
        }

        return (Optional<T>) services.stream().filter(s -> s.getClass() == serviceType).findAny();
    }
}
