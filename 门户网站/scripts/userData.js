var ALLUSER={alluser:{}};//所有用户
var ALLBOOK=[];
function readAllUser(){
  if(read && typeof(read) == 'function'){
    var re = toObject(read());//读取数据
    ALLUSER = re || ALLUSER;//刷新数据
    if(!ALLUSER.alluser){
      ALLUSER.alluser={};
      saveAllUser();//保存
    }
    return true;
  }
  return false;
}
function saveAllUser(){

    if(save && typeof(save) == 'function'){
         save(toJson(ALLUSER));
         return true;
    }
    return false;
}

function flush(){

  saveAllUser();
    readAllUser();

}

function setLoginUser(name){
  saveKV("loginName",name);
}

readAllUser();
flush();

  var a = readKV("Books");
if(!a){
flushBook();
}else{
  ALLBOOK = eval(a);
}
function User(name,pwd,sex){
  return {
    type:"User",//对象类型
    name:name,//用户名
    pwd:pwd,//密码
    headImg:"0",
    sex:sex,//性别
    address:"",//地址
    likes:[],//爱好
    email:"",//邮箱
    books:[],//文章
    regDate:(new Date()).toLocaleString(),//注册时间
  };
}
//文章
function Book(name,cont,user){
  return {
    type:"Book",//类型
    id:(new Date()).getTime(),
    date:(new Date()).toLocaleString(),//发布时间
    name:name,//文章名称
    text:cont,//文章内容
    user:user,//发布者,
    pls:[]
  };
}
function PL(txt,user){
  return{
    type:"PL",//类型
    date:(new Date()).toLocaleString(),//发布时间
    text:txt,
    user:user//文章内容
  };
}
//更新用户
function SaveUser(user){
  if(ALLUSER.alluser[user.name+'']){//判断用户是否存在
    return false;
  }
  ALLUSER.alluser[user.name+'']=user;
  return  saveAllUser();

}
//获取用户
function ReadUser(name){
  readAllUser();
  return ALLUSER.alluser[name+''];
}
//添加用户
function addUser(user){
  if(ALLUSER.alluser[user.name+'']){//判断用户是否存在
    return false;
  }
  ALLUSER.alluser[user.name+'']=user;
  return  saveAllUser();

}
//获取登陆用户
function getLoginUser(){
  return ReadUser(readKV("loginName"));
}
function flushBook(){
  saveKV("Books","eval("+toJson(ALLBOOK)+")")
  var a = readKV("Books");
  ALLBOOK=toObject(a);
}
function addBook(book){
  ALLBOOK.push(book);
  flushBook();
}

function getBook(id){
  var books = ALLBOOK;
  for(var i=0;i<books.length;i++){
    if(books[i].id==id){
      return books[i];
    }

  }
  return null;
}
