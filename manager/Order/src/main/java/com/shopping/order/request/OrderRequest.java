package com.shopping.order.request;

import java.util.List;

public record OrderRequest(Integer userId, List<Integer> itemIds) {
}
