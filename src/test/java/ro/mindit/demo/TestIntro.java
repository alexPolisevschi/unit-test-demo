package ro.mindit.demo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Alex on 03.02.2016.
 */
public class TestIntro {

    @Test
    public void newTest() {
        assertThat("always true", 1==1, is(true));
    }
}
