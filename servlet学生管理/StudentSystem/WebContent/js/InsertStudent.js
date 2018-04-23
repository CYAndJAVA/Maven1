
	function insertStudent(){
		var flag = window.confirm("确定添加学生吗");
		if(flag){
			var path = document.getElementById("path").value;
			window.location = path + "/stu/insertView";
		}
	}
	

	
	
	
	
	
	