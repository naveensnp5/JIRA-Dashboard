package com.workflow.jiraDashBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.jiraDashBoard.config.ResponseWrapper;
import com.workflow.jiraDashBoard.constants.APIReference;
import com.workflow.jiraDashBoard.constants.Constants;
import com.workflow.jiraDashBoard.entity.Ticket;
import com.workflow.jiraDashBoard.service.TicketService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author User
 *
 */
@RestController
@Slf4j
public class DashBoardController {

	@Autowired
	private TicketService ticketService;

	/**
	 * 
	 * @param ticket
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = APIReference.CREATE_TICKET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper<Ticket>> createTicket(@RequestBody Ticket ticket) throws Exception {

		try {
			if (ticket.getCreatorId() == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Ticket createdTicket = ticketService.createTicket(ticket);
			ResponseWrapper<Ticket> responseWrapper = new ResponseWrapper<>("Ticket created successfully",
					createdTicket);
			return new ResponseEntity<>(responseWrapper, HttpStatus.CREATED);
		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * 
	 * @param ticketId
	 * @param assigneeId
	 * @param reporterId
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = APIReference.ASSIGN_TICKET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper<Ticket>> assignTicket(@PathVariable Long ticketId,
			@RequestParam Long assigneeId, @RequestParam Long reporterId) throws Exception {
		try {
			if (reporterId == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Ticket assignedTicket = ticketService.assignTicket(ticketId, assigneeId, reporterId);
			ResponseWrapper<Ticket> responseWrapper = new ResponseWrapper<>("Ticket Assigned successfully",
					assignedTicket);
			return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = APIReference.INPROGRESS_TICKET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper<Ticket>> inProgressTicket(@PathVariable Long ticketId) throws Exception {
		try {

			Ticket assignedTicket = ticketService.updateTicketStatus(ticketId, Constants.IN_PROGRESS);
			ResponseWrapper<Ticket> responseWrapper = new ResponseWrapper<>("Ticket Status Changed to In-progress",
					assignedTicket);
			return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = APIReference.CLOSE_TICKET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper<Ticket>> closeTicket(@PathVariable Long ticketId) throws Exception {
		try {

			Ticket assignedTicket = ticketService.updateTicketStatus(ticketId, Constants.CLOSED);
			ResponseWrapper<Ticket> responseWrapper = new ResponseWrapper<>("Ticket Closed successfully",
					assignedTicket);
			return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = APIReference.RETURN_TICKET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper<Ticket>> returnTicket(@PathVariable Long ticketId) throws Exception {
		try {
			Ticket assignedTicket = ticketService.updateTicketStatus(ticketId, Constants.RETURNED);
			ResponseWrapper<Ticket> responseWrapper = new ResponseWrapper<>("Ticket Returned successfully",
					assignedTicket);
			return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = APIReference.REJECT_TICKET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper<Ticket>> rejectTicket(@PathVariable Long ticketId) throws Exception {
		try {
			Ticket assignedTicket = ticketService.updateTicketStatus(ticketId, Constants.REJECTED);
			ResponseWrapper<Ticket> responseWrapper = new ResponseWrapper<>("Ticket Rejected successfully",
					assignedTicket);
			return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}

}
