/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bc.jde.dis.request.entity;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno
 */
@XmlRootElement
public class ResposeEntity extends RequestEntity{
    private Date startTime;
    private Date endTime;
    private List<DataRow> rowSet;
    
    public ResposeEntity() {
        super();
    }
@XmlElement
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
@XmlElement
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
@XmlElement

    public List<DataRow> getRowSet() {
        return rowSet;
    }

    public void setRowSet(List<DataRow> rowSet) {
        this.rowSet = rowSet;
    }

  

    
    
    
}
