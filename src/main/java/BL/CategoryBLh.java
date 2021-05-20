package BL;

import DAO.CategoryDAOh;
import DAO.GenericDAO;
import Entities.Category;
import Entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryBLh implements GenericBL <Category> {

    SessionFactory factory;
    GenericDAO<Category> categoryDAO;

    public CategoryBLh() {
        factory = new Configuration().configure().buildSessionFactory();
        categoryDAO = new CategoryDAOh(factory);
    }
    
    @Override
    public void Add(Category category) throws SQLException {
        categoryDAO.Add(category);
    }

    @Override
    public List<Category> getAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        for (Object c: categoryDAO.getAll())
            categories.add((Category) c);
        return categories;
    }

    @Override
    public Category getById(int id) throws SQLException {
        return categoryDAO.getById(id);
    }

    @Override
    public void Update(Category category) throws SQLException {
        Category updatableCategory = categoryDAO.getById(category.getID());
        updatableCategory.setName(category.Name);
        categoryDAO.Update(updatableCategory);
    }

    @Override
    public void Delete(Category category) throws SQLException {
        categoryDAO.Delete(categoryDAO.getById(category.getID()));
    }
}
