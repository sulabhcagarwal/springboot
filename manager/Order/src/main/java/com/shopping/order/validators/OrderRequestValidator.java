package com.shopping.order.validators;

import com.shopping.order.cache.ItemCache;
import com.shopping.order.request.OrderRequest;
import org.springframework.stereotype.Controller;

@Controller
public class OrderRequestValidator implements Validator{

    private final ItemCache itemCache;

    public OrderRequestValidator(ItemCache itemCache) {
        this.itemCache = itemCache;
    }

    public Boolean validate(OrderRequest request){
        return request.itemIds().stream().allMatch( req -> itemCache.itemAvailable(req));
    }
}
