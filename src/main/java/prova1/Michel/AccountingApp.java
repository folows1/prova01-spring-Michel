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
		AccountingEntity e1 = new AccountingEntity(1, "Venda", "Venda de produtos de limpeza", 800.0f, 200.0f, "2023-04-14 08:00:00", true);
		AccountingEntity e2 = new AccountingEntity(2, "Compra", "Compra de material de escritório", -500.0f, -100.0f, "2023-04-13 14:30:00", false);
		AccountingEntity e3 = new AccountingEntity(3, "Pagamento", "Pagamento de contas de energia elétrica", -150.0f, -50.0f, "2023-04-12 18:00:00", true);
		AccountingEntity e4 = new AccountingEntity(4, "Recebimento", "Recebimento de pagamento de cliente", 1000.0f, 200.0f, "2023-04-11 10:15:00", false);
		AccountingEntity e5 = new AccountingEntity(5, "Venda", "Venda de produtos eletrônicos", 1500.0f, 300.0f, "2023-04-10 15:00:00", true);
		AccountingEntity e6 = new AccountingEntity(6, "Compra", "Compra de material de construção", -2000.0f, -500.0f, "2023-04-09 12:00:00", false);
		AccountingEntity e7 = new AccountingEntity(7, "Pagamento", "Pagamento de salários", -3000.0f, -1000.0f, "2023-04-08 08:00:00", true);
		AccountingEntity e8 = new AccountingEntity(8, "Recebimento", "Recebimento de pagamento de cliente", 1200.0f, 300.0f, "2023-04-07 17:30:00", false);
		AccountingEntity e9 = new AccountingEntity(9, "Venda", "Venda de alimentos", 500.0f, 100.0f, "2023-04-06 14:45:00", true);
		AccountingEntity e10 = new AccountingEntity(10, "Compra", "Compra de produtos para revenda", -1000.0f, -200.0f, "2023-04-05 09:00:00", false);
		AccountingEntity e11 = new AccountingEntity(11, "Pagamento", "Pagamento de fornecedores", -700.0f, -200.0f, "2023-04-04 12:30:00", true);
		AccountingEntity e12 = new AccountingEntity(12, "Recebimento", "Recebimento de aluguel", 800.0f, 150.0f, "2023-04-03 11:00:00", false);
		AccountingEntity e13 = new AccountingEntity(13, "Venda", "Venda de roupas", 1200.0f, 250.0f, "2023-04-02 16:15:00", true);
		
		repo.save(e1);
		repo.save(e2);
		repo.save(e3);
		repo.save(e4);
		repo.save(e5);
		repo.save(e6);
		repo.save(e7);
		repo.save(e8);
		repo.save(e9);
		repo.save(e10);
		repo.save(e11);
		repo.save(e12);
		repo.save(e13);
	}
}
