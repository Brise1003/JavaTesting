package com.platzi.javatest.FizzBuzz;

import org.junit.Test;

import static com.platzi.javatest.FizzBuzz.FizzBuzz.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

/*  Si el número es divisible por 3, retorna “Fizz”
    Si el número es divisible por 5, retorna “Buzz”
    Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
    En otro caso, retorna el mismo número
*/

public class FizzBuzzShould {

    @Test
    public void return_fizz_when_n_divisible_by_3(){
        assertThat(fizzBuzz(3), is("Fizz"));
        assertThat(fizzBuzz(6), is("Fizz"));
    }

    @Test
    public void return_buzz_when_n_is_divisible_by_5(){
        assertThat(fizzBuzz(5), is("Buzz"));
        assertThat(fizzBuzz(10), is("Buzz"));
    }

    @Test
    public void return_fizzbuzz_when_n_is_divisible_by_3_and_5(){
        assertThat(fizzBuzz(15), is("FizzBuzz"));
        assertThat(fizzBuzz(30), is("FizzBuzz"));
    }

    @Test
    public void return_same_number_when_isnt_divisible_by_3_nor_5(){
        assertThat(fizzBuzz(2), is("2"));
        assertThat(fizzBuzz(16), is("16"));

    }
}