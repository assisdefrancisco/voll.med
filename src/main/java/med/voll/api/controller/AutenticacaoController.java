package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.ComandoDadosAutenticacao;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.infra.security.DadosTokenJwt;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid ComandoDadosAutenticacao comando) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(comando.login(), comando.senha());
        var autentication = manager.authenticate(authenticationToken);

        var usuario = (Usuario)autentication.getPrincipal();
        var tokenJwt = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));
    }
}
