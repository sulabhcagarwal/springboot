package com.shopping.order.validators;

import com.shopping.order.request.OrderRequest;

public interface Validator {
    Boolean validate(OrderRequest request);
}
