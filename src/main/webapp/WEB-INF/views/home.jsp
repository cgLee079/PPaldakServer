<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%> 

<html>
<head>
	<title>Home</title>
</head>
<style>
table tr td{
	padding : 5px 30px;

}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	 function login(){
		var form = $("<form>", {  action : "login", method : "POST" });
		
		$("<input>", { 	type : "hidden", name : "id", value: "jihe" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "pwd", value: "1" }).appendTo(form);
		
		form.appendTo($("body"));
		form.submit();
	 }
	 
	 function join(){
		var form = $("<form>", {
			action : "join",
			method : "POST"
		});
		
		$("<input>", { 	type : "hidden", name : "id", value: "jihe2" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "pwd",  value: "1" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "name", 	value: "찬구2" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "gender", 	value: "M" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "birth", 	value: "1992/08/26" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "ph", 	value: "010-2062-2979" }).appendTo(form);
		
		form.appendTo($("body"));
		form.submit();
	}
 
 
 	function modify(){
		var form = $("<form>", {
			action : "join",
			method : "POST"
		});
		
		$("<input>", { 	type : "hidden", name : "id", value: "jihe2" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "pwd",  value: "1" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "name", 	value: "찬구2" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "gender", 	value: "M" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "birth", 	value: "1992/08/26" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "ph", 	value: "010-2062-2979" }).appendTo(form);
		$("<input>", { 	type : "hidden", name : "modify", 	value: "true" }).appendTo(form);
		
		form.appendTo($("body"));
		form.submit();
	}
 	
 	function saveFish(){
 		var form = $("<form>", { action : "saveFish", method : "POST" }); 
		$("<input>", { 	type : "hidden", name : "id", value: "cksrn2979_20170520041123"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "name", value: "서래섬에서2"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "species", value: "장어"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "maxPower", value: "2.12"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "avgPower", value: "0.53"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "date", value: "2017/05/20"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "time", value: "04:11:13"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "timeing", value: "500"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "GPSLat", value: "37.00"}).appendTo(form);
		$("<input>", { 	type : "hidden", name : "GPSLot", value: "126.990"}).appendTo(form);
		
		form.appendTo($("body"));
		form.submit();
 	}
 	
 	function deleteFish(){
 		var form = $("<form>", { action : "deleteFish", method : "POST" }); 
		$("<input>", { 	type : "hidden", name : "id", value: "cksrn2979_20170520041123"}).appendTo(form);
		form.appendTo($("body"));
		form.submit();
 	}
 	
 	function selectMyFish(){
		var form = $("<form>", { action : "selectMyFish", method : "POST" }); 
		form.appendTo($("body"));
		form.submit();
	}
 	
 	function selectMyFishSearch(){
		var form = $("<form>", { action : "selectMyFish", method : "POST" }); 
		$("<input>", { 	type : "hidden", name : "search", value: "몸"}).appendTo(form);
		form.appendTo($("body"));
		form.submit();
	}
 	
 	function selectAllFish(){
 		var form = $("<form>", { action : "selectAllFish", method : "POST" }); 
		form.appendTo($("body"));
		form.submit();
 	}
 	
 	function selectAllFishDate(){
 		var form = $("<form>", { action : "selectAllFish", method : "POST" }); 
 		$("<input>", { 	type : "hidden", name : "stDate", value: "2017/01/01"}).appendTo(form);
 		$("<input>", { 	type : "hidden", name : "endDate", value: "2018/01/01"}).appendTo(form);
		form.appendTo($("body"));
		form.submit();
 	}
 	
 	function selectAllFishSpecies(){
 		var form = $("<form>", { action : "selectAllFish", method : "POST" }); 
 		$("<input>", { 	type : "hidden", name : "species", value: "장어"}).appendTo(form);
		form.appendTo($("body"));
		form.submit();
 	}

</script>
<body>
	<h1>User controller</h1>
	<table>
		<tr>
		<td>TEST1</td>
		<td>/login</td>
		<td><a href="javascript:void(0)" onclick="login()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST2</td>
		<td>/join - new user</td>
		<td><a href="javascript:void(0)" onclick="join()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST3</td>
		<td>/join - modify</td>
		<td><a href="javascript:void(0)" onclick="modify()">TEST</a></td>
		</tr>
		
	</table>
	
	
	<h1>Fish controller</h1>
	<table>
		<tr>
		<td>TEST1</td>
		<td>/saveFish</td>
		<td><a href="javascript:void(0)" onclick="saveFish()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST2</td>
		<td>/deleteFish</td>
		<td><a href="javascript:void(0)" onclick="deleteFish()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST3</td>
		<td>/selectMyFish</td>
		<td><a href="javascript:void(0)" onclick="selectMyFish()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST4</td>
		<td>/selectMyFish - search</td>
		<td><a href="javascript:void(0)" onclick="selectMyFishSearch()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST5</td>
		<td>/selectAllFish</td>
		<td><a href="javascript:void(0)" onclick="selectAllFish()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST5</td>
		<td>/selectAllFish - date</td>
		<td><a href="javascript:void(0)" onclick="selectAllFishDate()">TEST</a></td>
		</tr>
		
		<tr>
		<td>TEST6</td>
		<td>/selectAllFish - species</td>
		<td><a href="javascript:void(0)" onclick="selectAllFishSpecies()">TEST</a></td>
		</tr>
	</table>
</body>
</html>
