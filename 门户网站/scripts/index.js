
var body = document.getElementById("body")


if(window.all){
  window.attachListener("load",load,false);
}else{
  window.addEventListener("load",load,false);
}

var index_lbt_img=0;
var index_lbt_time=null;
var index_lbt_icons=null;//轮播图
var parent=null;
function load(){
  index_lbt_icons = body.getElementsByClassName("index-icon");
  index_lbt_change();
}

var index_hover_img_ishouver=false;
function index_hover_change_over(ele){
  index_hover_img_ishouver=true;
  var icon = index_lbt_icons[index_lbt_img];//获取指定节点

     for(var i=0;i<index_lbt_icons.length;i++){//改变样式
         var img_index = index_lbt_icons[i];
         img_index.className =img_index.className.replace("index-icon-hover","");//替换悬浮样式
     }

  index_lbt_img++;
  var path = ele.getAttribute('path');
  ele.className=ele.className+" index-icon-hover";
  body.querySelector(".index-img").setAttribute("style","background:url("+path+")");
}
function index_hover_change_out(ele){
  index_hover_img_ishouver=false;
}

function index_lbt_change(){
  if(index_lbt_time){
    clearTimeout(index_lbt_time);
  }
  if(index_lbt_img >= index_lbt_icons.length){//判断下表是不是等于长度
       index_lbt_img=0;
  }

 if(!index_hover_img_ishouver){
    var icon = index_lbt_icons[index_lbt_img];//获取指定节点

       for(var i=0;i<index_lbt_icons.length;i++){//改变样式
           var img_index = index_lbt_icons[i];
           img_index.className =img_index.className.replace("index-icon-hover","");//替换悬浮样式
       }

    index_lbt_img++;
    var path = icon.getAttribute('path');
    icon.className=icon.className+" index-icon-hover";
    body.querySelector(".index-img").setAttribute("style","background:url("+path+")");
  }
  index_lbt_time = setTimeout(index_lbt_change,2000);
}

//鼠标进入
function index_btn_hover(ele){
 var nos = ele.parentElement.children;

 for(var i=0;i<nos.length;i++){
   nos[i].childNodes[3].style.width='0%';
 }


  ele.childNodes[3].style.width='101%';
  body.querySelector("#right").style.background="url(image/xxt/"+ele.getAttribute('name')+".jpg)";

}
