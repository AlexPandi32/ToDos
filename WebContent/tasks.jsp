<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>ToDo List-TASKS</title>
		<s:head theme="ajax" debug="true" />
<style type="text/css">
.form{border:0;font-size:25px}
.button{ position: absolute;
  left:82%;
  height:30px;
}
.button-calender {background-color: blue;color: white;margin-left: 45%;height:30px}
.head{text-align:center;color:black;height:40px;background-color:lightgray}
</style>
	</head>
	<body>
		<h1 class="head"> UR 2DO's On <s:date name="date" format="dd/MMMM/YYYY-(EEEE)"/> are:</h1>
		<s:iterator  status="stat" value="taskList">
		<s:form cssClass="form" action="tasks" method="post">
		<s:checkbox name="status" label="status"  value="true" fieldValue="true"/>
		<s:textarea  cssClass="form" label=">>" name="task_new" value="%{taskList[#stat.count-1]}" cols="70" rows="1"/>
		<s:hidden name="task" value="%{taskList[#stat.count-1]}" />
		<s:hidden   name="date" value="%{date}" />
		<s:submit  name="submitType" value=" Edit " />
		<s:submit name="submitType" value="Delete"/>
		<!--  <a href="tasks.action?date=<s:property value="date"/>
		&task=<s:property value="taskList[#stat.count-1]"/>&submitType=Delete"> 
		<button class="button" type="button">Delete</button></a> -->
		</s:form>
		</s:iterator>
		
		<s:form action="tasks" method="post">
		<s:textarea label="Share With me I will Remind You:>>" name="task"  value="" cols="70" rows="1"/>
		<!--<s:datetimepicker name="time" type="time" label="time" displayFormat="hh-mm" /> -->
		<s:hidden   name="date" value="%{date}" />
		<s:submit  name="submitType" value="Insert" />
		</s:form>
		
	<a href="calender.action?date=<s:property value="date"/>">
	<button class="button-calender" type="button"><b>calendar</b></button></a>
	</body>
</html>
