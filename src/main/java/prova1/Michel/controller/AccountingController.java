package prova1.Michel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import prova1.Michel.dto.AccountingDTO;
import prova1.Michel.entity.AccountingEntity;
import prova1.Michel.service.AccountingService;

@RestController
@RequestMapping("/accountings")
public class AccountingController {
	
	@Autowired
	private AccountingService service;
	
	@GetMapping("/{itemCode}")
	public ResponseEntity<AccountingDTO> getProductById(@PathVariable Long itemCode) {
	    AccountingEntity accounting = service.findById(itemCode);
	    
	    if (accounting == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    AccountingDTO dto = new AccountingDTO(accounting);
	    return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAccounting(@RequestBody @Valid AccountingDTO acc) {
		service.createAccounting(acc);
	}
	
	@PatchMapping("/active/{itemCode}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void activeAccounting(@PathVariable Long itemCode) {
	    AccountingEntity entity = service.active(itemCode);
	    
	    if (entity == null) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accounting not found!");
	    }
	}
}
