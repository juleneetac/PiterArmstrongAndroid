package edu.upc.dsa.services;

import edu.upc.dsa.UserDAO;
import edu.upc.dsa.UserDAOImpl;
import edu.upc.dsa.models.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//API Return codes: 200, 201, 400, 404, 409, 500
//@ApiResponse(code = 200, message = "Successful")
//@ApiResponse(code = 201, message = "Successfully Created")
//@ApiResponse(code = 400, message = "Bad Request (Error in input parameters' format)")
//@ApiResponse(code = 404, message = "Not Found")
//@ApiResponse(code = 409, message = "Conflict (Resource already existing. User, for example)")
//@ApiResponse(code = 500, message = "Internal Server Error")

@Api(value = "/usermanager", description = "Users/Players Manager service")
@Path("/usermanager")

public class UserManagerService {

    private UserDAO us;

    public UserManagerService() {
        this.us = UserDAOImpl.getInstance();
    }



    @POST
    @ApiOperation(value = "Login", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User usrin) {
            User usrout = this.us.login(usrin);
            String res = usrout.getUsername();
            switch (res){
                case "404": return Response.status(404).build();
                case "500": return Response.status(500).build();
                default: return Response.status(200).entity(usrout).build();
            }
    }



    @POST
    @ApiOperation(value = "Create a new user (Register)", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Successfully Created"),
            @ApiResponse(code = 400, message = "Bad Request (Error in input parameters' format)"),
            @ApiResponse(code = 409, message = "Conflict (User already exists)"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User usr) {

        int res = this.us.addUser(usr.getUsername(), usr.getPassword());
        switch (res){
            case 201: return Response.status(201).build();
            case 400: return Response.status(400).build();
            case 409: return Response.status(409).build();
            default: return Response.status(500).build();
        }
    }



    @GET
    @ApiOperation(value = "Get the list of all Users", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> usrlist = this.us.getUsers();
        GenericEntity<List<User>> listentity = new GenericEntity<List<User>>(usrlist){};
        switch (usrlist.get(0).getUsername()){
            case "500": return Response.status(500).build();
            default: return Response.status(200).entity(listentity).build();
        }
    }



    @GET
    @ApiOperation(value = "Get User stats (User class) given its name", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/users/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("name") String name) {
        User usr = this.us.getUser(name);
        switch (usr.getUsername()){
            case "404": return Response.status(404).build();
            default: return Response.status(200).entity(usr).build();
        }
    }



    @POST
    @ApiOperation(value = "Auto-update of User stats or modify its password", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully updated"),
            @ApiResponse(code = 400, message = "Bad Request (Error in input parameters' format)"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/users/{name}/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User usr, @PathParam("name") String name) {
        int res = this.us.updateUser(name,usr);
        switch (res){
            case 201: return Response.status(201).build();
            case 400: return Response.status(400).build();
            default: return Response.status(500).build();
        }
    }



    @POST
    @ApiOperation(value = "Delete an existing User", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully deleted"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/users/{name}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(User us) {
        int res = this.us.deleteUser(us.getUsername(), us.getPassword());
        switch (res) {
            case 201:
                return Response.status(201).build();
            default:
                return Response.status(500).build();
        }
    }



    @GET
    @ApiOperation(value = "Get the Screen of a User", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully", response = String.class),
            @ApiResponse(code = 404, message = "Screen Not Found")
    })
    @Path("/users/{name}/screen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserScreen(@PathParam("name") String name) {
        String res = this.us.getUserScreen(name);
        switch (res) {
            case "404":
                return Response.status(404).build();
            default:
                return Response.status(200).entity(res).build();
        }
    }


    @GET
    @ApiOperation(value = "Get Objects list from a User", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objeto.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    @Path("/users/{name}/objects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserObjects(@PathParam("name") String name) {

        List<Objeto> objlist = this.us.getUserObjects(name);
        GenericEntity<List<Objeto>> listentity = new GenericEntity<List<Objeto>>(objlist){};

        switch (objlist.get(0).getNombre()) {
            case "500":
                return Response.status(500).build();
            default:
                return Response.status(200).entity(listentity).build();
        }
    }



    @POST
    @ApiOperation(value = "Add an Object to a User", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Path("/users/{name}/addobject")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addObjectToUser(String obj, @PathParam("name") String name) {
        int res = this.us.addObjectToUser(name, obj);
        switch (res) {
            case 201:
                return Response.status(201).build();
            default:
                return Response.status(500).build();
        }
    }

}

