var dataSet = [[4,"name",500,"2018-03-31",45,1,45],[4,"name",500,"2018-04-03",45,1,40],["total","","","","","",85]];
var table;
var count = 2;
    window.onload = function(e){
        table = $('#example').DataTable( {
        searching: false,//屏蔽datatales的查询框
        bLengthChange: false,//屏蔽tables的一页展示多少条记录的下拉列表
        ordering: false,//关闭排序
        data: dataSet,
        columns: [
            { title: "分类编号"},
            { title: "商品名字" },
            { title: "商品规格" },
            { title: "生产日期"},
            { title: "价格" },
            { title: "数量" },
            { title: "总计" },
        ]
    } );
    }

function add(product){
    var arr = new Array();
    var num = new Array();
    var sum = table.row(count).data()[5];
    for(var i=0;i<count;i++){
    	var t =  table.row(i).data();
    	arr.push(t[0]);
    	num.push(t[4]);
    }
}

    
function getsecond(){
    var provider = $("#selectprovider").find("option:selected").val();
     $("select[name=classify]").empty();     //清空seletct的数据  
            $.ajax({
              type:"GET",                        //post请求
              url:"/aprs/getClassifyItem",                          //请求后台action 根据需求请求自己的后台数据
              data:{pid:provider},
              success:function(data){             //ajax成功的方法 在里卖弄给select的<option>标签赋值
                  //向select中append、option标签
                  var optionString = "<option grade=\'请选择分类\' selected = \'selected\'>--请选择分类--</option>";
                  var beanList = data;            //返回的json数据
                  console.log(beanList);
                  if(beanList){                   //判断
                      for(var i=0; i<beanList.length; i++){ //遍历，动态赋值
                          optionString +="<option grade=\""+beanList[i].cid+"\" value=\""+beanList[i].cid+"\"";  
                          optionString += ">"+beanList[i].cname+"</option>";  //动态添加数据  
                      }  
                      $("select[name=classify]").append(optionString);  // 为当前name为asd的select添加数据。
                }  
            }  
        }); 
}
function getthird(){
    var classify = $("#selectclassify").find("option:selected").val();
     $("select[name=product]").empty();     //清空seletct的数据  
            $.ajax({
              type:"GET",                        //post请求
              url:"/aprs/getProductItem",                          //请求后台action 根据需求请求自己的后台数据
              data:{cid:classify},
              success:function(data){             //ajax成功的方法 在里卖弄给select的<option>标签赋值
                  //向select中append、option标签
                  var optionString = "<option grade=\'请选择农产品\' selected = \'selected\'>--请选择农产品--</option>";
                  var beanList = data;            //返回的json数据
                  console.log(beanList);
                  if(beanList){                   //判断
                      for(var i=0; i<beanList.length; i++){ //遍历，动态赋值
                          optionString +="<option grade=\""+beanList[i].did+"\" value=\""+beanList[i].did+"\"";  
                          optionString += ">"+beanList[i].dname+"</option>";  //动态添加数据  
                      }  
                      $("select[name=product]").append(optionString);  // 为当前name为asd的select添加数据。
                }  
            }  
        }); 
}