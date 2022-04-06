import ExceptionsHandling.InvalidDataException;
import ExceptionsHandling.ItemNotFoundException;
import ExceptionsHandling.ItemNotInCartException;
import ExceptionsHandling.ItemOutOfStockException;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Inventory in;
    Map<Item, Integer> cart = new HashMap<>();

    ShoppingCart() throws InvalidDataException {
         in = new Inventory();
    }

    boolean addToCart(Item it) throws ItemNotFoundException, ItemOutOfStockException {
        if(in.validateItem(it)){
            if(in.getItemStock(it) > 0) {
                cart.put(it,1);
                return true;
            }else{
                throw new ItemOutOfStockException("Item is not in stock: " + it);
            }
        }else{
            return false;
        }
    }

    //method overloading
    boolean addToCart(Item it, int quantity) throws ItemNotFoundException, ItemOutOfStockException {
        if (in.validateItem(it) ){
            if(in.getItemStock(it) >= quantity) {
                    cart.put(it, quantity);
                    return true;
            }else {
                throw new ItemOutOfStockException("Item is not in stock: " + it);
            }
        }else {
            return false;
        }
    }

    boolean removeFromCart(Item it) throws ItemNotInCartException {
        if(cart.containsKey(it)){
                cart.remove(it,1);
                return true;
        }
        throw new ItemNotInCartException("Cannot find the selected item in the cart: " + it);
    }

    long calculateTotalCost(){
        long totalCost = 0;
        if(!(cart.isEmpty())) {
            for (Map.Entry<Item, Integer> myMap : cart.entrySet()) {
               totalCost += (myMap.getKey().getItemPrice() * myMap.getValue());
            }
        }
            return totalCost;
    }

    Item[] getCartContents(){
        Item[] item = cart.keySet().toArray(new Item[0]);
//        for (Item n : item) {
//            System.out.println(n);
//        }
            return item;
    }

//    void checkout(){
//
//    }

    }
