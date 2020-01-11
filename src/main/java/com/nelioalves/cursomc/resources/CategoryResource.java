package com.nelioalves.cursomc.resources;

import com.nelioalves.cursomc.domain.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @GetMapping
    public List<Category> list() {

        Category cat1 = new Category(1, "TI");
        Category cat2 = new Category(2, "Office");

        List<Category> list = new ArrayList<>();

        list.add(cat1);
        list.add(cat2);

        return list;
    }
}