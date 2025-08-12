package com.shopping.order.request;

import java.util.List;

public record CartResponse(Integer cartId, Integer userId, Boolean executed, List<Integer> itemIds) {
}
