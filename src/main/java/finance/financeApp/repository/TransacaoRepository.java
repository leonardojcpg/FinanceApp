package finance.financeApp.repository;

import finance.financeApp.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {}
