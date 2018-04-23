var path = document.getElementById("path").value
function deleteEm() {
	var cks = document.getElementsByName("cks");
	var ci = 0;
	var sids = "";
	for ( var i in cks) {
		if (cks[i].checked) {
			sids += cks[i].value + ";";
			ci++;
		}
	}
	if (ci == 0) {
		alert("请选择要删除的员工");
	} else {
		window.location = path + "/user/delem?sids="
				+ sids.substring(0, sids.length - 1);
	}
}
function updateEm() {
	var emid = document.getElementById("enumber").value;
	var name = document.getElementById("ename").value;
	var cgs = document.getElementsByName("cg");
	var gender = "";
	for ( var i in cgs) {
		if (cgs[i].checked) {
			gender = cgs[i].value;
		}
	}
	var sezhic = document.getElementById("sezhic").value;
	var ruzhitime = document.getElementById("rtime").value;
	var ephong = document.getElementById("ephong").value;
	window.location = path + "/user/updateContol?emid=" + emid + "&name="
			+ name + "&gender=" + gender + "&sezhic=" + sezhic + "&ruzhitime="
			+ ruzhitime + "&ephong=" + ephong;
}

function addNewEmploy() {
	var enumber = document.getElementById("enumbe1").value;
	var name = document.getElementById("ename1").value;
	var cgs = document.getElementsByName("cg1");
	var gender = "";
	for ( var i in cgs) {
		if (cgs[i].checked) {
			gender = cgs[i].value;
		}
	}
	var sezhic = document.getElementById("sezhic1").value;
	var ruzhitime = document.getElementById("rtime1").value;
	var ephong = document.getElementById("ephong1").value;
	window.location = path + "/user/addNewEmContol?enumber=" + enumber
			+ "&name=" + name + "&gender=" + gender + "&sezhic=" + sezhic
			+ "&ruzhitime=" + ruzhitime + "&ephong=" + ephong;

}

function checkEm(obj) {
	var buton = document.getElementById("sub");
	buton.disabled = true;
	var xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function() {
		if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			var s = xmlHttpRequest.responseText;
			if (s == 0) {
				alert("可用");
				buton.disabled = false;
			} else if (s == 1) {
				alert("不可用");
			} else {
				alert("请检查信息");
			}
		}
	}
	xmlHttpRequest.open("post", path + "/user/checkNumber", true);
	xmlHttpRequest.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	xmlHttpRequest.send("newNum=" + obj);
}

function toAddSaloryView(){
	var cks = document.getElementsByName("cks");
	var emn = "";
	var ci = 0;
	for ( var i in cks) {
		if (cks[i].checked) {
			emn=cks[i].value;
			ci++;
		}
	}
	if(ci == 1){
		window.location = path + "/user/toAdSalyView?nemn=" + emn;
	}else{
		alert("请勾选需要添加的员工（仅一人）");
		return;
	}
}

function addNewSalory(){
	var emnumbe = document.getElementById("oneNum").value;
	var satime = document.getElementById("satime").value;
	var saall = document.getElementById("saall").value;
	window.location = path + "/user/AdSalyContol?emnsa=" + emnumbe
	+"&satime="+satime+"&saall="+saall;
	
	
}
