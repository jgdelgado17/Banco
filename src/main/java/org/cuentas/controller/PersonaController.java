package org.cuentas.controller;

import java.util.List;

import org.cuentas.entity.Persona;
import org.cuentas.service.PersonaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaController {
    @Inject
    private PersonaService service;

    @GET
    public Response listarPersonas() {
        List<Persona> personas = service.findAll();
        if (personas.isEmpty())
            return Response.noContent().build();
        return Response.ok(personas).build();
    }
}
