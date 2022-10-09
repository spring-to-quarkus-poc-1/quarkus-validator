package br.com.company.core.validator;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.logging.MDC;

@Provider
public class LoggingFilter implements ContainerRequestFilter,
        ContainerResponseFilter {

    private static final Logger logger = Logger.getLogger(LoggingFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        logger.debug("-----IN-----");
        logger.debug("URL:");
        logger.debug(requestContext.getUriInfo().getRequestUri());
        logger.debug("Method:");
        logger.debug(requestContext.getMethod());
        logger.debug("Media Type:");
        logger.debug(requestContext.getMediaType());
        logger.debug("Headers:");
        logger.debug(requestContext.getHeaders());
        logger.debug("LoggingFilter.filter() "+requestContext.getHeaders());
        String transacao = requestContext.getHeaderString("transacao_id");
        if(transacao != null) {
            MDC.put("idDaTransacao", requestContext.getHeaderString("transacao_id"));
        }
        
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        logger.debug("-----OUT-----");
        logger.debug("Status");
        logger.debug(responseContext.getStatus());
        logger.debug("Entity");
        logger.debug(responseContext.getEntity());
        logger.debug("EntityClass");
        logger.debug(responseContext.getEntityClass());
        logger.debug("Headers");
        logger.debug(responseContext.getHeaders());
    }
}
