package com.coco.custommetric

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Service

@Service
class CustomMetricsService(
    private val meterRegistry: MeterRegistry
) {
    private val orderCounter: Counter = Counter.builder("custom_orders_total")
        .description("Total number of orders")
        .register(meterRegistry)

    fun incrementOrderCount() {
        orderCounter.increment()
    }

}