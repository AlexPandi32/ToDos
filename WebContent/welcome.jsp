<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>ToDo List APP</title>
<style type="text/css">
.head{text-align:center;color:black;height:40px;background-color:lightgray}
.box {
  margin: 0;
  position: absolute;
  top: 50%;
  left:45%;
  -ms-transform: translateY(-50%,-50%);
  transform: translateY(-50%,-50%);
}
</style>
	</head>
	<body>
		<h1 class="head">TODO LIST</h1>
		<div class="box">
		<a href="calender.action"><button class="head" type="button">Welcome to UR ToDo</button></a>
	    <s:date name="date" format="MM/dd/YYYY" />
	    </div>
	</body>
</html>
