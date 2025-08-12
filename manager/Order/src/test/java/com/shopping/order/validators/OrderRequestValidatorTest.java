package com.shopping.order.validators;

import com.shopping.order.cache.ItemCache;
import com.shopping.order.request.OrderRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderRequestValidatorTest {

    @Test
    @DisplayName("Validate will return false when item is not available")
    public void validateFalse(){
        ItemCache itemCache = Mockito.mock(ItemCache.class);
        Mockito.when(itemCache.itemAvailable(Mockito.eq(1))).thenReturn(false);
        var validator = new OrderRequestValidator(itemCache);
        var request = new OrderRequest(1,1, Arrays.asList(1));
        var response = validator.validate(request);
        Assertions.assertEquals(false, response, "item 1 should be not be valid");
    }

}