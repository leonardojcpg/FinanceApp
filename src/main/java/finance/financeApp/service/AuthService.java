package finance.financeApp.service;

import finance.financeApp.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthService(AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    public String login(String email, String senha) {
        var auth = new UsernamePasswordAuthenticationToken(email, senha);
        authManager.authenticate(auth);
        return jwtUtil.generateToken(email);
    }
}
