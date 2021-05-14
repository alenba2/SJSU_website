import com.example.sjsuwebsite.Bundle;
import com.example.sjsuwebsite.Item;
import com.example.sjsuwebsite.ItemSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the calculations in the Item, Bundle and ItemSystem classes
 */
public class ItemTest {
    /**
     * Tests if the calculations are correct when you bundle three items together with the discound of 10%
     */
    @Test
    public void testBundleTotal(){
        Item apple = new Item("",4,"",5);

        Bundle bundle = new Bundle();

        bundle.addItem(apple);
        bundle.addItem(apple);
        bundle.addItem(apple);

        double dummyTotal = (5 + 5 + 5);
        double priceCut = dummyTotal * .1;

        dummyTotal -= priceCut;

        assertEquals(bundle.getCost(),dummyTotal,"Price should be " + dummyTotal);
    }

    /**
     * Tests the total cost is correct if there is a three item bundle and one singular Item
     */
    @Test
    public void testItemSystemTotal(){
        Item apple = new Item("",1,"",5);

        Bundle bundle = new Bundle();

        bundle.addItem(apple);
        bundle.addItem(apple);
        bundle.addItem(apple);

        bundle.setQuantity(1);

        ItemSystem system = new ItemSystem();

        system.add(bundle);
        system.add(apple);

        double dummyTotal = (5 + 5 + 5);
        double priceCut = dummyTotal * .1;

        dummyTotal -= priceCut;
        dummyTotal += 5;

        System.out.println(system.getCost());

        assertEquals(system.getCost(),dummyTotal,"Expected: " + dummyTotal);
    }
}
