package com.nelioalves.cursomc;

import com.nelioalves.cursomc.domain.*;
import com.nelioalves.cursomc.domain.enums.ClientType;
import com.nelioalves.cursomc.domain.enums.PaymentState;
import com.nelioalves.cursomc.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PaymentRepository paymentRepository;

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

		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlândia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);

		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));

		Client cli1 = new Client("Maria Silva","maria@gmail.com", "3278482332", ClientType.PESSOAFISICA);

		cli1.getTelephones().addAll(Arrays.asList("27894874", "98848373"));

		Address ad1 = new Address("Rua Flores", "300", "Apto 303", "Jardim", "38893438", cli1, c1);
		Address ad2 = new Address("Avenida Matos", "105", "Sala 800", "Centro", "12314534", cli1, c2);

		cli1.getAddressList().addAll(Arrays.asList(ad1, ad2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, ad1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, ad2);

		Payment pagto1 = new PaymentCartao(null, PaymentState.QUITADO, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new PaymentBoleto(null, PaymentState.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPayment(pagto2);

		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));
	}
}
