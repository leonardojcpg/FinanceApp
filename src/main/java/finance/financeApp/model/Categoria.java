package finance.financeApp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(length = 7)
    private String corHex;

    @Column(length = 100)
    private String icone;

    @Column(nullable = false, length = 10)
    private String tipo; // ENTRADA ou SAIDA
}
