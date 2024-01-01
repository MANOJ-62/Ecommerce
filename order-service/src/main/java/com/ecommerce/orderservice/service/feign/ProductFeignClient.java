package com.ecommerce.orderservice.service.feign;

//import com.ecommerce.productservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8081/api/products")
public interface ProductFeignClient {

//    @GetMapping("/{productId}")
//    Product getProductById(@PathVariable Long productId);
}
