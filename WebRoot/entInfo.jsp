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
	<div class="container" style="height: auto">
		<div class="topblank"><div class="topblanka"></div></div>
		<div>
			<h1>企业工商在线查询</h1>
            <span><strong style="font-size: 16px;">企业名称：</strong></span>
            <input type="text" placeholder="请填写企业名称" style="height:40px;width:810px;margin-top:10px;" name="entName" id="entName" value="">
            <input type="hidden" id="path_prj" value="${pageContext.request.contextPath}">
            <button style="height:40px;width:90px;" id="queryEntInfo" class="btn" type="button">查询</button>
		</div>

		<!-- 查询结果 企业基本信息-->
        <div class="tab-content" id="icinfoDiv">
            <h3 class="section-title margin-t-2x" style="text-align: left"><strong>工商信息</strong></h3>
            <span style="font-size: 16px;" id="tips">查询后展示数据！</span>
            <table class="table table1 table-bordered margin-t-1x" style="display:none" id="icinfo">
                <tbody>
                    <tr>
                        <td style="min-width: 150px">企业名称</td>
                        <td id="ent_name" style="min-width: 400px"></td>
                        <td style="min-width: 150px">统一社会信用代码</td>
                        <td id="creditCode" style="min-width: 400px"></td>
                    </tr>
                    <tr>
                        <td>工商注册号</td>
                        <td id="businessRegistNo"></td>
                        <td>组织机构代码</td>
                        <td id="organizationCode"></td>
                    </tr>
                    <tr>
                        <td>经营状态</td>
                        <td id="entStatus"></td>
                        <td>所属行业</td>
                        <td id="industry"></td>
                    </tr>
                    <tr>
                        <td>注册日期</td>
                        <td id="entRegistDate"></td>
                        <td>公司类型</td>
                        <td id="entType"></td>
                    </tr>
                    <tr>
                        <td>法定代表人</td>
                        <td id="entLegalPerson"></td>
                        <td>注册资本</td>
                        <td id="entRegistCapital"></td>
                    </tr>
                    <tr>
                        <td>营业期限自</td>
                        <td id="businessTermFrom"></td>
                        <td>营业期限至</td>
                        <td id="businessTermEnd"></td>
                    </tr>
                    <tr>
                        <td>核准日期</td>
                        <td id="approvalDate"></td>
                        <td>登记机关</td>
                        <td id="registAuthority"></td>
                    </tr>
                    <tr>
                        <td>企业地址</td>
                        <td id="entAddress"></td>
                        <td>注册地址</td>
                        <td id="registAddress"></td>
                    </tr>
                    <tr>
                        <td>企业电话</td>
                        <td id="entPhone"></td>
                        <td>企业邮箱</td>
                        <td id="entEmailAdress"></td>                       
                    </tr>
                    <tr>                       
                        <td>英文名</td>
                        <td id="entEngilshName"></td>
                        <td>纳税人识别号</td>
                        <td id="taxpayerIdentificationNo"></td>
                    </tr>
                    <tr>
                        <td>经营范围</td>
                        <td id="businessScope" colspan="3"></td>
                    </tr>
                </tbody>
            </table>
        </div>

        <!-- 股东出资信息 -->
        <div  class="tab-content" id="shareHolderInfosDiv">
            <h3 class="section-title margin-t-2x" style="text-align: left"><strong>股东出资信息</strong></h3>
            <table id="shareHolderInfosTable" class="table table-bordered margin-t-1x">
                <thead>
                    <th width="50">序号</th>
                    <th nowrap="nowrap">股东</th>   
                    <th width="120">认缴出资额(万元)</th>
                    <th nowrap="nowrap">认缴出资时间</th>              
                    <th width="60">认缴出资方式</th>
                    <th width="120">实缴出资额(万元)</th>
                    <th nowrap="nowrap">实缴出资时间</th>              
                    <th width="60">实缴出资方式</th>
                </thead>
                <tbody id="shareHolderInfos">
                    <tr><td colspan="8">没有数据显示！</td></tr>
                </tbody>
            </table>
        </div>

        <!-- 工商变更 -->
        <div  class="tab-content" id="changesDiv">
            <h3 class="section-title margin-t-2x" style="text-align: left"><strong>工商变更</strong></h3>
			<table id="changesTable" class="table table-bordered margin-t-1x">
				<thead>
					<th width="50">序号</th>
					<th nowrap="nowrap">变更事项</th>	
					<th width="120">变更前内容</th>
					<th nowrap="nowrap">变更后内容</th>				
					<th width="60">变更时间</th>
				</thead>
				<tbody id="changes">
					<tr><td colspan="5">没有数据显示！</td></tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
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

            $("#icinfo").show();
            $("#tips").hide();
            //企业基本信息
            var ebi = result.ebi;           

            //企业基本信息赋值
            $("#ent_name").text(ebi.entName);
            $("#creditCode").text(ebi.creditCode);
            $("#businessRegistNo").text(ebi.businessRegistNo);
            $("#organizationCode").text(ebi.organizationCode);
            $("#entType").text(ebi.entType);
            $("#taxpayerIdentificationNo").text(ebi.taxpayerIdentificationNo);
            $("#industry").text(ebi.industry);
            $("#businessTermFrom").text(ebi.businessTermFrom);
            $("#businessTermEnd").text(ebi.businessTermEnd);
            $("#approvalDate").text(ebi.approvalDate);
            $("#registAuthority").text(ebi.registAuthority);
            $("#registAddress").text(ebi.registAddress);
            $("#entEngilshName").text(ebi.entEngilshName);
            $("#entLegalPerson").text(ebi.entLegalPerson);
            $("#entAddress").text(ebi.entAddress);
            $("#entEmailAdress").text(ebi.entEmailAdress);
            $("#entPhone").text(ebi.entPhone);
            $("#entRegistCapital").text(ebi.entRegistCapital);
            $("#entStatus").text(ebi.entStatus);
            $("#entRegistDate").text(ebi.entRegistDate);
            $("#businessScope").text(ebi.businessScope);

            //工商变更赋值
            var c_str = "";
            //工商变更
            var crs = result.crs;
            for(var i=0; i<crs.length; i++){
                c_str += "<tr><td align='center' style='min-width:50px'>"+(i+1)+"</td>";
                c_str += "<td style='min-width:100px'>"+crs[i].changeItem+"</td>";
                c_str += "<td style='min-width:200px'>"+crs[i].changeBefore+"</td>";
                c_str += "<td style='min-width:200px'>"+crs[i].changeAfter+"</td>";
                c_str += "<td style='min-width:100px'>"+crs[i].changeDate+"</td></tr>";
            }
                $("#changes").empty();
                $("#changes").append(c_str);
            //股东出资信息赋值
            var s_str = "";
            //股东出资信息
            var shis = result.shis;

            for(var j=0; j<shis.length; j++){
                s_str += "<tr><td align='center' style='min-width:50px'>"+(j+1)+"</td>";
                s_str += "<td style='min-width:200px'>"+shis[j].shareholder+"</td>";
                s_str += "<td style='min-width:180px'>"+shis[j].liSubConAm+"</td>";
                s_str += "<td style='min-width:100px'>"+shis[j].subConDate+"</td>";
                s_str += "<td style='min-width:100px'>"+shis[j].subConFormName+"</td>";
                s_str += "<td style='min-width:180px'>"+shis[j].liAcConAm+"</td>";
                s_str += "<td style='min-width:100px'>"+shis[j].acConDate+"</td>";
                s_str += "<td style='min-width:100px'>"+shis[j].acConFormName+"</td></tr>";
            }

                $("#shareHolderInfos").empty();
                $("#shareHolderInfos").append(s_str);
        }
    })
})
</script>
</html>