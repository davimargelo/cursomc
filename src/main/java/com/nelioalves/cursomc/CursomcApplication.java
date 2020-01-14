package com.nelioalves.cursomc;

import com.nelioalves.cursomc.domain.Category;
import com.nelioalves.cursomc.domain.Product;
import com.nelioalves.cursomc.respositories.CategoryRepository;
import com.nelioalves.cursomc.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "IT");
		Category cat2 = new Category(null, "Office");

		Product p1 = new Product(null, "PC", (double) 2000);
		Product p2 = new Product(null, "Printer", (double) 800);
		Product p3 = new Product(null, "Mouse", (double) 80);

		cat1.setProducts(Arrays.asList(p1, p2, p3));
		cat2.setProducts(Arrays.asList(p2));

		p1.setCategories(Arrays.asList(cat1));
		p2.setCategories(Arrays.asList(cat1, cat2));
		p3.setCategories(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
