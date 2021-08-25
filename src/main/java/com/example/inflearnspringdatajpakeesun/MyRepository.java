package com.example.inflearnspringdatajpakeesun;

import com.sun.istack.NotNull;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends Repository<T, ID> {

    <E extends T> E save(@NotNull E entity);

    List<T> findAll();

    @Nullable
    <E extends T> Optional<E> findById(ID id);
}
