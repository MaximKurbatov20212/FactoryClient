package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.Site;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class ProductionCycleDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Product product;
    @NotNull
    private Site site;
    @NotNull

    private Brigade brigade;
}
