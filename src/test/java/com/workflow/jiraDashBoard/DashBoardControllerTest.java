package com.workflow.jiraDashBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.workflow.jiraDashBoard.config.ResponseWrapper;
import com.workflow.jiraDashBoard.constants.Constants;
import com.workflow.jiraDashBoard.controller.DashBoardController;
import com.workflow.jiraDashBoard.entity.Ticket;
import com.workflow.jiraDashBoard.service.TicketService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DashBoardControllerTest {

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private DashBoardController dashBoardController;

    @Test
    void testCreateTicket() throws Exception {
        Ticket inputTicket = new Ticket();
        inputTicket.setCreatorId(1L);
        Ticket createdTicket = new Ticket(); 
        when(ticketService.createTicket(inputTicket)).thenReturn(createdTicket);
        ResponseEntity<ResponseWrapper<Ticket>> responseEntity = dashBoardController.createTicket(inputTicket);
        verify(ticketService, times(1)).createTicket(inputTicket);
    }
    
    @Test
    void testCreateErrorTicket() throws Exception {
        Ticket inputTicket = new Ticket();
        Ticket createdTicket = new Ticket(); 
        when(ticketService.createTicket(inputTicket)).thenReturn(createdTicket);
        ResponseEntity<ResponseWrapper<Ticket>> responseEntity = dashBoardController.createTicket(inputTicket);
        verify(ticketService, times(1)).createTicket(inputTicket);
    }

    @Test
    void testAssignTicket() throws Exception {
        ResponseEntity<ResponseWrapper<Ticket>> responseEntity = dashBoardController.assignTicket(1L,2L,3L);
        verify(ticketService, times(1)).assignTicket(1L,2L,3L);
    }

    @Test
    void testInProgressTicket() throws Exception {
    	ResponseEntity<ResponseWrapper<Ticket>> responseEntity = dashBoardController.inProgressTicket(1L);
        verify(ticketService, times(1)).updateTicketStatus(1L, Constants.IN_PROGRESS);
    }

    @Test
    void testCloseTicket() throws Exception {
    	ResponseEntity<ResponseWrapper<Ticket>> responseEntity = dashBoardController.closeTicket(1L);
        verify(ticketService, times(1)).updateTicketStatus(1L, Constants.CLOSED);
    }

    @Test
    void testReturnTicket() throws Exception {
    	ResponseEntity<ResponseWrapper<Ticket>> responseEntity = dashBoardController.returnTicket(1L);
        verify(ticketService, times(1)).updateTicketStatus(1L, Constants.RETURNED);
    }

    @Test
    void testRejectTicket() throws Exception {
    	ResponseEntity<ResponseWrapper<Ticket>> responseEntity = dashBoardController.rejectTicket(1L);
        verify(ticketService, times(1)).updateTicketStatus(1L, Constants.REJECTED);
    }
}
