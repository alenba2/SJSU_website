import com.example.sjsuwebsite.model.History;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {
    @Test
    public void testSetHistory(){
        Date date = new Date();

        History test = new History("John Doe",15.00,5,date);

        assertEquals(test.getTotal(),15.00,"Should be 15");

    }
}
