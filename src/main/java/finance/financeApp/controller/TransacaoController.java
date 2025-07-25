package finance.financeApp.controller;

import finance.financeApp.model.Transacao;
import finance.financeApp.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transacao> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscar(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transacao criar(@RequestBody Transacao transacao) {
        return service.save(transacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable UUID id, @RequestBody Transacao transacao) {
        if (!service.findById(id).isPresent()) return ResponseEntity.notFound().build();
        transacao.setId(id);
        return ResponseEntity.ok(service.save(transacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        if (!service.findById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
