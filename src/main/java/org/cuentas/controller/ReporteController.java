package org.cuentas.controller;

import java.time.LocalDate;
import java.util.List;

import org.cuentas.entity.Reporte;
import org.cuentas.service.ReporteService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reportes")
@Produces(MediaType.APPLICATION_JSON)
public class ReporteController {

    @Inject
    ReporteService service;

    @GET
    public Response generarReporte(@QueryParam("fechaInicio") String fechaInicio,
                                   @QueryParam("fechaFin") String fechaFin,
                                   @QueryParam("idCliente") Long idCliente) {
        LocalDate fechaInicio1 = LocalDate.parse(fechaInicio);
        LocalDate fechaFin1 = LocalDate.parse(fechaFin);
        List<Reporte> cosa = service.generarReporte(fechaInicio1, fechaFin1, idCliente);
        return Response.ok(cosa).build();
    }
}
