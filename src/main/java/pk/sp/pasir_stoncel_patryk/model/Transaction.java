package pk.sp.pasir_stoncel_patryk.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions") // transaction - istnieje jako keyword w sql

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount; // Kwota transakcji

    @Enumerated(EnumType.STRING)
    private TransactionType type; // Typ transakcji (INCOME lub EXPENSE)

    private String tags; // Lista tagów lub pojedynczy tag (dla uproszczenia jako String)

    private String notes; // Dodatkowe notatki

    private LocalDateTime timestamp; // Data i czas utworzenia transakcji

    // ===== Getters & Setters
    public Transaction() {
    }

    // paramtert bez ID
    public Transaction(Double amount, TransactionType type, String tags, String notes, LocalDateTime timestamp) {
        this.amount = amount;
        this.type = type;
        this.tags = tags;
        this.notes = notes;
        this.timestamp = timestamp;
    }

    // ID getter
    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
