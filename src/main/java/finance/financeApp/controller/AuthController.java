package finance.financeApp.controller;

import finance.financeApp.dto.AuthRequest;
import finance.financeApp.dto.AuthResponse;
import finance.financeApp.model.Usuario;
import finance.financeApp.service.AuthService;
import finance.financeApp.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsuarioService usuarioService ;
    private final AuthService authService;

    public AuthController(UsuarioService usuarioService, AuthService authService) {
        this.usuarioService = usuarioService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        Usuario novoUsuario = null;

        novoUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        String token = null;

        token = authService.login(request.getEmail(), request.getSenha());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
