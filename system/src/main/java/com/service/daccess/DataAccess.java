package com.service.daccess;

import java.util.List;

public interface DataAccess<E> {
    public E getById(int id);

    public List<E> getAll();


}
