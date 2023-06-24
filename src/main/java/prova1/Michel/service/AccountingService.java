package prova1.Michel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova1.Michel.dto.AccountingDTO;
import prova1.Michel.entity.AccountingEntity;
import prova1.Michel.repository.AccountingRepository;
import prova1.Michel.utils.ObjectNotFoundException;

@Service
public class AccountingService {
	
	private AccountingRepository repo;
	
	@Autowired
	public AccountingService(AccountingRepository repo) {
		this.repo = repo;
	}
	
	public AccountingEntity findById(Long itemCode) {
	    Optional<AccountingEntity> obj = repo.findById(itemCode);
	    
	    return obj.orElse(null);
	}
	
	public void createAccounting(AccountingDTO acc) {
		repo.save(toEntity(acc));
	}
	
	public AccountingEntity toEntity(AccountingDTO acc) {
		return new AccountingEntity(acc.getItemCode(), acc.getType(), acc.getDescription(), acc.getAccValue(), acc.getProfit(), acc.getDateTime(), true);
	}
	
	public AccountingEntity active(Long itemCode) {
	    Optional<AccountingEntity> obj = repo.findById(itemCode);
	    
	    if (obj.isPresent()) {
	        AccountingEntity entity = obj.get();
	        boolean status = entity.isActive();
	        entity.setActive(!status);
	        repo.save(entity);
	        return entity;
	    } else {
	        return null;
	    }
	}
}
