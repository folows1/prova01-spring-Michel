package prova1.Michel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prova1.Michel.entity.AccountingEntity;

@Repository
public interface AccountingRepository extends JpaRepository<AccountingEntity, Integer> {
}