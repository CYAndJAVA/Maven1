/*删除一项*/
var inp = document.getElementsByName("checkall")
        inp[0].onclick = function(){
                for(var i=1;i<inp.length;i++){
                    if(inp[0].checked==true){
                        inp[i].checked=true
                    }else{
                        inp[i].checked=false
                    }
                }
            }

/*删除多项*/
	function delmore(){
		var sids = "";
		for(var i = 0;i<inp.length;i++){
			if(inp[i].checked==true){
				sids += inp[i].value + ";";
			}
		}
		if(sids.trim().length==0){
			alert("请选择需要删除的学生!");
		}else{
			var flag = window.confirm("确认删除吗");
			if(flag){
				var path = document.getElementById("path").value;
				window.location = path + "/stu/deletemore?sids="+sids;
			}
		}
	}
	
	
	
	
	
	
	
	