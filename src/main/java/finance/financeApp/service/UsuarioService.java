package finance.financeApp.service;

import finance.financeApp.model.Usuario;
import finance.financeApp.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService
{
    private final UsuarioRepository repo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo)
    {
        this.repo = repo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> findAll()
    {
        return repo.findAll();
    }

    public Optional<Usuario> findById(UUID id)
    {
        return repo.findById(id);
    }

    public Usuario save(Usuario usuario) {
        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repo.save(usuario);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
