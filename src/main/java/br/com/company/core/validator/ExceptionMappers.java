package br.com.company.core.validator;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

@ApplicationScoped
public class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<ExceptionResponse> mapException(UnknownCheeseException x) {
        return RestResponse.status(Response.Status.NOT_FOUND, new ExceptionResponse("Unknown Cheese: " + x.getName(), "XPTO-1"));
    }

}
