package com.coco.custommetric

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class CustomMetricsService(
    private val meterRegistry: MeterRegistry
) {
    init {
        Gauge.builder("inventory") { Instant.now().toEpochMilli() }
            .tag("productId", "1")
            .description("Current stock of product")
            .register(meterRegistry)
    }

    fun incrementOrderCount(productId: String) {
        val orderCounter = meterRegistry.counter(
            "custom_orders_total",
            "productId", productId
        )
        orderCounter.increment()
    }



}