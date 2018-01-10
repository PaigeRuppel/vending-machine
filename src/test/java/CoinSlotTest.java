import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinSlotTest {

    private CoinSlot underTest;

    @Test
    public void shouldReturnValue5WhenNickelIsAccepted() {
        underTest = new CoinSlot();
        assertThat(underTest.acceptPayment("nickel"), is(5));
    }
}
