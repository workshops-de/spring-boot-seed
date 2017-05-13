package de.workshops.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.workshops.model.Purchase;

public interface PurchaseRepository extends MongoRepository<Purchase, Long> {

	List<Purchase> findAllByBookId(Integer bookId);
}
