package com.coco.custommetric

import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Service
import java.time.Instant
import io.micrometer.core.annotation.Timed
import io.micrometer.core.annotation.Counted

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


    @Counted("custom_orders_total")
    @Timed("custom_orders_total_seconds")
    fun incrementOrderCount(productId: String) {
        // do something
    }



}