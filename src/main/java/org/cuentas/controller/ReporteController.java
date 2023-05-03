package org.cuentas.controller;

import java.util.List;

import org.cuentas.entity.Reporte;
import org.cuentas.exceptions.Message;
import org.cuentas.service.ReporteService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reportes")
@Produces(MediaType.APPLICATION_JSON)
public class ReporteController {

    @Inject
    ReporteService service;

    @GET
    public Response reporte() {
        try {
            List<Reporte> reporte = service.reporte();
            System.out.println("###############################");
            System.out.println(reporte);
            System.out.println("###############################");
            if (reporte.isEmpty())
                return Response.ok(reporte).status(Response.Status.NO_CONTENT).build();
            return Response.ok(reporte).build();
        } catch (Exception e) {
            System.out.println("###############################");
            System.out.println("Nos vinimos por la excepcion");
            System.out.println("###############################");
            String message = e.getMessage();
            Message messageResponse = new Message();
            messageResponse.buildMessage(message);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(messageResponse).build();
        }
    }
}
