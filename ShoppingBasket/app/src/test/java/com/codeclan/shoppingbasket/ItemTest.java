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
        bread = new Bread();
        bread2 = new Bread();
    }

    @Test
    public void itemHasId(){
        assertNotNull(bread.getId());
    }

    @Test
    public void similarItemsHaveSameId(){
        assertEquals(bread.getId(), bread2.getId());
    }


}