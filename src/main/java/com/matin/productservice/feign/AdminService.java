package com.matin.productservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "admin-panel")
public interface AdminService {

    @GetMapping("/api/adminControlSwitch")
    Boolean getAdminControlSwitch();

}
