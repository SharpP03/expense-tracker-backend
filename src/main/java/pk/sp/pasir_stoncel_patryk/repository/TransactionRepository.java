package pk.sp.pasir_stoncel_patryk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.sp.pasir_stoncel_patryk.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
