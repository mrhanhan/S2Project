var ALLAPPS = {};
var ALLTYPE ={};


function Apps(name,size,img,content){
  return {
    type:"APP",
    name:name,
    size:size,
    img:img,
    appTypeName:[],//app类型
    content,content,//简介
    dws:0,//下载次数
    like:0,
    noLike:0,
    joinUsers:{},//参与者
    comment:[],//评论
  };
}
// 评论
function Comment(userName,content){
  return{
    type:"Comment",
    name:userName,
    content:content,
    joinUsers:{},//参与者
    like:0,//喜欢
    notLike:0//不喜欢
  }
}
//app类型
function AppType(name){
  return{
    type:"AppType",
    name:name,
    appsName:[]
  };
}

function showTypeTxt(ele){
   var types = document.getElementsByClassName("appTypeTitle");

   for(var i=0;i<types.length;i++){
     if(types[i].querySelector(".f")){
       types[i].querySelector(".f").style.width="0%";

   }
   }
  ele.querySelector(".f").style.width="90%";

}

function Ilike(ele){

  var user = getLoginUser();//获取登陆用户
  if(user){
    userLike(ele.parentElement.parentElement.parentElement);
    ele.src="image/zan/2.png"
  }else{
     alert("请先尝试登陆！");
     showLoginPlane(0,0);
  }
}
function userLike(layout){
    var name = layout.querySelector(".app-name").innerText;//获取名称
    var type = layout.querySelector("hr").innerText;//获取类型名称
    var img = layout.querySelector(".app-top").style.backgroundImage;
    var size= img.length;
    img = img.substr(5,size-7);
    var like = {
      name:name,
      type:type,
      img:img
    };
  var user = getLoginUser();
  user.likes.push(like);
  flush();

}
var type = new AppType("最新游戏");
var app = new Apps("足球小子",10,"image/zan/1.png","好玩的");
ALLAPPS[app.name]=app;
// window.load=
function scriptLoad(){
 appGroup = document.getElementsByClassName("apps")[0];

   AppMB = appGroup.children[0];


     appendApp("全部游戏",0);
   }
function appendApp(txt,img){
       appGroup.innerHTML="";
       var col = img==0?35:parseInt(1+Math.random()*35);
       var isi = img!=0;
	       if(img!=0){
	       	img = parseInt(1+Math.random()*35);
	       }

         for(var i=2;i<=col;i++){
           var div = document.createElement("div");
           div.setAttribute("class","app-group");
           div.setAttribute("id","app-group-"+i+"");
           div.innerHTML=AppMB.innerHTML;
           //
           appGroup.appendChild(div);
           div = document.getElementById("app-group-"+i+"");
            var  ig=parseInt(1+Math.random()*35);
           div.children[0].style.backgroundImage="url(image/logo/"+ig+".png)";
           div.children[1].innerText=txt;
         }
  }
