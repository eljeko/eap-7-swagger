package org.jboss;

//import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/greet")
@Api(value = "Greet", description = "Endpoint for Hello specific operations")
public class Greet {
    @ApiOperation(value = "Get user by user name")
    @GET
    @Path("/json")
    @Produces({"application/json"})
    public String getHelloWorldJSON() {
        return "{\"result\":\"Hello!\"}";
    }

    @GET
    @Path("/xml")
    @Produces({"application/xml"})
    public String getHelloWorldXML() {
        return "<xml><result>Hello!</result></xml>";
    }

    @GET
    @Path("/all/{param}")
    @ApiOperation(value = "Returns param", notes = "Returns param", response = Greet.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of param value", response = Greet.class)})
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response printMessage(@PathParam("param") String msg) {
        String result = "Hello " + msg + "!";
        return Response.status(200).entity(result).build();
    }
}
