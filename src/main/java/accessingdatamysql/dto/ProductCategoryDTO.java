package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    List<Product> products = new ArrayList<>();
    @NotNull
    List<ProductCategoryAttribute> productCategoryAttributes = new ArrayList<>();
}
