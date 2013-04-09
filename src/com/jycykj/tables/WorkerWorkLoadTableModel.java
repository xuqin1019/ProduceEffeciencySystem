/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;
/**
 *
 * @author lenovo
 */
public class WorkerWorkLoadTableModel extends WorkLoadTableModel { //某月员工冲次排名
    
    public WorkerWorkLoadTableModel(String startTimeString , String endTimeString) {
        super(startTimeString, endTimeString);
        headers = new String[] {"排名","姓名","冲次数","平均冲次数"};
        datas = reportManager.getWorkerWorkLoad(startTimeString, endTimeString);
//        Collections.sort(datas, new Comparator<WorkLoad>(){
//            public int compare(WorkLoad workLoad1 , WorkLoad workLoad2) {
//               if(workLoad2.getWorkLoad() < workLoad1.getWorkLoad()) {
//                   return -1;
//               } else if(workLoad2.getWorkLoad() > workLoad1.getWorkLoad()) {
//                   return 1;
//               } else {
//                   return 0;
//               }
//            }
//        });
        for(int rank=0;rank<datas.size();++rank) {
            datas.get(rank).setRank(rank+1);
        }
    }
    
}
