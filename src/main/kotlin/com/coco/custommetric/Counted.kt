package com.coco.custommetric

@Deprecated("Use library Count instead")
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Counted(val metricName: String)
