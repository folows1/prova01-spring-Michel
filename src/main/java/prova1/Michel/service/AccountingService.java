package prova1.Michel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova1.Michel.dto.AccountingDTO;
import prova1.Michel.entity.AccountingEntity;
import prova1.Michel.repository.AccountingRepository;

@Service
public class AccountingService {
	
	private AccountingRepository repo;
	
	@Autowired
	public AccountingService(AccountingRepository repo) {
		this.repo = repo;
	}
	
	public AccountingEntity findById(Long itemCode) {
		Optional<AccountingEntity> obj = repo.findById(itemCode);
		
		AccountingEntity entity = obj.orElseThrow(() -> new RuntimeException("Not Found!"));
		
		return entity;
	}
	
	public void createAccounting(AccountingDTO acc) {
		repo.save(toEntity(acc));
	}
	
	public AccountingEntity toEntity(AccountingDTO acc) {
		return new AccountingEntity(acc.getItemCode(), acc.getType(), acc.getDescription(), acc.getAccValue(), acc.getProfit(), acc.getDateTime(), true);
	}
	
	public void active(Long itemCode) {
		Optional<AccountingEntity> obj = repo.findById(itemCode);
		if (obj.isPresent()) {
	        AccountingEntity entity = obj.get();
	        boolean status = entity.isActive();	        
	        entity.setActive(!status);
	        repo.save(entity);
	    } else {
	        throw new RuntimeException("Not Found!");
	    }
	}
}
