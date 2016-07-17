import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lichenqiang on 16/7/17.
 */
public class PersonTest {

    @Test
    public void shouldGetHeight() throws Exception {
        // given
        Person bill = new Person();

        // when
        bill.setHeight(112);

        // then
        assertEquals(bill.getHeight(), 112);
    }

    @Test
    public void shouldNotGetHeight() throws Exception {
        // given
        Person bill = new Person();

        // when
        bill.setHeight(114);

        // then
        assertEquals(bill.getHeight(), 112);
    }
}