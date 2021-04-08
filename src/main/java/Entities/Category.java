package Entities;

public class Category {
    public int ID;
    public String Name;

    public Category(){ }

    public Category(int ID, String name) {
        this.ID = ID;
        Name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (ID != category.ID) return false;
        return Name != null ? Name.equals(category.Name) : category.Name == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
