package com.matin.productservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "admin-service")
public interface AdminService {

    @GetMapping("/api/adminControlSwitch")
    Boolean getAdminControlSwitch();

}
