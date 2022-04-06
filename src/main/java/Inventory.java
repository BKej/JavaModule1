import ExceptionsHandling.InvalidDataException;
import ExceptionsHandling.ItemNotFoundException;
import ExceptionsHandling.ItemOutOfStockException;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Item, Integer> stock;

    Inventory() throws InvalidDataException {
        stock = new HashMap<>();
        load();
    }

    //Loading data from xlsx file
    private void load() throws InvalidDataException {

        ExcelReader myReader = new ExcelReader("Stock.xlsx");

        int rowCount = myReader.getRowCount();

        //Iterating rows and loading the Stock Map
        //put try catch block
        for (int i = 1; i < rowCount; i++) {
            stock.put(
                    new Item(
                            new Integer(myReader.getCellValue(i, 0)),
                            myReader.getCellValue(i, 1),
                            myReader.getCellValue(i, 2),
                            new Integer(myReader.getCellValue(i, 3))),
                    new Integer(myReader.getCellValue(i, 4)));

        }
    }

    boolean reduceStock(Item it, Integer quantity) throws ItemNotFoundException, ItemOutOfStockException {
        if (validateItem(it)) {
            int reducedQuan = getItemStock(it) - quantity;
            if (!(reducedQuan <= 0)) {
                stock.put(it, getItemStock(it) - quantity);
                System.out.println("No of items in stock are " + stock.get(it));
                return true;
            } else if (reducedQuan == 0) {
                stock.put(it, getItemStock(it) - quantity);
                System.out.println("Restock the item, quantity is " + stock.get(it));
                return true;
            } else {
                throw new ItemOutOfStockException("That many quantities "+ quantity + " of items are not in stock");
            }
        }
        return false;
    }

    int getItemStock(Item it) throws ItemNotFoundException {
        if(stock.containsKey(it)) {
             return stock.get(it) ;
        } else {
           throw new ItemNotFoundException("Cannot Find Item: " + it);
        }
    }

    boolean validateItem(Item it) throws ItemNotFoundException {

        if(stock.containsKey(it)){
            return true;
        }else{
            throw new ItemNotFoundException("Cannot find this item in stock: " + it);
        }
    }

    Map< Integer, String> getItemCatalogue() {

        Map<Integer, String> catalogue = new HashMap<>();

            for (Map.Entry<Item, Integer> myMap : stock.entrySet()) {
                catalogue.put(myMap.getKey().getItemCode(), myMap.getKey().getItemName());
            }
            return catalogue;
    }
}




