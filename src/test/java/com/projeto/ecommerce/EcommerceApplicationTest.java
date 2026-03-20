package com.projeto.ecommerce;

import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.ProductRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplicationTest.class, args);
	}

	//testar os negocioa mas isso eu faço amanhã se a fiama deixar
//	@Bean
//	public CommandLineRunner initDatabase(UserRepository userRepo, ProductRepository prodRepo) {
//		return args -> {
//			//verifica se o banco ta vazio pra n duplicar
//			if (userRepo.count() == 0) {
//
//				System.out.println("teste");
//
//				//usuário teste
//				UserEntity user = new UserEntity();
//				user.setName("estelionathalia");
//				user.setEmail("nath@teste.com");
//				user = userRepo.save(user);
//
//				System.out.println("criou aq o cliente");
//				System.out.println("copia o id do cliente ae  " + user.getId());
//
//				//produto teste
//				ProductEntity product = new ProductEntity();
//				product.setName("Teclado Mecânico RGB");
//				product.setPrice(350.0);
//				product = prodRepo.save(product);
//
//				System.out.println("criou aq o produto");
//				System.out.println("copia o id do produto ai " + product.getId());
//
//			}
//		};
//	}
}


