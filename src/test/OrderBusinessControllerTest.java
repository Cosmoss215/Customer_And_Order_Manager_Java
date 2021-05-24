package test;

import exception.OrderBusinessControllerException;
import model.OrderBusinessController;
import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderBusinessControllerTest {
    ArrayList<OrderBusinessController> allOrderBusinessController;

    @BeforeEach
    public void setUp() {
        allOrderBusinessController = new ArrayList<>();
        allOrderBusinessController.add(new OrderBusinessController(5.0,20,0.05,true,95.0));//Good
        allOrderBusinessController.add(new OrderBusinessController(5.0,-20,-1.0,false,-55.00));//Not good
    }
    @Test
    public void price() throws OrderBusinessControllerException {
        assertEquals(95,allOrderBusinessController.get(0).price(), 0.1);
    }
    @Test
    public void hasDiscount() {
        assertTrue(allOrderBusinessController.get(0).hasDiscount());
    }
    @Test
    public void getPourcatageAmount() throws OrderBusinessControllerException {
        assertEquals(5,allOrderBusinessController.get(0).getPourcatageAmount(),0.1);
    }
    @Test
    public void hasExceptionThrownFromGetPourcatageAmount(){
        assertThrows(OrderBusinessControllerException.class,()->allOrderBusinessController.get(1).getPourcatageAmount());
    }

}