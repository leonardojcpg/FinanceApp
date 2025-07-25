package finance.financeApp.service;

import finance.financeApp.model.Categoria;
import finance.financeApp.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {
    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public List<Categoria> findAll() {
        return repo.findAll();
    }

    public Optional<Categoria> findById(UUID id) {
        return repo.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return repo.save(categoria);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}