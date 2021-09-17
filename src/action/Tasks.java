package action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

import dao.Db;

import com.opensymphony.xwork2.ActionSupport;
	public class Tasks extends ActionSupport {

		private static final long serialVersionUID = 1L;
		Calendar C=Calendar.getInstance();
		private int dayofmonth;
		private Date date;
		private String submitType="";
	    private Db db=new Db();
	    private  ResultSet rs;
		private int row;
		private String task;
	    private String task_new;
		private String msg;
		private List<String> taskList=null;
		

		@Override
		public String execute()  throws Exception{
	    	
			System.out.println();
	    	if(submitType.equals("Insert"))
	    	{     
	           row=db.Add(date,task);
	    	   
	    	}else if(submitType.equals(" Edit "))
	    	{
				row=db.Edit(date, task_new , task);
				
	    	}else if(submitType.equals("Delete"))
	    	{	    	
	    		row=db.Delete(date,task);
	    	} 
	    	
	        taskList = new ArrayList<String>();
	  			rs = db.Display(date);
	  			if (rs != null) {
	  				while (rs.next()) {
	  					
	  					taskList.add(rs.getString("TASK"));
	  				}
	  			}
	  			
	    	 			  return "success";
		}
		
		public List<String> getTaskList() {
			return taskList;
		}

		public String getTask_new() {
				return task_new;
			}
         public void setTask_new(String task_new) {
				this.task_new = task_new;
			}
		public void setDayofmonth(int dayofmonth) {
			C.set(Calendar.DATE, dayofmonth);
			this.date=C.getTime();
			}
		public Date getDate() {
			return date;
			
		}
		public void setDate(Date date) {
			C.setTime(date);
	        this.date=C.getTime();
		}
	    	
			public String getPageType() {
				return submitType;
			}
			public void setPageType(String submitType) {
				this.submitType = submitType;
			}
			public String getMsg() {
				return msg;
			}
			public String getTask() {
				return task;
			}

			public void setTask(String task) {
				this.task = task;
			}
			public String getSubmitType() {
					return submitType;
				}

				public void setSubmitType(String submitType) {
					this.submitType = submitType;
				}
		}
	

