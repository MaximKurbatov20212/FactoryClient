package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    @NotNull
    private Integer id;

//    @NotNull
//    private ProductType type;
//
//    @NotNull
//    private ProductCategory category;
//
//    @NotNull
//    private Workshop workshop;

    @NotNull
    List<ProductionCycle> productionCycles = new ArrayList<>();

    @NotNull
    List<ProductAttributeValue> personalAttributeValues = new ArrayList<>();
}
