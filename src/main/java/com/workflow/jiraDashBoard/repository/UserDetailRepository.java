package com.workflow.jiraDashBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workflow.jiraDashBoard.entity.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

	@Query("select u.id from UserDetail u where u.id=:ticketId")
	public Long findbyTicketId(@Param("ticketId") Long ticketId);

}
