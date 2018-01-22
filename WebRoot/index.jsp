<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="vander/css/bootstrap.min.css">
<link rel="stylesheet" href="vander/css/bootstrap-responsive.min.css">
<style type="text/css">

a,#queryShixin,#queryShixinLocal,img{
  cursor:pointer;
}

.table th, .table td { 
	text-align: center;
	vertical-align: middle!important;
}

#dataList{
	width : 1050px;
	margin-left : 58px;
}

#pageTool{
	height : 30px;
}
#pageTool strong{
	line-height : 30px;
	font-size : 15px;
}
#pageTool .btn{
	height : 27px;
	margin-top: -3px;
}
#pageTool #pagenum{
	width : 35px;
	height: 27px;
	margin-top: 7px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="topblank"><div class="topblanka"></div></div>
		<div>
			<h1>失信人信息查询</h1>
			<form action="" method="post" id="queryDatas">
				<span style="font : menu ; font-size: 18px;color:#336699;">被执行人姓名/名称：</span>
				<input type="text" placeholder="可仅填写姓名或名称的前部分,但需要两个以上汉字" style="height:40px;width:510px;margin-top:10px;" name="pname" id="pname" value="" onChange="refreshCaptchaImg();">
				<button style="height:40px;width:90px;" id="queryShixinLocal" class="btn" type="button">本地查询</button>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span style="font : menu ; font-size: 18px;color:#336699;">验证码：</span>
				<input type="text" placeholder="请输入验证码" style="height:40px;width:406px;margin-top:10px;" name="pcode" id="pcode">
				<img src="" alt="" style="height:40px;width:100px;" id="pimg">
				<button style="height:40px;width:90px;" id="queryShixin" class="btn" type="button">远程爬取</button>
				
				<input type="hidden" name="captchaId" id="captchaId">
				<input type="hidden" id="path_prj" value="${pageContext.request.contextPath}">
				<input type="hidden" id="currentPage" name="currentPage">
				<input type="hidden" id="totalPage">

			</form>

			<%-- 
            <input type="text" placeholder="请填写企业名称" style="height:40px;width:510px;margin-top:10px;" name="entName" id="entName" value="">
            <button style="height:40px;width:90px;" id="queryEntInfo" class="btn" type="button">查询</button>--%>
		</div>

		<!-- 查询结果 -->
        <div style="height: auto;margin-left: 30px;">
            <div style="position: relative;">
                <div class="t_middle_top_select_block" id="ResultView">
                    <div class="t_middle_top_select_block_top"></div>
                    <div class="t_middle_top_select_block_middle">
                        <table class="table table-bordered" id="partyDetail">
                            <tr>
                                <td height="25" width="200" align="right"><strong>被执行人姓名/名称：</strong><br /></td>
                                <td id="inameDetail"></td>
                            </tr>
                            <tr type="person">
                                <td height="25" align="right"><strong>性别：</strong></td>
                                <td id="sexDetail"></td>
                            </tr>
                            <tr type="person">
                                <td height="25" align="right"><strong>年龄：</strong></td>
                                <td id="ageDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>身份证号码/组织机构代码：</strong></td>
                                <td id="cardNumDetail"></td>
                            </tr>
                            <tr type="unit">
                                <td height="25" align="right"><strong>法定代表人或者负责人姓名：</strong></td>
                                <td id="businessEntityDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>执行法院：</strong></td>
                                <td id="courtNameDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>省份：</strong></td>
                                <td id="areaNameDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>执行依据文号：</strong></td>
                                <td id="gistIdDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>立案时间：</strong></td>
                                <td id="regDateDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>案号：</strong></td>
                                <td id="caseCodeDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>做出执行依据单位：</strong></td>
                                <td id="gistUnitDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>生效法律文书确定的义务：</strong></td>
                                <td id="dutyDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>被执行人的履行情况：</strong></td>
                                <td id="performanceDetail"></td>
                            </tr>

                            <tbody id="performedInfo">
                            <tr>
                                <td height="25" align="right"><strong>已履行：</strong></td>
                                <td id="performedPartDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>未履行：</strong></td>
                                <td id="unperformPartDetail"></td>
                            </tr>
                            </tbody>

                            <tr>
                                <td height="25" align="right"><strong>失信被执行人行为具体情形：</strong></td>
                                <td id="disruptTypeNameDetail"></td>
                            </tr>
                            <tr>
                                <td height="25" align="right"><strong>发布时间：</strong></td>
                                <td id="publishDateDetail"></td>
                            </tr>
							<!-- 	<tr> -->
							<!--  <td height="25" align="right"><strong>关注次数：</strong></td> -->
							<!-- <td id="focusNumberDetail"></td> -->
							<!-- </tr> -->
                        </table>
                        <div style="clear: both; text-align: center; padding-top: 6px;">
                            <button id="CloseResultView" type="button" class="btn">关闭</button>
                        </div>
                    </div>
                    <div class="t_middle_top_select_block_bottom"></div>
                </div>
            </div>
        </div>

        <div id="dataList">
			<table id="dataListTable" align="center" height="auto" class="table table-bordered table-striped">
				<thead>
					<th width="50">序号</th>
					<th nowrap="nowrap">被执行人姓名/名称</th>	
					<th width="120">立案时间</th>
					<th nowrap="nowrap">案号</th>				
					<th width="60">查看</th>
				</thead>
				<tbody id="result">
					<tr><td colspan="5">没有数据显示！</td></tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script  src="js/shixin.js"></script>
<script>
$("#queryEntInfo").click(function(){
    var entName = $("#entName").val();
    var path_prj = $("#path_prj").val();
    $.ajax({
        url : path_prj+"/EntInfoController/queryEntInfo.do",
        data : {"entName" : entName},
        type : "post",
        dataType : "json",
        success : function(result){
            
        }
    })
})
</script>
</html>