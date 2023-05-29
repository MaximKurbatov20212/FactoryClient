package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.repo.ProductRepository;
import com.example.accessingdatamysql.dto.ProductDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService implements com.example.accessingdatamysql.service.Service<ProductDTO> {
    private final ProductRepository repo;
    private final ProductMapper mapper;

    public List<ProductDTO> getAll() {
        List<Product> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<ProductDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(ProductDTO dto) {
        try {
            Product e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ProductDTO dto) {
        Product e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(ProductDTO dto) {
        Product e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
