package ro.mindit.demo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Created by Alex on 03.02.2016.
 */
public class TestIntro {

    @Test
    public void newTest() {
        assertFalse(1==2);
        //assertNotNull("company id should not be null", null);
        assertThat(1 == 1, is(true));
    }


}
