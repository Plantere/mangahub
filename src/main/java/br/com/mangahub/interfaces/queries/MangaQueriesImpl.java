package br.com.mangahub.interfaces.queries;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.mangahub.interfaces.pagination.PaginacaoUtil;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.models.filters.MangasFilter;

public class MangaQueriesImpl implements MangaQueries {
    @PersistenceContext
	private EntityManager manager;
	
	@Override
    public Page<Mangas> pesquisar(MangasFilter filter, Pageable pageable){
        
        CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Mangas> criteriaQuery = builder.createQuery(Mangas.class);
		Root<Mangas> manga = criteriaQuery.from(Mangas.class);
        TypedQuery<Mangas> typedQuery;
		List<Predicate> predicateList = new ArrayList<>();

        if (filter.getNameDescription() != null && !filter.getNameDescription().isEmpty()) {
			predicateList.add(builder.like(builder.lower(manga.<String>get("mangaName")), "%" + filter.getNameDescription().toLowerCase() + "%"));
		}
		predicateList.add(builder.isNull(manga.<LocalDateTime>get("deletedAt")));

		Predicate[] predArray = new Predicate[predicateList.size()];
		predicateList.toArray(predArray);

		criteriaQuery.select(manga).where(predArray);
    
		PaginacaoUtil.prepararOrdem(manga, criteriaQuery, builder, pageable);
		
		typedQuery = manager.createQuery(criteriaQuery);
						
		PaginacaoUtil.prepararIntervalo(typedQuery, pageable);
		
		List<Mangas> Mangas = typedQuery.getResultList();
		
		long totalMangas = PaginacaoUtil.getTotalRegistros(manga, predArray, builder, manager);
		Page<Mangas> page = new PageImpl<>(Mangas, pageable, totalMangas);
		
		return page;
        
    }
}