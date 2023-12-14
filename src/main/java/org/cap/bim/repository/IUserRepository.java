package org.cap.bim.repository;

import org.cap.bim.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer>{

}
