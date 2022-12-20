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
import br.com.mangahub.models.Roles;
import br.com.mangahub.models.Users;
import br.com.mangahub.models.filters.UsersFilter;

public class UserQueriesImpl implements UserQueries {
    @PersistenceContext
	private EntityManager manager;
	
	@Override
    public Page<Users> pesquisar(UsersFilter filter, Pageable pageable){
        
        CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Users> criteriaQuery = builder.createQuery(Users.class);
		Root<Users> user = criteriaQuery.from(Users.class);
		user.fetch("favorites", JoinType.LEFT);
        TypedQuery<Users> typedQuery;
		List<Predicate> predicateList = new ArrayList<>();

		if (filter.getDataCriacaoMaiorQue() != null) {
			predicateList.add(builder.greaterThanOrEqualTo(user.<LocalDateTime>get("createdAt"), 
					filter.getDataCriacaoMaiorQue()));
		}
		if (filter.getDataCriacaoMenorQue() != null) {
			predicateList.add(builder.lessThanOrEqualTo(user.<LocalDateTime>get("createdAt"), 
					filter.getDataCriacaoMenorQue()));
		}
		if (filter.getFavoritosMaiorQue() != null) {
			predicateList.add(builder.ge(builder.size(user.get("favorites")), filter.getFavoritosMaiorQue()));
		}
		if (filter.getFavoritosMenorQue() != null) {
			predicateList.add(builder.le(builder.size(user.get("favorites")), filter.getFavoritosMenorQue()));
		}

        if (filter.getName() != null && !filter.getName().isEmpty()) {
			predicateList.add(builder.like(builder.lower(user.<String>get("name")), "%" + filter.getName().toLowerCase() + "%"));
		}
        
		if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
			predicateList.add(builder.like(builder.lower(user.<String>get("email")), "%" + filter.getName().toLowerCase() + "%"));
		}

		if (filter.getRole() != null && filter.getRole() != 0) {
			predicateList.add(builder.equal(user.get("roles"), filter.getRole()));
		}

		predicateList.add(builder.isNull(user.<LocalDateTime>get("deletedAt")));

		Predicate[] predArray = new Predicate[predicateList.size()];
		predicateList.toArray(predArray);

		criteriaQuery.select(user).where(predArray);
    
		PaginacaoUtil.prepararOrdem(user, criteriaQuery, builder, pageable);
		
		typedQuery = manager.createQuery(criteriaQuery);
						
		PaginacaoUtil.prepararIntervalo(typedQuery, pageable);
		
		List<Users> users = typedQuery.getResultList();
		
		long totalUsers = PaginacaoUtil.getTotalRegistros(user, predArray, builder, manager);
		Page<Users> page = new PageImpl<>(users, pageable, totalUsers);
		
		return page;
        
    }
}