package br.com.mangahub.interfaces.queries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mangahub.models.Mangas;
import br.com.mangahub.models.filters.MangasFilter;

public interface MangaQueries {
	Page<Mangas> pesquisar(MangasFilter filter, Pageable pageable);
}
