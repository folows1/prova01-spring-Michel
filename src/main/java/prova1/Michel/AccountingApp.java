package prova1.Michel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import prova1.Michel.entity.AccountingEntity;
import prova1.Michel.repository.AccountingRepository;

@SpringBootApplication
public class AccountingApp implements CommandLineRunner {

	@Autowired
	private AccountingRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(AccountingApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AccountingEntity p1 = new AccountingEntity(1, "Familia 1", "Familia 11", 100f, 200f, "02/23", true);
		repo.save(p1);
		AccountingEntity p2 = new AccountingEntity(2, "Familia 3", "Familia 33", 100f, 200f, "02/23", false);
		repo.save(p2);
	}
}
