package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Category;
import com.nelioalves.cursomc.respositories.CategoryRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repo;

    public Category findOne(Integer id) {
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("404 - Not Found ID: " + id, new Throwable("Type: " + Category.class.getName())));
    }

}
