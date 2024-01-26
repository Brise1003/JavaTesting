package com.platzi.javatest.util;


import org.junit.Assert;
import org.junit.Test;
/*import sun.font.TrueTypeFont;*/

public class StringUtilTest {

    @Test
    public void test_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));

    }

    @Test
    public void test_string_multiple_times() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void test_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_string_negative_times() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", -1));
    }

    @Test
    public void test_string_with_comillas(){
        Assert.assertEquals(true, StringUtil.isEmpty(""));
    }

    @Test
    public void test_string_with_null(){
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void test_string_with_spaces(){
        Assert.assertTrue(StringUtil.isEmpty("   "));
    }
}