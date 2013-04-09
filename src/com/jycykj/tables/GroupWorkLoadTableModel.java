/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

/**
 *
 * @author lenovo
 */
public class GroupWorkLoadTableModel extends WorkLoadTableModel{
     public GroupWorkLoadTableModel(String startDateString , String endDateString) {
        super(startDateString, endDateString);
        headers = new String[] {"排名","姓名","冲次数","平均冲次数"};
        datas = reportManager.getWorkerWorkLoad(startDateString, endDateString);
    }
}
