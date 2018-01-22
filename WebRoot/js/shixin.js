/**
 * 获取项目路径
 */	
var path_prj = $("#path_prj").val();
/**
 * 刚进页面获取验证码图片
 */
$.ajax({
	url : path_prj+"/ShiXinController/image.do",
	type : "post",
	dataType : "json",
	success : function(result){
		$("#pimg").attr("src","img/1.png?t="+Math.random());
		$("#captchaId").val(result.captchaId);
	}
})

/**
 * 点击图片刷新验证码
 */
$("#pimg").click(function(){
	refreshCaptchaImg();
})

/**
 * 刷新验证码方法
 */
function refreshCaptchaImg(){
	$.ajax({
		url : path_prj+"/ShiXinController/newImage.do",
		data : {"captchaId":$("#captchaId").val()},
		type : "post",
		dataType : "json",
		success : function(result){
			$("#pimg").attr("src","img/1.png?t="+Math.random());
		}
	})
}

/**
 * 爬取失信人列表
 */
$("#queryShixin").click(function(){
	var pname = $.trim($('#pname').val());
	if(pname == ''){
		alert("请填写被执行人姓名/名称");
		return;
	}else if(pname.length < 2){
        alert("被执行人姓名/名称需要至少输入2个汉字");
        return;
    }
	var pcode = $.trim($('#pcode').val());
	if(pcode == ''){
		alert("请输入验证码");
		return;
	}
	var formDatas = $("#queryDatas").serialize();
	$.ajax({
		url : path_prj+"/ShiXinController/shixinInfos.do",
		type : "post",
		data :  formDatas,
		dataType : "json",
		success : function(result){
			if(result.err && result.err == "error"){
				alert("验证码错误或验证码已过期，请重新输入！");
				refreshCaptchaImg();
				return;
			}
			var str = "";
			var dataList = result.dataList;
			for(var i=0; i<dataList.length; i++){
				str += "<tr><td align='center'>"+(i+1)+"</td>";
				str += "<td>"+dataList[i].iname+"</td>";
				str += "<td>"+dataList[i].publishDate+"</td>";
				str += "<td>"+dataList[i].caseCode+"</td>";
				str += "<td align='center'><a id="+dataList[i].id+" onClick='queryShixinDetail(this)'>查看</a></td></tr>";
			 
			}
			$("#result").empty();
			$("#result").append(str);
			var pageStr = getPageStr(result);
			$("#pageTool").remove();
			$("#dataList").append(pageStr);
		}
	})
});

/**
 * 查看失信人详细信息
 */
function queryShixinDetail($this){
	var pcode = $("#pcode").val();
	var captchaId = $("#captchaId").val();
	var id = $($this).attr("id");
	$.ajax({
		url : path_prj+"/ShiXinController/shixinDetail.do",
		type : "post",
		data : {"id":id,"pcode":pcode,"captchaId":captchaId},
		dataType : "json",
		success : function(data){
			if(data.id=='undefined' || data.id == "" || data.id==null){				
				alert("验证码已过期，请重新查询");
				refreshCaptchaImg();
				return;
			}
			$('#inameDetail').text(data.iname);
			$('#cardNumDetail').text(data.cardNum);
			$('#courtNameDetail').text(data.courtName);
			$('#areaNameDetail').text(data.areaName);
            $('#gistIdDetail').text(data.gistId);
            $('#regDateDetail').text(data.regDate);
            $('#caseCodeDetail').text(data.caseCode);
            $('#gistUnitDetail').text(data.gistUnit);
            $('#dutyDetail').text(data.duty);
            $('#performanceDetail').text(data.performance);
            $('#disruptTypeNameDetail').text(data.disruptTypeName);
            $('#publishDateDetail').text(data.publishDate);

            if(data.partyTypeName == '580'){
                $('#sexDetail').text(data.sexy);
                $('#ageDetail').text(data.age);
                $('#partyDetail').find('tr[type="person"]').show();
                $('#partyDetail').find('tr[type="unit"]').hide();
            }
            else if(data.partyTypeName == '581'){

                $('#businessEntityDetail').text(data.businessEntity);
                $('#partyDetail').find('tr[type="person"]').hide();
                $('#partyDetail').find('tr[type="unit"]').show();
            }

            if('部分未履行' == data.performance){
                $('#performedPartDetail').text(data.performedPart);
                $('#unperformPartDetail').text(data.unperformPart);
                $('#performedInfo').show();
            }else{
                $('#performedInfo').hide();
            }

			$("#ResultView").fadeIn(500);
			$("#ResultView").css("left", "300px");
            $("#ResultView").css("top", "-480px");
						
		}
	})
}

/**
 * 关闭详情页
 */
$("#CloseResultView").click(function() {

    $("#ResultView").fadeOut(500);
});

/**
 * 返回拼接好的分页条字符串
 */
