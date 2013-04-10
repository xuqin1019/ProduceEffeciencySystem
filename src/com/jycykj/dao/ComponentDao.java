/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.dao;

import com.jycykj.model.Component;
import com.jycykj.model.Procedure;
import com.jycykj.model.ProducedProcedure;
import com.jycykj.model.WorkLoad;
import com.jycykj.model.Worker;
import com.jycykj.model.WorkLoad;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public class ComponentDao {

    private static ComponentDao instance = null;

    public static ComponentDao getInstance() {
        if (instance == null) {
            instance = new ComponentDao();
        }
        return instance;
    }

    public List<ProducedProcedure> getWorks(String componentId,String batchName) {
        List<ProducedProcedure> works = new ArrayList<ProducedProcedure>();
        
          PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "";
            if(batchName.equals("")){    //不设定batchName的条件，列出所有批次号
                sql = "select E.batch_name,D.name,D.factor,B.name,A.passed_num,A.failed_num,A.time from (SELECT worker_id,component_id,batch_id,procedure_id,failed_num,passed_num,time FROM produce_work WHERE component_id='"+ componentId + "') As A join worker B on A.worker_id = B.worker_id join component C on A.component_id = C.component_id join `procedure` D on A.procedure_id = D.procedure_id join `batch` E on A.batch_id = E.batch_id";
            } else {              //加上batchName的筛选条件
                sql = "select E.batch_name,D.name,D.factor,B.name,A.passed_num,A.failed_num,A.time from (SELECT worker_id,component_id,batch_id,procedure_id,failed_num,passed_num,time FROM produce_work WHERE component_id='"+ componentId + "'and batch_id in (select batch_id from batch where batch_name='"+batchName+"')) As A join worker B on A.worker_id = B.worker_id join component C on A.component_id = C.component_id join `procedure` D on A.procedure_id = D.procedure_id join `batch` E on A.batch_id = E.batch_id";
            }
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
          
            while (rs.next()) {
                Component component = new Component();
                Procedure procedure = new Procedure();
                Worker worker = new Worker();
                
                component.setBatchName(rs.getString(1));
                procedure.setProcedureName(rs.getString(2));
                procedure.setFactor(rs.getFloat(3));
                worker.setWorkerName(rs.getString(4));
                
                ProducedProcedure producedProcedure = new ProducedProcedure();
                producedProcedure.setComponent(component);
                producedProcedure.setProcedure(procedure);
                producedProcedure.setOperator(worker);
                producedProcedure.setPassedNum(rs.getInt(5));
                producedProcedure.setFailedNum(rs.getInt(6));
                producedProcedure.setDate(rs.getDate(7));
                
                works.add(producedProcedure);
            }
          
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        
        return works;
    }

    public List<String> getComponentIds() {
        List<String> ids = new ArrayList<String>();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select component_id from component";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                ids.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return ids;
    }

    public Component getComponent(String componentId) {
        Component component = new Component();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select name,material,size,manufacturer from component where component_id = '" + componentId+"'";
            statement = connection.prepareStatement(sql);
           
            rs = statement.executeQuery();
           
            if (rs.next()) {
                component.setName(rs.getString(1));
                component.setMaterial(rs.getString(2));
                component.setSize(rs.getString(3));
                component.setManufacturer(rs.getString(4));
            }
            //return (user_from_db!=null && user_from_db.getPassword().equals(user.getPassword()) && user_from_db.getRole()==user.getRole()); 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return component;
    }

    public List<String> getProcedureNames(String componentId) {
        List<String> procedureNames = new ArrayList<String>();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select name from `procedure` where procedure_id in (select procedure_id from component_procedure where component_id = '"+ componentId + "')";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
           
            while (rs.next()) {
               procedureNames.add(rs.getString(1));
            }
            //return (user_from_db!=null && user_from_db.getPassword().equals(user.getPassword()) && user_from_db.getRole()==user.getRole()); 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return procedureNames;
    }

    public List<String> getWorkerNames() {
        List<String> names = new ArrayList<String>();
        
           PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select name from worker";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
           
            while (rs.next()) {
               names.add(rs.getString(1));
            }
            //return (user_from_db!=null && user_from_db.getPassword().equals(user.getPassword()) && user_from_db.getRole()==user.getRole()); 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        
        return names;
    }

    public float getProcedureFactor(String procedureName) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select factor from `procedure` where name = '" + procedureName + "'";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
           
            if (rs.next()) {
               return rs.getFloat(1);
            }
            //return (user_from_db!=null && user_from_db.getPassword().equals(user.getPassword()) && user_from_db.getRole()==user.getRole()); 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return 0;
    }
    
    public int getWorkerId(String name) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select worker_id from `worker` where name = '" + name + "'";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
           
            if (rs.next()) {
               return rs.getInt(1);
            }
            //return (user_from_db!=null && user_from_db.getPassword().equals(user.getPassword()) && user_from_db.getRole()==user.getRole()); 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return -1;
    }
    
     private String getProcedureId(String procedureName) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select procedure_id from `procedure` where name = '" + procedureName + "'";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
               return rs.getString(1);
            }
            //return (user_from_db!=null && user_from_db.getPassword().equals(user.getPassword()) && user_from_db.getRole()==user.getRole()); 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return "-1";
    }
    
    public boolean putProducedProcedure(ProducedProcedure producedProcedure) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        int workerId = getWorkerId(producedProcedure.getOperator().getWorkerName());
        if(workerId==-1) {
            return false;
        }
        String procedureId = getProcedureId(producedProcedure.getProcedure().getProcedureName());
        if(procedureId.equals("-1")) {
            return false;
        }
        
        Component component = producedProcedure.getComponent();
        int batchId = this.getBatchId(component.getBatchName());     
        if(batchId==-1) {            //if not exists this batch
            batchId=this.putBatch(component.getBatchName());               //store this batch
            if(batchId==-1) {
                return false;
            }
        }
        
        this.putBatchComponent(batchId ,component.getComponentId());    //store the batch_component
        
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "insert into produce_work (worker_id,component_id,batch_id,procedure_id,passed_num,failed_num,time) values (?,?,?,?,?,?,?)";
            
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, workerId);
            statement.setString(2, component.getComponentId());
            statement.setInt(3, batchId);
            statement.setString(4, procedureId);
            statement.setInt(5, producedProcedure.getPassedNum());
            statement.setInt(6, producedProcedure.getFailedNum());
            statement.setDate(7,new Date(producedProcedure.getDate().getTime()));
            statement.executeUpdate();
            System.out.println("insert produce_work success");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return true;
    }

    private int getBatchId(String batchName) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select batch_id from batch where batch_name = '" + batchName +"'";
            statement = connection.prepareStatement(sql);
           
            rs = statement.executeQuery();
           
            if (rs.next()) {
               return rs.getInt(1);
            }
          
        } catch (SQLException e) {
            return -1;
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return -1;
    }

    private int putBatch(String batchName) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "insert into batch(batch_name) values (?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, batchName);
            statement.executeUpdate();
            
            sql="select batch_id from batch ORDER BY batch_id DESC LIMIT 1";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            if(rs.next()) {
                return rs.getInt("batch_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return -1;
    }

    private void putBatchComponent(int batchId, String componentId) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "insert into batch_component(batch_id,component_id) values (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, batchId);
            statement.setString(2, componentId);
            statement.executeUpdate();
            System.out.println("insert batch_component success");
        } catch (SQLException e) {
           // throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
    }

    public boolean deleteProduceWork(ProducedProcedure producedProcedure) {
       String componentId = producedProcedure.getComponent().getComponentId();
       String batchName = producedProcedure.getComponent().getBatchName();
       String procedureName = producedProcedure.getProcedure().getProcedureName();
       String workerName = producedProcedure.getOperator().getWorkerName();
       java.util.Date date = producedProcedure.getDate();
       
       int batchId = this.getBatchId(batchName);
       String procedureId = this.getProcedureId(procedureName);
       int workerId = this.getWorkerId(workerName);
       
       
   //    System.out.println(batchName + " " + procedureName + " " + workerName + " " + date);
       
       PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "delete from produce_work where worker_id = " + workerId + " and component_id = '" +componentId + "' and batch_id = " + batchId + " and procedure_id= '" + procedureId + "' and time='" + date+"'";
            statement = connection.prepareStatement(sql);
            System.out.println(sql);
            statement.executeUpdate();
           // System.out.println("insert batch_component success");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return false;
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
       return true;
    }
    
    public List<WorkLoad> getWorkLoad() {
        List<WorkLoad> workerWorkLoads = new ArrayList<WorkLoad>();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
         //   String sql = "select W.name , P.name,A.sumup from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work` where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id";
          //  String sql = "select B.name , sum(B.work_load) from (select W.name , P.factor*A.sumup work_load from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work`   where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
          //  String sql = "select B.name worker_name , sum(B.work_load) valid_work, sum(B.all_sum) work_amount from (select W.name , P.factor*A.pass_num work_load , (A.fail_sum+A.pass_num) all_sum from (SELECT worker_id,procedure_id,sum(passed_num) pass_num,sum(failed_num) fail_sum FROM `produce_work` where time >= '" + minTime + "' and time < '"+ maxTime + "'  GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
            String sql = "select B.name worker_name , sum(B.work_load) valid_work, sum(B.all_sum) work_amount from (select W.name , P.factor*A.pass_num work_load , (A.fail_sum+A.pass_num) all_sum from (SELECT worker_id,procedure_id,sum(passed_num) pass_num,sum(failed_num) fail_sum FROM `produce_work` GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
            
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
           
            while (rs.next()) {
               WorkLoad workLoad = new WorkLoad();
               workLoad.setName(rs.getString("worker_name"));
               workLoad.setWorkLoad(rs.getFloat("valid_work"));
               workLoad.setAvgWorkLoad(workLoad.getWorkLoad()/rs.getInt("work_amount"));
               workerWorkLoads.add(workLoad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return workerWorkLoads; 
}

    public List<WorkLoad> getWorkerWorkLoad(int year, int month) {
        List<WorkLoad> workerWorkLoads = new ArrayList<WorkLoad>();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            
            String minTime = String.valueOf(year) + "-" + String.valueOf(month) + "-01";
            String maxTime = String.valueOf(year) + "-" + String.valueOf(month+1) + "-01";
            
         //   String sql = "select W.name , P.name,A.sumup from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work` where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id";
          //  String sql = "select B.name , sum(B.work_load) from (select W.name , P.factor*A.sumup work_load from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work`   where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
            String sql = "select B.name worker_name , sum(B.work_load) valid_work, sum(B.all_sum) work_amount from (select W.name , P.factor*A.pass_num work_load , (A.fail_sum+A.pass_num) all_sum from (SELECT worker_id,procedure_id,sum(passed_num) pass_num,sum(failed_num) fail_sum FROM `produce_work` where time >= '" + minTime + "' and time < '"+ maxTime + "'  GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
           
            rs = statement.executeQuery();
           
            while (rs.next()) {
               WorkLoad workLoad = new WorkLoad();
               workLoad.setName(rs.getString("worker_name"));
               workLoad.setWorkLoad(rs.getFloat("valid_work"));
               workLoad.setAvgWorkLoad(workLoad.getWorkLoad()/rs.getInt("work_amount"));
               workerWorkLoads.add(workLoad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return workerWorkLoads;
    }
    
    public List<WorkLoad> getWorkerWorkLoad(String startTimeString, String endTimeString) {
         List<WorkLoad> workerWorkLoads = new ArrayList<WorkLoad>();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            //   String sql = "select W.name , P.name,A.sumup from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work` where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id";
            //  String sql = "select B.name , sum(B.work_load) from (select W.name , P.factor*A.sumup work_load from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work`   where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
            String sql = "select B.name worker_name , sum(B.work_load) valid_work, sum(B.all_sum) work_amount from (select W.name , P.factor*A.pass_num work_load , (A.fail_sum+A.pass_num) all_sum from (SELECT worker_id,procedure_id,sum(passed_num) pass_num,sum(failed_num) fail_sum FROM `produce_work` where time >= '" + startTimeString + "' and time <= '"+ endTimeString + "'  GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
           
            rs = statement.executeQuery();
           
            while (rs.next()) {
               WorkLoad workLoad = new WorkLoad();
               workLoad.setName(rs.getString("worker_name"));
               workLoad.setWorkLoad(rs.getFloat("valid_work"));
               workLoad.setAvgWorkLoad(workLoad.getWorkLoad()/rs.getInt("work_amount"));
               workerWorkLoads.add(workLoad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return workerWorkLoads;
    }
    
    public List<WorkLoad> getGroupWorkLoad(String startDateString, String endDateString) {
         List<WorkLoad> workerWorkLoads = new ArrayList<WorkLoad>();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            //   String sql = "select W.name , P.name,A.sumup from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work` where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id";
            //  String sql = "select B.name , sum(B.work_load) from (select W.name , P.factor*A.sumup work_load from (SELECT worker_id,procedure_id,sum(passed_num) sumup FROM `produce_work`   where time >= '" + minTime + "' and time < '"+ maxTime + "' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
           // String sql = "select B.name worker_name , sum(B.work_load) valid_work, sum(B.all_sum) work_amount from (select W.name , P.factor*A.pass_num work_load , (A.fail_sum+A.pass_num) all_sum from (SELECT worker_id,procedure_id,sum(passed_num) pass_num,sum(failed_num) fail_sum FROM `produce_work` where time >= '" + startDateString + "' and time <= '"+ endDateString + "'  GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by name";
            
            String sql = "select name , sum(valid_work) valid_work, sum(work_amount) work_amount from (select B.worker_id worker_id , sum(B.work_load) valid_work, sum(B.all_sum)  work_amount, B.group_id group_id  from (select W.worker_id , P.factor*A.pass_num work_load , (A.fail_sum+A.pass_num) all_sum , W.group_id ,W.name from (SELECT worker_id,procedure_id,sum(passed_num) pass_num,sum(failed_num) fail_sum FROM `produce_work` where time>'"+startDateString+"' and time<'"+endDateString+"' GROUP BY worker_id , procedure_id) as A join worker W on A.worker_id = W.worker_id join `procedure` P on A.procedure_id = P.procedure_id) As B group by worker_id) as T join `group` as G on T.group_id=G.group_id group by name";
            
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
           
            rs = statement.executeQuery();
           
            while (rs.next()) {
               WorkLoad workLoad = new WorkLoad();
               workLoad.setName(rs.getString("name"));
               workLoad.setWorkLoad(rs.getFloat("valid_work"));
               workLoad.setAvgWorkLoad(workLoad.getWorkLoad()/rs.getInt("work_amount"));
               workerWorkLoads.add(workLoad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return workerWorkLoads;
    }
    
    public List<String> getCompoentBatchIds(String componentName) {
        List<String> batchIdList = new ArrayList<String>();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select batch_name from batch where batch_id in (select batch_id from batch_component where component_id = '"+componentName+"')";
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
           rs = statement.executeQuery();
            while (rs.next()) {
               batchIdList.add(rs.getString("batch_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(rs, statement);
        }
        return batchIdList;
    }
    
    public boolean executeUpdate(String sql) {
         boolean success = false;
         PreparedStatement statement = null;
         Connection connection = null;
          try {
            connection = DBManager.getDBManager().getConnection();
            statement=connection.prepareStatement(sql);
            success = statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.getDBManager().close(statement);
        }
        return success;
    }
    
     public String getNextWorkerId() {
        return "";
    }
     
     public List<Worker> getWorkers() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Map<String, Integer> getGroups() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public static void main(String [] args) {
        ComponentDao componentDao = ComponentDao.getInstance();
        componentDao.getWorkerWorkLoad(2012,10);
    }

   

   

    
}
