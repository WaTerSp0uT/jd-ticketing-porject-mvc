package com.cybertek.service;

import com.cybertek.dto.UserDTO;


//In User DTO unique value will be email that's why ID from generic equals to String
public interface UserService extends CrudService<UserDTO, String>{
    //Business logic here
    //save
    //find User by username
    //give me all user list
    //delete
    //    UserDTO save(UserDTO user);
    //    UserDTO findByID(String username);
    //    List<UserDTO> findAll();
    //    void delete(UserDTO user);
    //    void deleteByID(String username);

}
