package finance.financeApp.service;

import finance.financeApp.model.Transacao;
import finance.financeApp.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransacaoService {
    private final TransacaoRepository repo;

    public TransacaoService(TransacaoRepository repo) {
        this.repo = repo;
    }

    public List<Transacao> findAll() {
        return repo.findAll();
    }

    public Optional<Transacao> findById(UUID id) {
        return repo.findById(id);
    }

    public Transacao save(Transacao transacao) {
        return repo.save(transacao);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}