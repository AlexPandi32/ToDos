<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Calender</title>
<style>

.button1 {background-color: blue;color: white; width:70px;height:32px;margin-right:10px}
.button2 {background-color: red;color: white;width:70px;height:32px;margin-right:10px}
.button-calender{font-size:32 ;background-color: orange;color: white;}
.button3{color: white;background-color: white ;width:70px;height:32px;margin-right:10px}
.head{text-align:center}
</style>
</head>
<body> 

 <s:set name="spaces" value="emptyDays" scope="session"/> 
 <s:set name="no-days" value="totalday" scope="session" />
 <s:set name="counter" value="0"    />
 <a href="calender.action?date=<s:property value="todaydate"/>">
	<h2><s:date name="todaydate" format="dd/MMMMM/YYYY-EEEE " /></h2></a>
       <div class="head" >
                   <a href="calender.action?subyear=<s:property value="date"/>"><button class="button-calender" type="button"><<</button></a>
                   <a href="calender.action?submonth=<s:property value="date"/>"><button class="button-calender" type="button"><</button></a>
				   <span style="color:blue;font-size:36 "> <s:date name="date" format="MMMM" />-<s:date name="date" format="yyyy" /></span>
				    <a href="calender.action?addmonth=<s:property value="date"/>"><button class="button-calender" type="button">></button></a>
				    <a href="calender.action?addyear=<s:property value="date"/>"><button class="button-calender" type="button">>></button></a>
		</div>	
			
			
			<table style="margin-left:25%" cellspacing="36" cellpadding="7" >	 
		         <tr style="background-color: #E0E0E1;">
						<th>SUN</th>
						<th>MON</th>
						<th>TUE</th>
						<th>WED</th>
						<th>THU</th>
						<th>FRI</th>
						<th>SAT</th>
					</tr>
					</table>
	<div style="text-align:center">
				<s:iterator status="stat1" value="(#session['spaces']).{#this}" >
				    <button class="button3"  type="button">" "</button>
				    <s:set name="counter" value="#counter+1"  />
				  </s:iterator>
 			<s:iterator status="stat" value="(#session['no-days']).{#this}">
				<s:set name="color" value="button2" scope="session" />
				<s:set name="counter" value="#counter+1"  />
				<s:if test="taskDate.contains(#stat.count)">
				 <s:set name="color" value="button1" scope="session" />
                <a  href="tasks.action?dayofmonth=<s:property value="#stat.count"/>&date=<s:property value="date"/>" >
				<button  class=button1 type="button"><s:property value="#stat.count"/>
				</button></a>
				</s:if>
				<s:else> 
				
				<a  href="tasks.action?dayofmonth=<s:property value="#stat.count"/>&date=<s:property value="date"/>" >
				<button class=button2 type="button"><s:property value="#stat.count"/></button></a>
				</s:else>
				<s:if test="#counter%7 == 0">
				     </br>
				     </br>
				 </s:if>
				</s:iterator>
				<s:if test="#counter%7!=0">
				<s:iterator status="st" value="(7-#counter%7).{#this}">
				  <button class="button3"   type="button">" "</button>
				</s:iterator>
				</s:if>
	</div>
	
</body>
</html>