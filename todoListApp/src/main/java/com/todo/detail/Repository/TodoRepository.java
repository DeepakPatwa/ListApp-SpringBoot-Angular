package com.todo.detail.Repository;

import com.todo.detail.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TodoRepository extends PagingAndSortingRepository<Todo, Integer> {
    Page<Todo> findByIdBetween(int start, int end, Pageable pageable);
}
