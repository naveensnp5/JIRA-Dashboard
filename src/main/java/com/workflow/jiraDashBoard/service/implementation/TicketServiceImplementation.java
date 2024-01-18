package com.workflow.jiraDashBoard.service.implementation;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workflow.jiraDashBoard.constants.Constants;
import com.workflow.jiraDashBoard.entity.Ticket;
import com.workflow.jiraDashBoard.repository.TicketRepository;
import com.workflow.jiraDashBoard.repository.UserDetailRepository;
import com.workflow.jiraDashBoard.service.TicketService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author User
 *
 */
@Service
@Slf4j
public class TicketServiceImplementation implements TicketService {

	private static final Logger log = LoggerFactory.getLogger(TicketServiceImplementation.class);

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private UserDetailRepository userDetailRepository;
	
	/**
	 * 
	 */
	@Override
	@Transactional
	public Ticket createTicket(Ticket ticket) throws Exception {
		try {
			log.info("Creating JIRA ticket for the creator Id :", ticket.getCreatorId());
			Long userId = Optional.ofNullable(userDetailRepository.findbyTicketId(ticket.getCreatorId())).orElseThrow(() -> new Exception("User Details Not Found"));

			ticket.setCreatorId(userId);
			ticket.setStatus(Constants.OPEN);
			return ticketRepository.save(ticket);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}

	}
	
	/**
	 * 
	 */
	@Override
	@Transactional
	public Ticket assignTicket(Long ticketId, Long assigneeId, Long reporterId) throws Exception {
		try {
			log.info("Assigning JIRA ticket for the ticketId Id :{} by the reporterId :{}", ticketId, reporterId);
			ticketRepository.updateAssigneeId(ticketId, assigneeId, reporterId);
			return ticketRepository.findById(ticketId).get();
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	/**
	 * 
	 */
	@Override
	@Transactional
	public Ticket updateTicketStatus(Long ticketId, String updateStatus) throws Exception {
		try {
			log.info("Updating JIRA ticket status for the ticket Id :", ticketId, updateStatus);
			ticketRepository.updateStatus(ticketId, updateStatus);
			return ticketRepository.findById(ticketId).get();
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

}
