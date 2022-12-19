package br.com.mangahub.interfaces.queries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mangahub.models.Users;
import br.com.mangahub.models.filters.UsersFilter;

public interface UserQueries {
	Page<Users> pesquisar(UsersFilter filter, Pageable pageable);
}
