<%--
  Created by IntelliJ IDEA.
  User: MrHanHao
  Date: 2018/6/28 0028
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>核心主页</title>
    <script type="text/javascript" src="../globalscript/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../globalStyle/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./styles/home.css"/>
    <script type="text/javascript" src="../globalscript/bootstrap.min.js"></script>
    <base target="iboxy">
</head>
<body>
<div class="video">

</div>
<div class="absBody">
    <!--容器-->
    <div class="container-fluid body" >
        <!-- 头部导航栏 包含用户信息-->
        <div class="row ">
            <!--logo-->
            <div class="col-3 col-lg-1 " style="text-align: center;">
               <img src="../images/logo.png" width="40" height="40" alt="机械核心-Core" title="机械核心-Core">
            </div>
            <div class="col-9 col-lg-11 " >
                <div style="text-align: right;font-size: 10pt;">

                <a href="#">联系站长</a>&nbsp;&nbsp;&nbsp;
                    <span class="date"></span>
                    <script type="text/javascript">
                        setInterval(function () {
                            $(".date").html(new Date().toLocaleString())
                        },1000)
                    </script>
                </div>

            </div>
        </div>
        <hr class="hr" />

        <div class="row">
            <!--功能栏-->
            <div class="col-3 col-lg-2 func">
                <div class="usermsg"><%= request.getParameter("username")%></div>
                <hr class="hr"/>
                <div class="funitem funitem_hover">
                   <img src="images/home.png"  width="24" height="24" > <a href="html/home.jsp">首页</a>
                </div>
                <hr class="hr"/>
                <div class="funitem">
                    <img src="images/news.png"  width="24" height="24"> <a href="html/newmanager.jsp">新闻管理</a>
                </div>
                <div class="funitem">
                    <img src="images/notes.png"  width="24" height="24">  帖子管理
                </div>
                <div class="funitem">
                    <img src="images/user.png" width="24" height="24"> 用户管理
                </div>
                <hr class="hr"/>
                <div class="funitem">
                    <img src="images/my.png" width="24" height="24">  个人信息
                </div>
                <div class="funitem">
                    <img src="images/post.png" width="24" height="24"> 其他信息
                </div>
                <script type="text/javascript">

                    $(".funitem").click(function () {
                        $(".funitem").removeClass("funitem_hover");
                        $(this).addClass("funitem_hover")
                    });
                </script>
            </div>
            <!--框架集部分-->
            <div class="col-9 col-lg-10 test">
                <script type="text/javascript">

                    function setFrameHeight(ele){
                        var height =0 ;
                        if(window.all){
                            height = ele.documentElement.offsetHeight;
                        }else{
                            height = ele.body.offsetHeight;
                        }
                        DOc =ele;
                        console.log( $("iframe"))
                        console.log(height)
                        $("iframe")[0].height=height+100;

                    }
                </script>
                <iframe frameborder="0" style="overflow: hidden;" width="100%" class="test" src="html/home.jsp" height="100%" name="iboxy" ></iframe>
            </div>
        </div>

    </div>
    <div style="text-align: center;font-size: 12pt;">版权：&copy;Mrhan</div>
</div>
</body>
</html>
