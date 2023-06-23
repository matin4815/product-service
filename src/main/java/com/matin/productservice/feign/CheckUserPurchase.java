package com.matin.productservice.feign;

import org.springframework.stereotype.Service;

@Service
public class CheckUserPurchase {

    public Boolean userPurchaseValidation(Long productId, String username) {
        return false;
    }
}
