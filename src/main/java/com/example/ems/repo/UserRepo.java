package com.example.ems.repo;

import com.example.ems.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    User getUserByUserId(String userId);

    @Query(value = "SELECT * FROM user WHERE id = ?1 AND address = ?2",nativeQuery = true ) //?first variable and Second Variable
    User getUserByUserIDAndAddress(String userId, String address);

    //if it is Update query need to add @Modifying annotation
}
