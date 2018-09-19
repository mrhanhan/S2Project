//数据保存脚本
var DATACODE = "0x2825628257";//数据标识号码
var DATAIO = localStorage;//数据保存对象
//保存数据
function save(data){
  DATAIO[DATACODE]="eval("+data+")";
}
//读取数据
function read(){
  return DATAIO[DATACODE];

}

//保存数据键值对
function saveKV(key,value){
  DATAIO[key]=value;
}
//读取数据键值对
function readKV(key){
  return DATAIO[key];

}



//将对象转换为JSON字符串
function toJson(object){
  return JSON.stringify(object);
}
//将json文本转换对象
function toObject(jsontxt){
  return eval(jsontxt);
}
