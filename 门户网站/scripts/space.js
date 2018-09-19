// 脚本加载事件
function scriptLoad(){
  Body = document.getElementById("body");
  loadMB();
  likeLoad();
  showBooks();
}


var SPACEMB = null;

function likeLoad(){
  var user = getLoginUser();

  var name = Body.querySelector(".like-username");
   name.innerText = user.name;
   name = Body.querySelector(".like-add");
   name.innerText = user.email;
   Body.querySelector(".like-userimg").style.backgroundImage="url("+user.headImg+")";
   Body.querySelector(".like-userimg").title="用户["+user.name+"] 注册时间："+user.regDate;
}

function loadMB(){
  var layout = Body.querySelector(".books")
  if(!SPACEMB){
    var bmb = layout.querySelector(".bookGroup");
    SPACEMB =bmb.innerHTML;//获取模板
    layout.innerHTML="";

  }
}
//是否显示按钮
function ishow(ele) {
  var iss = ele.getAttribute("show")=='true';
  ele.style.height=(iss?"200px":"15px");
  ele.setAttribute("show",!iss);
  console.log(ele);
  console.log(iss);
  ele.children[0].style.borderBottom=(!iss?"2px solid white":"none");
}


function showBooks(){
  var books = ALLBOOK;
  for(var i=0;i<books.length;i++){
    AddBooks(books[i]);
  }

}

function SendBook(){
  var layout = Body.querySelector("#sendSpace");
  var input = layout.querySelector("input");
  var textarea = layout.querySelector("textarea");
  var tit = input.value;
  var text = textarea.value;
 console.log(layout);
  if(tit==""){
    alert("标题不能为空");
    input.focus();
    return;
  }
  if(text==""){
    alert("内容不能为空");
    textarea.focus();
    return;
  }

  var user = getLoginUser();

  var book = new Book(tit,text,user.name);
  addBook(book);
  AddBooks(book);


}
function AddBooks(book){
  var layout = Body.querySelector(".books")
  var div = document.createElement("div");
  // class="bookGroup" onmouseover="showInput(this,true)" onmouseout="showInput(this,false)"
      div.className = "bookGroup";
      div.setAttribute("onmouseover","showInput(this,true)");
      div.setAttribute("bookId",book.id);
      div.setAttribute("onmouseout","showInput(this,false)");
      div.innerHTML=SPACEMB;

      // 设置标题
      div.querySelector(".title").innerText=book.name;

      // 设置背景图
      var user = ReadUser(book.user);
      //设置背景
      div.querySelector(".user").style.backgroundImage="url("+user.headImg+")";
      //设置用户名称
      div.querySelector(".user .spacename").innerText=user.name;//
      //设置发布日期
      div.querySelector(".user .spacedate").innerText=book.date;//
      //设置发布内容
      div.querySelector(".nr textarea").innerText=book.text;//
      //获取评论框架
      var pllayout =   div.querySelector(".PLGroup");
      var pls = book.pls;//获取所有评论
      //循环添加评论
      for(var i=0;i<pls.length;i++){
        var pl =pls[i];
        var pll =  document.createElement("div");//创建评论容器
            pll.className="PL";
          var d1 =  document.createElement("div");//创建显示评论用户名容器
          d1.className="PLUser";
          var u = ReadUser(pl.user);//
          pll.title="用户["+u.name+"]"
          d1.style.backgroundImage="url("+u.headImg+")";
          var d2 =  document.createElement("div");
          d2.className="spacename";
          d2.innerText = u.name;
            d1.append(d2);

            d2 =  document.createElement("div");
            d2.innerText = pl.date;
              d2.className="spacedate";
              d1.append(d2);

          pll.append(d1);
          var dl =  document.createElement("div");
          dl.className="PLmsg";
          dl.innerText = pl.text;//设置评论内容

          console.log(pl);
          pll.append(dl);
          pllayout.append(pll);
      }

      if(layout.children.length==0){
        layout.append(div);
      }else{
        layout.insertBefore(div,layout.children[0]);
      }


}
function showInput(ele,isHover){
  var height = isHover?40:40;
  ele.querySelector(".PLInput").style.height=height+"px";
}
// 发表评论
function inputPL(ele){
  var layout = ele.parentElement.parentElement;
 var input = layout.querySelector("input");//获取值
 var book = getBook(layout.getAttribute('bookId'));//
 var user = getLoginUser();
 var val = input.value;
 if(val==""){
   alert("请输入评论内容！");
   input.focus();
   return;
 }

 var pl = new PL(val,user.name);
 book.pls.push(pl);

 var pll =  document.createElement("div");
     pll.className="PL";
   var d1 =  document.createElement("div");
   d1.className="PLUser";
   var u = ReadUser(pl.user);//
   d1.style.backgroundImage="url("+user.headImg+")";
   var d2 =  document.createElement("div");
   d2.className="spacename";
   d2.innerText = u.name;
     d1.append(d2);

     d2 =  document.createElement("div");
     d2.innerText = pl.date;
       d2.className="spacedate";
       d1.append(d2);

   pll.append(d1);
   var dl =  document.createElement("div");
   dl.className="PLmsg";
   dl.innerText = pl.text;//设置评论内容
   pll.append(dl);
   layout.querySelector(".PLGroup").append(pll);

 console.log(pl)
 flushBook();
 input.value="";
}
