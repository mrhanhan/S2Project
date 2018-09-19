<%@ page import="com.newinfo.mrhan.ApplictionConfig" %>
<%@ page import="com.newinfo.mrhan.modles.NewInfo" %>
<%@ page import="com.mrhan.database.allrounddaos.EntityDaos" %>
<%@ page import="com.newinfo.mrhan.modles.NewInfoMsg" %>
<%@ page import="java.util.List" %>
<%@ page import="com.newinfo.mrhan.views.NewInfoView" %><%--
  Created by IntelliJ IDEA.
  User: MrHanHao
  Date: 2018/6/28 0028
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Title</title>
    <script type="text/javascript" src="../../globalscript/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../../globalStyle/bootstrap.min.css"/>

    <script type="text/javascript" src="../../../globalscript/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./style/newinfo.css"/>
</head>
<body onload="window.parent.setFrameHeight(document)">

 <div class="container-fluid"style="padding: 10px 30px;">
     <div class="row" style="border-bottom: 1px solid black;padding: 5px 0px;">
         <div class="btn-group-sm">
            <button class="btn">添加新闻</button>
             <button class="btn">修改新闻</button>
             <button class="btn">删除新闻</button>
             <button class="btn">检索新闻</button>
         </div>
     </div>
     <% new NewInfoView(out).show();%>

     <div class="row">

         <div>
            <div class="row">

             </div>
         </div>
     </div>
 </div>

</body>
</html>
