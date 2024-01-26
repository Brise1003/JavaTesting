package com.platzi.javatest.util;

import org.junit.Test;

import static com.platzi.javatest.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_lees_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assesPassword("123aa!"));
    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(WEAK, PasswordUtil.assesPassword("abcdefghjkf"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(MEDIUM, PasswordUtil.assesPassword("abcd12345"));
    }

    @Test
    public void medium_when_has_letters_and_numbers_and_symbols(){
        assertEquals(STRONG, PasswordUtil.assesPassword("abcd1234!"));
    }
}