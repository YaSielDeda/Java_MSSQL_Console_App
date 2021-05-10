package service.serializations;

import Entities.Category;
import Entities.Product;
import Entities.Shop;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SerializationWorker {

    public SerializationWorker() {}

    public String SerializeProduct(Category product) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        om.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(product);
        return jsonResult;
    }

    public String SerializeShop(Category shop) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        om.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(shop);
        return jsonResult;
    }

    public String SerializeCategory(Category category) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        om.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(category);
        return jsonResult;
    }
}
