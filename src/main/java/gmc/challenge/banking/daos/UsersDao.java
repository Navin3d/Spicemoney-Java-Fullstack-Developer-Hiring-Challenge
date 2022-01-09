package gmc.challenge.banking.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.challenge.banking.entities.UsersEntity;

public interface UsersDao extends JpaRepository<UsersEntity, Long> {
	UsersEntity findByUserId(String userId);
}
