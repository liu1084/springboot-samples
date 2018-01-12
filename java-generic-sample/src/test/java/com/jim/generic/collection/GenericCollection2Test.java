package com.jim.generic.collection;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

@Test
@Slf4j
public class GenericCollection2Test {
    @Test
    public void testSortArray() {
        Integer[] arr1 = {1, 2, 3, 10, 8, 4, 7};
        Integer []  result = GenericCollections2.sortArray(arr1);
        log.info(Arrays.toString(result));
        Assert.assertEquals(arr1.length, result.length);
        Assert.assertEquals(result[result.length -1], new Integer(10));
    }
}
