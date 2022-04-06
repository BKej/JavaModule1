import java.util.Objects;

public class Item implements Comparable<Item> {

    private int itemCode;
    private String itemName;
    private String itemDesc;
    private int itemPrice;

    public Item(int itemCode, String itemName, String itemDesc, int itemPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }


    @Override
    public int compareTo(Item o) {
        if(this.itemCode > o.itemCode) {
            return -1;
        }else if (this.itemCode < o.itemCode){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemCode == item.itemCode;
      //  return itemCode == item.itemCode && itemPrice == item.itemPrice && itemName.equals(item.itemName) && itemDesc.equals(item.itemDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCode);
       // return Objects.hash(itemCode, itemName, itemDesc, itemPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }

    //override equal and hashcode
}
