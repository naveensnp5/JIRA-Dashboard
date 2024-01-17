package com.workflow.jiraDashBoard.constants;


/**
 * 
 * @author User
 *
 */
public class APIReference {
	
	public static final String CREATE_TICKET ="/api/tickets/create";
	
	public static final String ASSIGN_TICKET ="/api/tickets/{ticketId}/assign";
	
	public static final String INPROGRESS_TICKET ="/api/tickets/{ticketId}/in-progress";
	
	public static final String CLOSE_TICKET ="/api/tickets/{ticketId}/close";
	
	public static final String RETURN_TICKET ="/api/tickets/{ticketId}/return";
	
	public static final String REJECT_TICKET ="/api/tickets/{ticketId}/reject";

}
