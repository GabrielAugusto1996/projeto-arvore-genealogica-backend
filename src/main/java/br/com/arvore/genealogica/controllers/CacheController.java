package br.com.arvore.genealogica.controllers;

import br.com.arvore.genealogica.components.cache.LimpaCacheComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caches")
public class CacheController {

    private static final String MSG_CACHE_LIMPADO = "Cache limpado com sucesso!";
    private final LimpaCacheComponent limpaCacheComponent;

    public CacheController(LimpaCacheComponent limpaCacheComponent) {
        this.limpaCacheComponent = limpaCacheComponent;
    }

    @PutMapping("/{cacheName}")
    public ResponseEntity<String> limparCache(@RequestParam("cacheName") String cacheName) {
        this.limpaCacheComponent.limpar(cacheName);

        return ResponseEntity.ok(MSG_CACHE_LIMPADO);
    }
}
