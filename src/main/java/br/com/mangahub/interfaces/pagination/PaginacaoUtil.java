package br.com.mangahub.interfaces.pagination;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginacaoUtil {
	public static void prepararIntervalo(TypedQuery<?> typedQuery, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;
		typedQuery.setFirstResult(primeiroRegistro);
		typedQuery.setMaxResults(totalRegistrosPorPagina);
	}
	
	public static void prepararOrdem(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder, Pageable pageable) {
		String atributo;
		Sort sort = pageable.getSort();
		Order order;
		List<Order> ordenacoes = new ArrayList<>();
		if (sort != null && !sort.isEmpty()) {
			for (Sort.Order o : sort) {
			    atributo = o.getProperty();
			    order = o.isAscending() ? builder.asc(root.get(atributo)) : builder.desc(root.get(atributo));
			    ordenacoes.add(order);
			}
		}
		criteriaQuery.orderBy(ordenacoes);
	}
	
	public static long getTotalRegistros(Root<?> root, Predicate[] predicateArray, CriteriaBuilder builder, EntityManager manager) {
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		criteriaQuery.select(builder.count(criteriaQuery.from(root.getJavaType())));
		criteriaQuery.where(predicateArray);
		TypedQuery<Long> typedQueryTotal = manager.createQuery(criteriaQuery);
		long totalRegistros = typedQueryTotal.getSingleResult();
		return totalRegistros;
	}
}
