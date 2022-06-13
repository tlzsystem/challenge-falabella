package cl.samueltoloza.challenge;

import cl.samueltoloza.challenge.persistence.model.Product;
import cl.samueltoloza.challenge.persistence.service.impl.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ChallengeApplicationTests {

	@Autowired
	ProductService service;

	@Test
	void contextLoads() {
	}

	@Test()
	void test_givenInvalidProductSKU_whenSaveProduct_thenException(){

		Product product = new Product();
		product.setSku("FAL-1");
		product.setBrand("BrandTest");
		product.setName("NameTest");
		product.setPrice(15990.00);
		product.setSize("Test");
		product.setPrincipalImage("http://www.google.cl");
		assertThrows(TransactionSystemException.class, () -> service.create(product));

	}
	@Test()
	void test_givenInvalidProductImageURL_whenSaveProduct_thenException(){

		Product product = new Product();
		product.setSku("FAL-12345678");
		product.setBrand("BrandTest");
		product.setName("NameTest");
		product.setPrice(15990.00);
		product.setSize("Test");
		product.setPrincipalImage("url");
		assertThrows(TransactionSystemException.class, () -> service.create(product));
	}
	@Test()
	void test_givenInvalidProductName_whenSaveProduct_thenException(){

		Product product = new Product();
		product.setSku("FAL-12345678");
		product.setBrand("BrandTest");
		product.setName("N");
		product.setPrice(15990.00);
		product.setSize("Test");
		product.setPrincipalImage("https://falabella.com");
		assertThrows(TransactionSystemException.class, () -> service.create(product));
	}
	@Test()
	void test_givenInvalidProductPrice_whenSaveProduct_thenException(){

		Product product = new Product();
		product.setSku("FAL-12345678");
		product.setBrand("BrandTest");
		product.setName("Name");
		product.setPrice(0.0);
		product.setSize("Test");
		product.setPrincipalImage("https://falabella.com");
		assertThrows(TransactionSystemException.class, () -> service.create(product));
	}


	@Test()
	void test_givenValidProduct_whenSaveProduct_thenReturnNotNull(){

		Product product = new Product();
		product.setSku("FAL-77777777");
		product.setBrand("BrandTest");
		product.setName("NameTest");
		product.setPrice(15990.00);
		product.setSize("Test");
		product.setPrincipalImage("http://www.google.cl");
		Product productService =  service.create(product);
		assertNotNull(productService);
	}








}
