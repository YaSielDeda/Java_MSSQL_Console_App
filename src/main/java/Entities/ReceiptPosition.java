package Entities;

public class ReceiptPosition {
    public int ID;
    public int ReceiptID;
    public int ProductQuantity;
    public int ProductID;

    public ReceiptPosition() { }

    public ReceiptPosition(int ID, int receiptID, int productQuantity, int productID) {
        this.ID = ID;
        ReceiptID = receiptID;
        ProductQuantity = productQuantity;
        ProductID = productID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(int receiptID) {
        ReceiptID = receiptID;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptPosition that = (ReceiptPosition) o;

        if (ID != that.ID) return false;
        if (ReceiptID != that.ReceiptID) return false;
        if (ProductQuantity != that.ProductQuantity) return false;
        return ProductID == that.ProductID;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + ReceiptID;
        result = 31 * result + ProductQuantity;
        result = 31 * result + ProductID;
        return result;
    }

    @Override
    public String toString() {
        return "ReceiptPosition{" +
                "ID=" + ID +
                ", ReceiptID=" + ReceiptID +
                ", ProductQuantity=" + ProductQuantity +
                ", ProductID=" + ProductID +
                '}';
    }
}
