package de.friendsurance.ca.repository;

import de.friendsurance.ca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
