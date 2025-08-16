package com.coco.custommetric

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(private val customMetricsService: CustomMetricsService) {
    @PostMapping("/order")
    fun createOrder(
        @RequestParam("product_id") productId: String
    ): String {
        // 주문 카운터 증가
        customMetricsService.incrementOrderCount(productId)
        return "Order created"
    }
}