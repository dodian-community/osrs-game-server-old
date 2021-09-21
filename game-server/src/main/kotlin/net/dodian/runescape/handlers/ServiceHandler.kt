package net.dodian.runescape.handlers

import net.dodian.runescape.services.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ServiceHandler @Autowired constructor(
    private val services: List<Service>
) : Handler {

    override fun initialize() {
        services.forEach { it.setup() }
        services.forEach { it.start() }
    }

    fun <T : Service> service(serviceType: Class<out T>, allowSubclass: Boolean): T? {
        return services.first { service ->
            if(allowSubclass) {
                serviceType.isAssignableFrom(service.javaClass)
            } else {
                service.javaClass == serviceType
            }
        } as T?
    }
}