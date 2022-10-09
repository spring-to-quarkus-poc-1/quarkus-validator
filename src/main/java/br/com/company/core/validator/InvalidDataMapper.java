package br.com.company.core.validator;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidDataMapper implements ExceptionMapper<InvalidDataException> {

    @Override
    public Response toResponse(InvalidDataException arg0) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ExceptionResponse("Data Invalida", "XPTO-2")).build();
    }

}