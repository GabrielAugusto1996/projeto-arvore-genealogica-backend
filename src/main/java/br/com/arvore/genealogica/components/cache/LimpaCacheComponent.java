package br.com.arvore.genealogica.components.cache;

import br.com.arvore.genealogica.exceptions.CacheException;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class LimpaCacheComponent {

    private static final String MSG_ERROR = "Não existe um cache com o nome informado.";
    private final CacheManager cacheManager;

    public LimpaCacheComponent(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void limpar(String nomeCache) {
        String cacheFiltrado = this.cacheManager.getCacheNames().stream()
                .filter(cacheNameFilter -> cacheNameFilter.equals(nomeCache))
                .findFirst()
                .orElseThrow(() -> new CacheException(MSG_ERROR));

        this.cacheManager.getCache(cacheFiltrado).clear();
    }
}
