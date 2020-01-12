package com.nelioalves.cursomc.resources;

import com.nelioalves.cursomc.domain.Category;
import com.nelioalves.cursomc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> list() {

        Category cat1 = new Category(1, "TI");
        Category cat2 = new Category(2, "Office");

        List<Category> list = new ArrayList<>();

        list.add(cat1);
        list.add(cat2);

        return list;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Integer id) {
        Optional<Category> cat = categoryService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(cat.orElse(null));
    }

System.out.println("banana azul");
}

