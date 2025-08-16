package com.coco.custommetric

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Service

@Service
class CustomMetricsService(
    private val meterRegistry: MeterRegistry
) {

    fun incrementOrderCount(productId: String) {
        val orderCounter = meterRegistry.counter(
            "custom_orders_total",
            "productId", productId
        )
        orderCounter.increment()
    }

}