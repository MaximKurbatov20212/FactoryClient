package accessingdatamysql.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Workshop workshop;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProductionCycle> productionCycles = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProductAttributeValue> personalAttributeValues = new ArrayList<>();
}
