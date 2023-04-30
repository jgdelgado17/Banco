package org.cuentas.repository;

import java.util.List;

public interface RepositoryCrud<T> {
    List<T> findAll();
    // T findOne(int id);
    // T save(T data);
}
