

import ExceptionsHandling.InvalidDataException;
import ExceptionsHandling.ItemNotFoundException;
import ExceptionsHandling.ItemNotInCartException;
import ExceptionsHandling.ItemOutOfStockException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InventoryTest {

    ShoppingCart shopCart;

    @BeforeAll
    void loadTest() throws InvalidDataException {
        shopCart = new ShoppingCart();
    }


    @Test
    @Order(1)
     void addToCartTest() throws ItemOutOfStockException, ItemNotFoundException {

        shopCart.addToCart(new Item(1001,"Iphone 12","A great all round phone from Apple",900));
        shopCart.addToCart(new Item(1002,"Iphone 12","A great all round phone from Apple",600));
     //   assertEquals(1001, shopCart.cart.keySet().);
//        assertEquals("Iphone 12", cart.getCart().get(0).getItemName());
       // assertEquals(900, cart.getCart().get(0).getItemPrice());


    }
    @Test
    @Order(2)
    void addToCartTest2() throws ItemOutOfStockException, ItemNotFoundException {

        shopCart.addToCart(new Item(1002,"Iphone 12","A great all round phone from Apple",600),3);
       // cart.addToCart(new Item(1002,"Iphone 12","A great all round phone from Apple",600));
//             System.out.println(shopCart.cart);
//        assertEquals(1001, cart.getCart().get(0).getItemCode());
//        assertEquals("Iphone 12", cart.getCart().get(0).getItemName());
        // assertEquals(900, cart.getCart().get(0).getItemPrice());


    }

    @Test
    @Order(3)
    void removeFromCartTest()throws ItemNotInCartException {
        shopCart.removeFromCart(new Item(1001,"Iphone 12","A great all round phone from Apple",900) );
    }

    @Test
    @Order(4)
    void calculateTotalCostTest(){
        System.out.println("Total Cost:" + shopCart.calculateTotalCost());
    }

    @Test
    @Order(5)
    void getCartContentsTest(){
       shopCart.getCartContents();

    }

}




