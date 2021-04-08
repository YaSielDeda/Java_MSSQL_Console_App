package Entities;

public class Product {
    public int ID;
    public String Name;
    public int CategoryID;
    public double Cost;
    public int InStock;

    public Product(){ }

    public Product(int ID, String name, int categoryID, double cost, int inStock) {
        this.ID = ID;
        Name = name;
        CategoryID = categoryID;
        Cost = cost;
        InStock = inStock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public int getInStock() {
        return InStock;
    }

    public void setInStock(int inStock) {
        InStock = inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (ID != product.ID) return false;
        if (CategoryID != product.CategoryID) return false;
        if (Double.compare(product.Cost, Cost) != 0) return false;
        if (InStock != product.InStock) return false;
        return Name != null ? Name.equals(product.Name) : product.Name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + CategoryID;
        temp = Double.doubleToLongBits(Cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + InStock;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", CategoryID=" + CategoryID +
                ", Cost=" + Cost +
                ", InStock=" + InStock +
                '}';
    }
}
