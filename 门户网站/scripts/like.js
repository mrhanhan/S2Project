// 脚本加载事件
function scriptLoad(){
  Body = document.getElementById("body");
  likeLoad();

}
var APPLIKEMB = null;
function likeLoad(){
  var user = getLoginUser();
  var layout = Body.querySelector(".appbody");
  if(!APPLIKEMB){//判断是否加载过模板
    var mb=layout.querySelector(".app-group");
    APPLIKEMB =mb.innerHTML;
    layout.removeChild(mb);
  }
  var name = Body.querySelector(".like-username");
   name.innerText = user.name;
   name = Body.querySelector(".like-add");
   name.innerText = user.email;
   Body.querySelector(".like-userimg").style.backgroundImage="url("+user.headImg+")";
   Body.querySelector(".like-userimg").title="用户["+user.name+"] 注册时间："+user.regDate;

   var userApps = user.likes;

   layout.innerHTML="";
  for(var i=0;i<userApps.length;i++){
    var app = userApps[i];
    console.log(app);
    var time  = (new Date()).getTime();

    var gp = document.createElement("div");
    // class="app-group" onmouseover="showBtn(this,true)" onmouseout="showBtn(this,false)"
    gp.setAttribute("onmouseover","showBtn(this,true)");
      gp.setAttribute("onmouseout","showBtn(this,false)");
        gp.setAttribute("id",time);
    gp.className="app-group";
    gp.innerHTML = APPLIKEMB;//架子啊模板
    layout.append(gp);

    gp.querySelector(".app-top").style.backgroundImage="url("+app.img+")";
      gp.querySelector(".typetxt").innerText=app.type;
      gp.setAttribute("index",i);
  }




}
//移除收藏的游戏
function removeApp(ele){
  var user = getLoginUser();
  var layout = Body.querySelector(".appbody");
  var gp = ele.parentElement.parentElement;//获取最外边
  var index = gp.getAttribute("index");
   var obj= user.likes[index];
   user.likes[index]=user.likes[0];
   user.likes.shift();
   console.log(user.likes);
   flush();


  layout.removeChild(gp);
  likeLoad();

}
function showBtn(ele,isS){
  ele.querySelector(".showBtn").style.top=isS?"-30px":"0px";
}
