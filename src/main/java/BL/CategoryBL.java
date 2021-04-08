package BL;

import DAO.CategoryDAO;
import Entities.Category;
import Entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryBL extends CategoryDAO implements GenericBL <Category> {
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public void Add(Category category){
        try{
            categoryDAO.Add(category);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll(){
        List<Category> categoryList = new ArrayList<>();

        try{
            categoryList = categoryDAO.getAll();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return categoryList;
    }

    @Override
    public Category getById(int id){
        Category category = new Category();

        try{
            category = categoryDAO.getById(id);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return category;
    }

    @Override
    public void Update(Category category){
        try {
            categoryDAO.Update(category);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(Category category){
        try{
            categoryDAO.Delete(category);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
