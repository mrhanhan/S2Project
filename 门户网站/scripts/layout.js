saveKV("loginName","");
function showLoginPlane(x,y){
  var logplane = document.getElementById("userGroup");
  var layout = document.getElementById("userlogin");//获取用户信息面板
  var userimgele = layout.querySelector(".left #userimg");//获取用户头像
  logplane.style.bottom=y+"px";
  logplane.style.right=x+"px";
    userimgele.style.margin=(x==0)?"0px auto":"0px";
}
// 显示登陆界面还是注册界面
function showLoginORReg(is){
  var tt = is?500:0;
  var login = document.getElementById("layout-login");
  login.style.height=tt+"px";
}
// 用户注册
function regUser(){

  var regPlane  = document.querySelector("#layout-reg .layout-loginfrom");//获取的注册面板
  var name = regPlane.querySelector("#usernameR");//获取用户名
    var email = regPlane.querySelector("#emailR");//获取邮箱
      var pwd = regPlane.querySelector("#userpwdR");//获取密码
     var sex = regPlane.querySelector("#sexMan").checked?"男":"女";
   console.log(regPlane.querySelector("#sexMan"));
          if(!checkRegData(name)){

            alert("用户名不合法！");
              name.focus();
            return;
          }
          if(!checkRegData(email)){
            alert("邮箱不合法！");
            email.focus();
            return;
          }
          if(!checkRegData(pwd)){
            alert("密码不合法！");
              pwd.focus();
            return;
          }



          var user = new User(name.value,pwd.value,sex);
          user.email = email.value;
          user.headImg="image/tx/1.png";//设置头像

          if(!SaveUser(user)){
            alert("用户 '"+name.value+"' 已存在！");
            return;
          }
          saveKV("loginName",user.name);
          alert("注册成功！");
          email.value="";
          name.value=pwd.value="";
         showLoginORReg(true);//显示登陆页面

}
//注册检测函数
function checkRegData(inputEle){
 var group = inputEle.parentElement;//获取父级
 var msgele = group.querySelector(".msg");//获取msg对象
 var query = inputEle.value;
 var reg = new RegExp(msgele.getAttribute('reg'));//获取表达式
 console.log(query);
 console.log(reg);
 if(reg.test(query)){

   msgele.style.visibility="hidden";
   return true;
 }else{
   msgele.style.visibility="visible";
   return false;
 }
}
// 用户登录
function userLogin(){
  var loginPaine = document.getElementById("layout-login");
  var name = loginPaine.querySelector("#usernameL").value;//获取用户名
  var pwd =  loginPaine.querySelector("#userpwdL").value;//获取用密码
  loginPaine.querySelector("#userpwdL").value="";
  var user = ReadUser(name);//读取用户
  if(!user || pwd != user.pwd){
    alert("用户名不存在或者密码错误");
  }else{
    saveKV("loginName",user.name);
    showUserMsg(user);
    isHiddenLoginPlain(true);
    alert("登陆成功");
  }

}
// window.onload=function(){isHiddenLoginPlain(true);}
//是否隐藏面板
function isHiddenLoginPlain(ish){
  var lp = document.getElementById("notLogin");//获取登陆面板
  var dp = document.getElementById("userlogin");
  lp.style.display = (ish?"none":"block");
  dp.style.display = (ish?"block":"none");
}
// 显示用户信息
function showUserMsg(user){
  var layout = document.getElementById("userlogin");//获取用户信息面板
  var userimgele = layout.querySelector(".left #userimg");//获取用户头像
     userimgele.style.backgroundImage ="url("+user.headImg+")";
     userimgele.title=user.name;

  var usernameEle = layout.querySelector("#username");//用户名

    var userpwdEle = layout.querySelector("#userpwd");//密码

    var  emailEle = layout.querySelector("#email");//邮箱

    var useraddEle = layout.querySelector("#useradd");//地址

    var usersexEle = layout.querySelector("#usersex");//性别

    var regEle = layout.querySelector("#userDate");//注册时间

    usernameEle.value = user.name;
    userpwdEle.value = user.pwd;
    emailEle.value = user.email;
    useraddEle.value=user.address;
    usersexEle.value = user.sex;
    regEle.value = user.regDate;

}
// 选择改变事件
function selectChanged(selectEle){
  var index = selectEle.selectedIndex;
  var value = selectEle.options[index].value;//获取选中的值
  document.getElementById("userimg").style.backgroundImage="url("+value+")";
}
// 跟新新的值
function update(key,value){
  var username = readKV("loginName");//获取登陆的用户
  var user = ReadUser(username);//获取制定的用户信息对象
  user[key]=value;//跟新新的值
  flush();
}
function blackImg(){
  var username = readKV("loginName");//获取登陆的用户
  var user = ReadUser(username);//获取制定的用户信息对象
    document.getElementById("userimg").style.backgroundImage="url("+user.headImg+")";
}
//显示按钮
function showBtns(eleLayout,isShow){
  var btns = eleLayout.querySelectorAll("button");
  btns[0].style.visibility=(isShow?"visible":"hidden");

  btns[1].style.visibility=(isShow?"visible":"hidden");
}
function logOut(){
  if(window.confirm("是否退出登录？")){
     isHiddenLoginPlain(false);
  window.open("index.html","body");
   }
}

function isChangeData(eleLayout,is){
  var input = eleLayout.querySelector("input");
   if(is){
       input.removeAttribute("readonly");
       input.focus();
   }else{
     input.setAttribute("readonly","readonly");
   }
}
// 检查数据 并修改数据
function checkData(eleLayout,pro){
  var user = getLoginUser();//获取登陆用户
  var input = eleLayout.querySelector("input");
  var value = input.value;
  var reg = new RegExp(input.getAttribute('reg'));
  if(reg.test(value)){
    user[pro] = value;
    flush();
  }else{

    alert("修改失败！数据不合法");
    input.value = user[pro];
  }
  isChangeData(eleLayout,false);
}

setLoginUser("");
function ItemClick(ele){
    var layout = ele.parentElement;

    var btns = layout.querySelectorAll(".btns");
    for(var i=0;i<btns.length;i++){
      //console.log(btns[i].className.replace("btns_hover",""));
      btns[i].className = btns[i].className.replace("btns_hover","");
    }
    ele.className+=" btns_hover";

    var url = ele.getAttribute("url");
    console.log(url);
    window.open(url,"body");
}
