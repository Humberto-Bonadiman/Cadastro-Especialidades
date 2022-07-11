package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/professional")
public class ProfessionalController {
  @Autowired
  private ProfessionalService service;

  /**
   * find all.
   */
  @GET
  @Path("/all")
  @Consumes("application/json")
  @Produces("application/json")
  public Response findAll() {
    List<Professional> professionalList = service.professionalList();
    if (professionalList.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).entity(
          new ApplicationError(Response.Status.NOT_FOUND, "Nenhum registro foi encontrado!"))
          .build();
    }
    return Response.status(Response.Status.OK).entity(professionalList).build();
  }

  /**
   * insert.
   */
  @POST
  @Path("/add")
  @Consumes("application/json")
  @Produces("application/json")
  public Response insert(Professional professional) {
    if (professional.getId() != null) {
      return Response.status(Response.Status.BAD_REQUEST).entity(
          new ApplicationError(
          Response.Status.BAD_REQUEST, "Não é permitido inserir novos registros com ID explícito"))
          .build();
    }
    service.addProfessional(professional);
    return Response.status(Response.Status.CREATED).entity("Inserido").build();
  }
}
