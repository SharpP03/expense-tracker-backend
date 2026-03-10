package pk.sp.pasir_stoncel_patryk.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transactions") // transaction - istnieje jako keyword w sql

@SuppressWarnings("JpaDataSource0RMInspection")
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
}
