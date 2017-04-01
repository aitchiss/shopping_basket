package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ItemTest {

    Item bread;
    Item bread2;

    @Before
    public void before(){
        bread = new Item(1234);
        bread2 = new Item(1234);
    }

    @Test
    public void itemHasId(){
        assertNotNull(bread.getProductId());
    }

    @Test
    public void similarItemsHaveSameId(){
        assertEquals(bread.getProductId(), bread2.getProductId());
    }


}