/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.model.WorkLoad;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author lenovo
 */
public class GroupWorkLoadTableModel extends WorkLoadTableModel{     //某月班组冲次排名
     public GroupWorkLoadTableModel(String startDateString , String endDateString) {
        super(startDateString, endDateString);
        headers = new String[] {"排名","班组名","冲次数","平均冲次数"};
        datas = reportManager.getGroupWorkLoad(startDateString, endDateString);
        Collections.sort(datas, new Comparator<WorkLoad>(){
            public int compare(WorkLoad workLoad1 , WorkLoad workLoad2) {
               if(workLoad2.getWorkLoad() < workLoad1.getWorkLoad()) {
                   return -1;
               } else if(workLoad2.getWorkLoad() > workLoad1.getWorkLoad()) {
                   return 1;
               } else {
                   return 0;
               }
            }
        });
        for(int rank=0;rank<datas.size();++rank) {
            datas.get(rank).setRank(rank+1);
        }
    }
}
