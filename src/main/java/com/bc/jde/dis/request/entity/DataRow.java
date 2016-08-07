/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bc.jde.dis.request.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno
 */
@XmlRootElement
public class DataRow {
    private List<DataField> dataField;
    public DataRow() {
        dataField = new ArrayList<>();
    }

     @XmlElement
    public List<DataField> getDataField() {
        return dataField;
    }
    
    public void setDataField(List<DataField> dataFields) {
        this.dataField = dataFields;
    }
    
}
