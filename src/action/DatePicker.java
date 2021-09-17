package action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import java.sql.ResultSet;
import dao.Db;
public class DatePicker extends ActionSupport{

	private static final long serialVersionUID = 95833227412820750L;
    Calendar C=Calendar.getInstance();
    private Date todaydate=C.getTime();
    private Date date=C.getTime();
    private int totalday;
	private int emptyDays;
	private Db db=new Db();
    private ResultSet rs;
	private List<Integer> taskDate=new ArrayList<Integer>();
	

	@Override
	public String execute() throws Exception {
		  C.set(Calendar.DATE, 1);
		  Date temp1=C.getTime();
		  C.set(Calendar.DATE, C.getActualMaximum(Calendar.DATE));
		  Date temp2=C.getTime();
		  C.set(Calendar.DAY_OF_MONTH,1);
		  emptyDays=C.get(Calendar.DAY_OF_WEEK);
	      rs=db.getMonthTasks(temp1 , temp2);
	      if (rs != null) {
				while (rs.next()) {
					
					taskDate.add(Integer.parseInt(rs.getObject("DATE").toString().substring(8)));
				}
			}
		return "success";
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date d)
	{
		this.date=d;
		this.C.setTime(d);
       
	}
	
	public void setAddmonth(Date d)
	{
		  C.setTime(d);
		  C.add(Calendar.MONTH,1);
		  this.date=C.getTime();
	}
	public void setAddyear(Date d)
	{
		  C.setTime(d);
		  C.add(Calendar.YEAR,1);
		  this.date=C.getTime();
		  
	}
	public void setSubmonth(Date d)
	{
		  C.setTime(d);
		  C.add(Calendar.MONTH,-1);
		  this.date=C.getTime();
		  
	}
	public void setSubyear(Date d)
	{
		  C.setTime(d);
		  C.add(Calendar.YEAR,-1);
		  this.date=C.getTime();

	}
	 public int getTotalday() {
		
		 totalday=	C.getActualMaximum(Calendar.DATE);
		 return totalday;
			
	}
	 public List<Integer> getTaskDate() {
			return taskDate;
		}

	 public int getEmptyDays() {
			return emptyDays-1;
		}
	  
     public Date getTodaydate() {
		return todaydate;
	}

}
