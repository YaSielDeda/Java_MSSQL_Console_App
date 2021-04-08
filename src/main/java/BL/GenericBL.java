package BL;

import Entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface GenericBL <T>{
    void Add(T object);
    List<T> getAll();
    T getById(int id);
    void Update(T object);
    void Delete(T object);
}
