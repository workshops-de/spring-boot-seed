package de.workshops;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.workshops.model.Purchase;
import de.workshops.repositories.PurchaseRepository;

@SpringBootApplication
public class SpringBootSeedApplication {

	private final PurchaseRepository purchaseRepository;

	@Autowired
	public SpringBootSeedApplication(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSeedApplication.class, args);
	}
	
	@PostConstruct
	public void insertPurchaseData() {
		LocalDate today = LocalDate.now();
		
		Purchase purchase1 = new Purchase();
		purchase1.setId(0);
		purchase1.setBuyer("First buyer");
		purchase1.setPurchaseDate(today);
		purchase1.setBookId(1);
		purchaseRepository.save(purchase1);
		
		Purchase purchase2 = new Purchase();
		purchase2.setId(1);
		purchase2.setBuyer("Second buyer");
		purchase2.setPurchaseDate(today.minusDays(1));
		purchase2.setBookId(1);
		purchaseRepository.save(purchase2);
	}
}
