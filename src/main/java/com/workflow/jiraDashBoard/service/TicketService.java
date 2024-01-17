package com.workflow.jiraDashBoard.service;

import com.workflow.jiraDashBoard.entity.Ticket;

public interface TicketService {

	public Ticket createTicket(Ticket ticket) throws Exception;

	public Ticket assignTicket(Long ticketId, Long assigneeId, Long reporterId) throws Exception;

	public Ticket updateTicketStatus(Long ticketId, String status) throws Exception;

}
