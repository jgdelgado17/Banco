package org.cuentas.controller;

import java.util.List;

import org.cuentas.entity.Cliente;
import org.cuentas.service.ClienteService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteController {
    @Inject
    private ClienteService service;

    @GET
    public Response getAllClientes() {
        List<Cliente> clientes = service.findAll();
        if (clientes.isEmpty())
            return Response.ok(clientes).status(Response.Status.NO_CONTENT).build();
        return Response.ok(clientes).build();
    }

    @GET
    @Path("/{id}")
    public Response getClienteById(@PathParam("id") Long id) {
        Cliente cliente = service.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }

    @POST
    public Response postCliente(Cliente cliente) {
        Cliente createdCliente = service.save(cliente);
        return Response.ok(createdCliente).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response putCliente(@PathParam("id") Long id, Cliente cliente) {
        Cliente c = service.findById(id);
        if (c != null) {
            Cliente updatedCliente = service.update(id, cliente);
            return Response.ok(updatedCliente).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCliente(@PathParam("id") Long id) {
        Cliente cliente = service.findById(id);
        if (cliente != null) {
            service.deleteById(id);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
