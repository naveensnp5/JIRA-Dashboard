package com.workflow.jiraDashBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workflow.jiraDashBoard.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Modifying
	@Query(nativeQuery = true,value = "update Ticket u set u.assigneeId=:assigneeId, u.reportedId=:reportedId, u.status='In Progress' where u.id=:ticketId")
	void updateAssigneeId(@Param("ticketId") Long ticketId, @Param("assigneeId") Long assigneeId,
			@Param("reportedId") Long reportedId);

	@Modifying
	@Query(nativeQuery = true,value = "update Ticket u set u.status=:status where u.id=:ticketId")
	void updateStatus(@Param("ticketId") Long ticketId, @Param("status") String status);

}
