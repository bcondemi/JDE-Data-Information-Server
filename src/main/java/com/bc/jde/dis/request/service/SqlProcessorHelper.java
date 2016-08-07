/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bc.jde.dis.request.service;

import com.bc.jde.dis.request.entity.DataObject;
import com.bc.jde.dis.request.entity.DataField;
import com.bc.jde.dis.request.entity.DataRow;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.ResultSetDataModel;

/**
 *
 * @author bruno
 */
public class SqlProcessorHelper {

    public static List<DataRow>   buildDataObjcet(ResultSet rs) throws SQLException {
       List<DataRow>  dataObejct = new ArrayList<>();
        ResultSetMetaData meta = rs.getMetaData();
        int numOfcolumns = meta.getColumnCount();
        int j = 1;
        while (rs.next()) {
            List<DataField> row = new ArrayList<>();
            DataRow row2 = new DataRow();
            for (int i = 1; i <= numOfcolumns; i++) {
                DataField f = new DataField();
                f.setName(meta.getColumnName(i));
/*
                int columnType = meta.getColumnType(i);
                if (columnType == Types.VARCHAR) {
                    f.setValue(rs.getString(i));
                }
                if (columnType == Types.DATE) {
                    f.setValue(formatDate(rs.getDate(i)));
                }
                if ((columnType == Types.INTEGER||columnType == Types.BIGINT)) {
                    f.setValue(formatNumber(rs.getInt(i)));
                }
                if ((columnType == Types.FLOAT||columnType == Types.DECIMAL||columnType == Types.DOUBLE)) {
                    f.setValue(formatNumber(rs.getBigDecimal(i)));
                }
                */
                f.setValue(rs.getString(i));
                row.add(f);
                row2.setDataField(row);
                
            }
            dataObejct.add(row2);
            j++;
        }
        return dataObejct;
    }

    private static String formatDate(Date date) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
        return dt.format(date);
    }

    private static String formatNumber(BigDecimal bigDecimal) {
        return bigDecimal.toPlainString();
    }

    private static String formatNumber(Integer i) {
        return i.toString();
    }
    
  
}
