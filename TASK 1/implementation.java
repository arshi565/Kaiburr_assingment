// GET all servers or a single server by ID
@GET
@Path("/servers")
@Produces(MediaType.APPLICATION_JSON)
public Response getServers(@QueryParam("id") String id) {
    if (id != null) {
        Server server = serverService.getServerById(id);
        if (server != null) {
            return Response.ok(server).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } else {
        List<Server> servers = serverService.getAllServers();
        return Response.ok(servers).build();
    }
}

// PUT a new server
@PUT
@Path("/servers")
@Consumes(MediaType.APPLICATION_JSON)
public Response createServer(Server server) {
    serverService.createServer(server);
    return Response.status(Response.Status.CREATED).build();
}

// DELETE a server by ID
@DELETE
@Path("/servers/{id}")
public Response deleteServer(@PathParam("id") String id) {
    if (serverService.deleteServerById(id)) {
        return Response.ok().build();
    } else {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

// GET servers by name
@GET
@Path("/servers")
@Produces(MediaType.APPLICATION_JSON)
public Response getServersByName(@QueryParam("name") String name) {
    List<Server> servers = serverService.getServersByName(name);
    if (servers.isEmpty()) {
        return Response.status(Response.Status.NOT_FOUND).build();
    } else {
        return Response.ok(servers).build();
    }
}
