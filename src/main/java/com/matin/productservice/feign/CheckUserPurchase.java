package com.matin.productservice.feign;

import org.springframework.stereotype.Service;

@Service
public class CheckUserPurchase {

    // a hard coded api, that represents the call to a customer management
    public Boolean userPurchaseValidation(Long productId, String username) {
        return false;
    }
}
