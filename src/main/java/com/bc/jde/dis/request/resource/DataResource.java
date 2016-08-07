/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bc.jde.dis.request.resource;

import com.bc.jde.dis.request.entity.DataField;
import com.bc.jde.dis.request.entity.DataObject;
import com.bc.jde.dis.request.entity.DataRow;
import com.bc.jde.dis.request.entity.RequestEntity;
import com.bc.jde.dis.request.entity.ResposeEntity;
import com.bc.jde.dis.request.service.SqlProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author bruno
 */
@Path("v1/query")
public class DataResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DataResource
     */
    public DataResource() {
    }

    /**
     * Retrieves representation of an instance of com.bc.jde.dis.dataAccess.DataResource
     * @param rq
     * @return an instance of com.bc.jde.dis.request.ResposeEntity
     */
    @POST
  @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public List<DataRow>  getXml(RequestEntity rq) {
        //TODO return proper representation object
        System.out.println("request received");
        System.out.println(rq.getUsername());
        SqlProcessor sp = new SqlProcessor();
        List<DataRow>  d = sp.processSqlString(rq.getWebSql());
        ResposeEntity rp = new ResposeEntity();

     
    
        return d;
        
    }

    /**
     * PUT method for updating or creating an instance of DataResource
     * @param content representation for the resource
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public RequestEntity putXml() {
        RequestEntity r = new RequestEntity();
        r.setUsername("bruno");
        r.setCorrelationId("lll");
        r.setProgramName("kkk");
        r.setWebSql("sele");
        return r;
    }
}
