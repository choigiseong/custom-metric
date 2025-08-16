package com.coco.custommetric

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Deprecated("Use library instead")
@Aspect
@Component
class MetricsAspect(
    private val meterRegistry: MeterRegistry
) {

    @AfterReturning("@annotation(counted)")
    fun countOrder(joinPoint: JoinPoint, counted: Counted) {
        val args = joinPoint.args
        val productId = args.firstOrNull().toString()

        val orderCounter = meterRegistry.counter(
            counted.metricName,
            "productId", productId
        )
        orderCounter.increment()
    }

    @Around("@annotation(timed)")
    fun timed(joinPoint: ProceedingJoinPoint, timed: Timed): Any? {
        val timer = Timer.builder(timed.metricName)
            .description("${timed.metricName} timer")
            .register(meterRegistry)

        return timer.recordCallable {
            joinPoint.proceed()
        }
    }
}