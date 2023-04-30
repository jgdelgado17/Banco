package org.cuentas.repository;

import java.util.List;

public interface RepositoryCrud<T, ID> {
    List<T> findAll();
    T findOne(ID id);
    // T save(T data);
}
