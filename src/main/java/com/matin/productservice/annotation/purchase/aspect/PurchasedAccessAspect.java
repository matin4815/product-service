package com.matin.productservice.annotation.purchase.aspect;

import com.matin.productservice.dto.comment.CommentDto;
import com.matin.productservice.dto.vote.VoteDto;
import com.matin.productservice.feign.AdminService;
import com.matin.productservice.feign.CheckUserPurchase;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Aspect
@Component
public class PurchasedAccessAspect {

    private final AdminService adminService;
    private final CheckUserPurchase checkUserPurchase;

    public PurchasedAccessAspect(AdminService adminService, CheckUserPurchase checkUserPurchase) {
        this.adminService = adminService;
        this.checkUserPurchase = checkUserPurchase;
    }

    private Boolean checkControlFlow() {
        return adminService.getAdminControlSwitch();
    }

    @Before("@annotation(com.matin.productservice.annotation.purchase.PurchasedAccess) && args(productId, commentDto)")
    public void validatePurchasedAccessForComment(JoinPoint joinPoint, Long productId, CommentDto commentDto) throws AccessDeniedException {
        validatePurchasedAccess(productId, commentDto.getUsername());
    }

    @Before("@annotation(com.matin.productservice.annotation.purchase.PurchasedAccess) && args(productId, voteDto)")
    public void validatePurchasedAccessForVote(JoinPoint joinPoint, Long productId, VoteDto voteDto) throws AccessDeniedException {
        validatePurchasedAccess(productId, voteDto.getUsername());
    }

    private void validatePurchasedAccess(Long productId, String username) throws AccessDeniedException {
        if (checkControlFlow()) {
            // Admin switch is on, allow access to the annotated method
            return;
        }

        if (!hasPurchasedProduct(productId, username)) {
            throw new AccessDeniedException("Access denied. Product purchase required.");
        }
    }


    private boolean hasPurchasedProduct(Long productId, String username) {
        return checkUserPurchase.userPurchaseValidation(productId, username);
    }
}
