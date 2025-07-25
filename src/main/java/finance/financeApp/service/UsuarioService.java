package finance.financeApp.service;

import finance.financeApp.model.*;
import finance.financeApp.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }

    public Optional<Usuario> findById(UUID id) {
        return repo.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return repo.save(usuario);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}