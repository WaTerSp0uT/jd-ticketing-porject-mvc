package com.cybertek.service;

import com.cybertek.dto.RoleDTO;

import java.util.List;

public interface CrudService<T, ID> {
    //Business logic here
    //save
    //find User by username
    //give me all user list
    //delete
    List<T> findAll();
    T findById(ID id);
    void delete(T object);
    void deleteByID(ID id);
    T save (T object);
}