function getPageStr(result){

	var currentPage = parseInt(result.currentPage);
	var totalPage = parseInt(result.totalPage);
	var totalSize = parseInt(result.totalSize);

	$("#totalPage").val(totalPage);

	var str = "";

	if(currentPage == "1" && totalPage == "1"){
		str += "<div align='right' id='pageTool'><strong>首页&nbsp;</strong><strong>上一页&nbsp;</strong><strong>下一页&nbsp;</strong><strong>尾页&nbsp;</strong>";
		str += "<button type='button' class='btn' onClick='jumpTo()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp; 1/1 &nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";
	}
	else if(currentPage == "1" && totalPage != "1"){
		str += "<div align='right' id='pageTool'><strong>首页&nbsp;</strong><strong>上一页&nbsp;</strong>";
		str += "<a href='javascript:void(0);' onclick='gotoPage("+(currentPage+1)+")'><strong>下一页&nbsp;</strong></a>";
		str += "<a href='javascript:void(0);' onclick='gotoPage("+totalPage+")'><strong>尾页&nbsp;</strong></a>";
		str += "<button type='button' class='btn' onClick='jumpTo()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp;"+currentPage+"/"+totalPage+"&nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";
	}
	else if(currentPage == totalPage){
		str += "<div align='right' id='pageTool'><a href='javascript:void(0);' onclick='gotoPage(1)'><strong>首页&nbsp;</strong></a><a href='javascript:void(0);' onclick='gotoPage("+(currentPage-1)+")'><strong>上一页&nbsp;</strong></a>";
		str += "<strong>下一页&nbsp;</strong><strong>尾页&nbsp;</strong>";
		str += "<button type='button' class='btn' onClick='jumpTo()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp;"+currentPage+"/"+totalPage+"&nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";

	}
	else{
		str += "<div align='right' id='pageTool'><a href='javascript:void(0);' onclick='gotoPage(1)'><strong>首页&nbsp;</strong></a><a href='javascript:void(0);' onclick='gotoPage("+(currentPage-1)+")'><strong>上一页&nbsp;</strong></a>";
		str += "<a href='javascript:void(0);' onclick='gotoPage("+(currentPage+1)+")'><strong>下一页&nbsp;</strong></a>";
		str += "<a href='javascript:void(0);' onclick='gotoPage("+totalPage+")'><strong>尾页&nbsp;</strong></a>";
		str += "<button type='button' class='btn' onClick='jumpTo()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp;"+currentPage+"/"+totalPage+"&nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";
	}

	return str;

}

function gotoPage(currentPage){
	$("#currentPage").val(currentPage);
	var formDatas = $("#queryDatas").serialize();
	$.ajax({
		url : path_prj+"/ShiXinController/shixinInfosByPage.do",
		type : "post",
		data :  formDatas,
		dataType : "json",
		success : function(result){
			if(result.err && result.err == "error"){
				alert("验证码错误或验证码已过期，请重新输入！");
				refreshCaptchaImg();
				return;
			}
			var str = "";
			var dataList = result.dataList;
			for(var i=0; i<dataList.length; i++){
				str += "<tr><td align='center'>"+(i+1)+"</td>";
				str += "<td>"+dataList[i].iname+"</td>";
				str += "<td>"+dataList[i].publishDate+"</td>";
				str += "<td>"+dataList[i].caseCode+"</td>";
				str += "<td align='center'><a id="+dataList[i].id+" onClick='queryShixinDetail(this)'>查看</a></td></tr>";
			 
			}
			$("#result").empty();
			$("#result").append(str);
			var pageStr = getPageStr(result);
			$("#pageTool").remove();
			$("#dataList").append(pageStr);
		}
	})
}

/**
 * 跳转多少页
 */	
function jumpTo(){

	var jumpPage = $("#pagenum").val();
	var totalPage = $("#totalPage").val();
	if(jumpPage == ""){
		alert("请输入跳转页数！");
		return ;
	}
	if(parseInt(jumpPage) > parseInt(totalPage)){

		alert("跳转页面不能大于总页数");
		$("#pagenum").val("");
		return ;
	}
	else{
		gotoPage(jumpPage);
	}

}

/****************以下为本地数据库查询相关方法********************************/
/**
 * 本地数据库获取失信人列表
 */
$("#queryShixinLocal").click(function(){
	var pname = $.trim($('#pname').val());
	if(pname == ''){
		alert("请填写被执行人姓名/名称");
		return;
	}else if(pname.length < 2){
        alert("被执行人姓名/名称需要至少输入2个汉字");
        return;
    }
    $("#currentPage").val(1);
	var formDatas = $("#queryDatas").serialize();
	$.ajax({
		url : path_prj+"/ShiXinController/shixinInfosLocal.do",
		type : "post",
		data :  formDatas,
		dataType : "json",
		success : function(result){

			var str = "";
			var dataList = result.dataList;
			for(var i=0; i<dataList.length; i++){
				str += "<tr><td align='center'>"+(i+1)+"</td>";
				str += "<td>"+dataList[i].iname+"</td>";
				str += "<td>"+dataList[i].regDate+"</td>";
				str += "<td>"+dataList[i].caseCode+"</td>";
				str += "<td align='center'><a id="+dataList[i].did+" onClick='queryShixinDetail(this)'>查看</a></td></tr>";
			 
			}
			$("#result").empty();
			$("#result").append(str);
			var pageStr = getPageStrLocal(result);
			$("#pageTool").remove();
			$("#dataList").append(pageStr);
		}
	})
});

