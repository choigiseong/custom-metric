package com.coco.custommetric

@Deprecated("Use library Timed instead")
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Timed(val metricName: String)
