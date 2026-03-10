package pk.sp.pasir_stoncel_patryk.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pk.sp.pasir_stoncel_patryk.dto.TransactionDTO;
import pk.sp.pasir_stoncel_patryk.model.Transaction;
import pk.sp.pasir_stoncel_patryk.model.TransactionType;
import pk.sp.pasir_stoncel_patryk.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Nie znaleziono transakcji o ID " + id));
    }

    public Transaction createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();

        transaction.setAmount(transactionDTO.getAmount());
        transaction.setType(TransactionType.valueOf(transactionDTO.getType()));
        transaction.setTags(transactionDTO.getTags());
        transaction.setNotes(transactionDTO.getNotes());
        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, TransactionDTO transactionDTO) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Nie znaleziono transakcji o ID " + id));

        transaction.setAmount(transactionDTO.getAmount());
        transaction.setType(TransactionType.valueOf(transactionDTO.getType()));
        transaction.setTags(transactionDTO.getTags());
        transaction.setNotes(transactionDTO.getNotes());

        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new EntityNotFoundException("Nie znaleziono transakcji o ID " + id);
        }

        transactionRepository.deleteById(id);
    }
}
