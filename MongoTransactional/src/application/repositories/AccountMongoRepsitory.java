package application.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import application.documents.Account;

public interface AccountMongoRepsitory extends MongoRepository<Account, Integer>{}