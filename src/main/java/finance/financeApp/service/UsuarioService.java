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

    public Usuario save(Usuario usuario)
    {
        String senhaCriptografada = null;

        // Criptografa a senha antes de salvar
        senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return repo.save(usuario);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
