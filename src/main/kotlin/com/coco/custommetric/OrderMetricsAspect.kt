package com.coco.custommetric

import io.micrometer.core.instrument.MeterRegistry
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class OrderMetricsAspect(
    private val meterRegistry: MeterRegistry
) {

    @AfterReturning("@annotation(countOrder)")
    fun countOrder(joinPoint: JoinPoint, countOrder: CountOrder) {
        val args = joinPoint.args
        val productId = args.firstOrNull().toString()

        val orderCounter = meterRegistry.counter(
            "custom_orders_total",
            "productId", productId
        )
        orderCounter.increment()
    }
}