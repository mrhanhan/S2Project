<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: MrHanHao
  Date: 2018/6/27 0027
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>管理员登陆</title>
    <script type="text/javascript" src="../globalscript/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../globalStyle/bootstrap.min.css"/>
    <script type="text/javascript" src="../globalscript/bootstrap.min.js"></script>
    <style>
        .video{
            width: 100%;
            height: 100%;
            position: fixed;
            bottom: 0px;
            right: 0px;
        }
        .absBody{
            width: 100%;
            height: 100%;
            position: fixed;
            bottom: 0px;
            right: 0px;
        }
        .login{
            width:40%;
            height: 65%;
            margin-top: 10%;
            margin-left: 30%;
            border-radius: 200px;
            background-color: rgba(0, 0, 0, 0);
            box-shadow: 0px 0px 0px black;
            transition:  all 500ms;
            color:white;
            font-size: 16pt;
            overflow: hidden;
            text-shadow: 0px 0px 10px #fffa31;
            border: 2px solid transparent;
            padding-top: 30px;

        }
        .login:hover{
            border-top: 2px solid rgba(39, 255, 59, 0.24);
            border-right: 2px solid rgba(77, 75, 255, 0.24);
            border-left: 2px solid rgba(255, 85, 41, 0.24);
            border-bottom: 2px solid white;

            background-color: rgba(0, 0, 0, 0.2);
        }
        .title{
            font-size: 24pt;
            padding-top: 20px;
            text-align: center;
            text-shadow: 0px 0px 10px #fff64b;
        }
        form * button{
            width: 100%;
            border-radius: 30px;
            background-color: rgba(239, 242, 255, 0);
            border:3px solid rgba(243, 255, 255, 0.23);
            color:white;
            transition: all 200ms;
            margin: 2px;
        }
        form * button:hover{
            border:3px dotted rgba(243, 255, 255, 0.95);
            background-color: rgba(239, 242, 255, 0.36);
        }
        form * input{
            color: white;
            background-color: rgba(239, 242, 255, 0);
            border-style: solid;
            padding-left: 5px;
            border-color:transparent;
            border-radius: 10px;
            transition: all 500ms;
        }
        input:-webkit-autofill{
             background-color: rgba(239, 242, 255, 0);
        }
        form * input:hover,form * input:focus{
            border-bottom: 2px solid white;
            outline:none;
        }
        .yzm{
            transition: opacity 1s;
            opacity: 0;
        }
    </style>
</head>
<body>
<%-- Java代码--%>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    if(request.getParameter("username")!=null){
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
%>
<div class="video">
    <video  autoplay="autoplay" muted="muted" loop="loop"  width="100%"  >
     <source src="./videos/back_1.MP4" type="video/mp4" />
    </video>

</div>
    <div class="absBody">
        <div class="login ">
            <div class="title">机械核心登陆</div>
            <form method="post" action="login.jsp">
                <br/>
                <div class="container">
                    <div class="row">
                        <div class="col-3 offset-1" style="text-align: right">机械账号:</div>
                        <div class="col-7 ">
                            <input type="text" name="username"  placeholder="请输入机械账号" required="required"/>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-3 offset-1" style="text-align: right">机械密码:</div>
                        <div class="col-7 ">
                            <input type="password" name="userpwd" placeholder="请输入机械密码" required="required"/>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-3 offset-1" style="text-align: right">验证码:</div>
                        <div class="col-2 ">
                            <input type="text" name="usercode1" placeholder="验证码" size="6" required="required"/>
                        </div>
                        <div class="col-3 " style="padding-left: 48px;">
                            <input type="text" name="usercode" readonly="readonly" placeholder="验证码" size="6" required="required" class="yzm" value="0568"/>
                        </div>
                    </div>
                    <br/>
                    <div class="row" >

                            <button type="submit">登入</button>


                            <button type="reset">清除</button>

                    </div>
                    <div style="text-align: center" class="date">
                       <script type="text/javascript">
                           var i=0;
                          setInterval(function () {
                               document.querySelector(".date").innerText = new Date().toLocaleString();
                               console.log(i)
                               if(i%10==0){
                                   var ymz = Math.random()*8999+1000;
                                  $(".yzm").css({
                                       opacity:0
                                })

                                   $(".yzm").val(parseInt(ymz));
                                  setTimeout(function () {
                                      $(".yzm").css({
                                          opacity:1
                                      })
                                  },1000)

                               }
                              i++;
                               },1000)
                       </script>
                    </div>
                </div>
            </form>
        </div>
        <div style="text-align: center;font-size: 12pt;">版权：&copy;Mrhan</div>
    </div>

</body>
</html>
