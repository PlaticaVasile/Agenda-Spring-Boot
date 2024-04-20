package com.daspaket.diary.repository;

import com.daspaket.diary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserNewRepository extends JpaRepository<User, Integer>
{
    /*
  This is an annotation provided by Spring Data JPA that allows you to define custom
  JPQL (Java Persistence Query Language) queries directly in your repository interface.
  SELECT u: This part specifies that you want to select entities of type User.
  In JPQL, u is an alias for the User entity.FROM User u: This part specifies the
  entity type (User) and gives it the alias u. It's saying that you're selecting entities
  from the User table and referring to each entity as u.
    */
    @Query("select u from User u where u.Username = :in_name")
    Optional<User> findByNameRepo(String in_name); //:name must be name
    //not useful when attempting a login process

    @Query("select u from User u where u.Username = :username and u.Password = :password")
    Optional<User> loginProcessRepo(String username, String password);

    @Query("select u from User u where u.Username = :username and u.Password = :password and u.Email = :email and u.Type = :type")
    Optional<User> findUserByUserNewRepo(String username, String password, String email, String type);

    //folosit cand afisam tipul de user cand creem un cont, afisare dinamic preferabila in locul celei hardcodate
    @Query("select distinct Type from User")
    List<String> displayTypeRepo();
}
