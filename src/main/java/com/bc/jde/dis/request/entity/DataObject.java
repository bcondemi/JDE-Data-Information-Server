package com.bc.jde.dis.request.entity;

import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bruno Condemi
 */
@XmlRootElement
public class DataObject {
    private HashMap<Integer,List<DataField>> rows;

    public DataObject() {
        rows = new HashMap<>();
    }

      @XmlElement
    public HashMap<Integer, List<DataField>> getRows() {
        return rows;
    }

    public void setRows(HashMap<Integer, List<DataField>> rows) {
        this.rows = rows;
    }

    public void addRow(Integer integer, List<DataField> row) {
        rows.put(integer, row);
  }
 
    


    
    
    
}