function getPageStrLocal(result){

	var currentPage = parseInt(result.currentPage);
	var totalPage = parseInt(result.totalPage);
	var totalSize = parseInt(result.totalSize);
	$("#totalPage").val(totalPage);

	var str = "";

	if(currentPage == "1" && totalPage == "1"){
		str += "<div align='right' id='pageTool'><strong>首页&nbsp;</strong><strong>上一页&nbsp;</strong><strong>下一页&nbsp;</strong><strong>尾页&nbsp;</strong>";
		str += "<button type='button' class='btn' onClick='jumpToLocal()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp; 1/1 &nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";
	}
	else if(currentPage == "1" && totalPage != "1"){
		str += "<div align='right' id='pageTool'><strong>首页&nbsp;</strong><strong>上一页&nbsp;</strong>";
		str += "<a href='javascript:void(0);' onclick='gotoPageLocal("+(currentPage+1)+")'><strong>下一页&nbsp;</strong></a>";
		str += "<a href='javascript:void(0);' onclick='gotoPageLocal("+totalPage+")'><strong>尾页&nbsp;</strong></a>";
		str += "<button type='button' class='btn' onClick='jumpToLocal()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp;"+currentPage+"/"+totalPage+"&nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";
	}
	else if(currentPage == totalPage){
		str += "<div align='right' id='pageTool'><a href='javascript:void(0);' onclick='gotoPageLocal(1)'><strong>首页&nbsp;</strong></a><a href='javascript:void(0);' onclick='gotoPageLocal("+(currentPage-1)+")'><strong>上一页&nbsp;</strong></a>";
		str += "<strong>下一页&nbsp;</strong><strong>尾页&nbsp;</strong>";
		str += "<button type='button' class='btn' onClick='jumpToLocal()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp;"+currentPage+"/"+totalPage+"&nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";

	}
	else{
		str += "<div align='right' id='pageTool'><a href='javascript:void(0);' onclick='gotoPageLocal(1)'><strong>首页&nbsp;</strong></a><a href='javascript:void(0);' onclick='gotoPageLocal("+(currentPage-1)+")'><strong>上一页&nbsp;</strong></a>";
		str += "<a href='javascript:void(0);' onclick='gotoPageLocal("+(currentPage+1)+")'><strong>下一页&nbsp;</strong></a>";
		str += "<a href='javascript:void(0);' onclick='gotoPageLocal("+totalPage+")'><strong>尾页&nbsp;</strong></a>";
		str += "<button type='button' class='btn' onClick='jumpToLocal()'>跳转</button>&nbsp;<input id='pagenum' size='4' maxlength='6' type='text'/>&nbsp;页";
		str += "<strong>&nbsp;"+currentPage+"/"+totalPage+"&nbsp; 共&nbsp;"+totalSize+"&nbsp;条</strong></div>";
	}

	return str;
}

function gotoPageLocal(currentPage){
	$("#currentPage").val(currentPage);
	var formDatas = $("#queryDatas").serialize();
	$.ajax({
		url : path_prj+"/ShiXinController/shixinInfosLocal.do",
		type : "post",
		data :  formDatas,
		dataType : "json",
		success : function(result){

			var str = "";
			var dataList = result.dataList;
			for(var i=0; i<dataList.length; i++){
				str += "<tr><td align='center'>"+(i+1)+"</td>";
				str += "<td>"+dataList[i].iname+"</td>";
				str += "<td>"+dataList[i].regDate+"</td>";
				str += "<td>"+dataList[i].caseCode+"</td>";
				str += "<td align='center'><a id="+dataList[i].did+" onClick='queryShixinDetail(this)'>查看</a></td></tr>";			 
			}
			$("#result").empty();
			$("#result").append(str);
			var pageStr = getPageStrLocal(result);
			$("#pageTool").remove();
			$("#dataList").append(pageStr);
		}
	})
}

function jumpToLocal(){
	var jumpPage = $("#pagenum").val();
	var totalPage = $("#totalPage").val();
	if(jumpPage == ""){
		alert("请输入跳转页数！");
		return ;
	}
	if(parseInt(jumpPage) > parseInt(totalPage)){

		alert("跳转页面不能大于总页数");
		$("#pagenum").val("");
		return ;
	}
	else{
		gotoPageLocal(jumpPage);
	}
}