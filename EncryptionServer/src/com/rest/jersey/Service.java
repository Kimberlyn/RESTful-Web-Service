package com.rest.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/encrypt")
public class Service 
{ 
  final private String secretKey="CS";
  @Path("{t}")
  @GET
  @Produces("text/html")  //THIS WILL FILTER IF ENCRYPT OR DECRYPT AND RETURN STRING CORRESPODING BACK TO CLIENT FROM SERVICE
  public Response convert(@PathParam("t") 
    String t) throws Exception { 
	String[] tokens=t.split(",");
	String result="";
	
	if(tokens[0].equals("encrypt"))
	{
		String encryptedString=Encryption.encrypt(tokens[1], secretKey);
		
		
		
		
		result+=encryptedString;
	}
	else if(tokens[0].equals("decrypt"))
	{
		String decryptedString=Encryption.decrypt(tokens[1], secretKey);
		result+=decryptedString;
	}
	else
	{
		result+="ERROR";
	}
    return Response.status(200).entity(result).build();
  }

  
  
}
