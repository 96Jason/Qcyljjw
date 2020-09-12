require(["/js/common/requireConfig.js"],function () {
    require(["jquery","tip","bootstrap","resolveAppBack"],function ($,Tip) {
        <!--从url中获取数据-->
        function getDataList() {
            var currentUrl = window.location.href;
            //url与数据部分分段
            var urlAndDataSubsection = currentUrl.split("?");
            //获取数据部分
            var dataParts = urlAndDataSubsection[1];
            //数据部分分段
            var dataSubsection = dataParts.split("&");
            //获取第一个数据部分
            var firstDataPart = dataSubsection[0];
            //获取第二个数据部分
            var secondDataPart = dataSubsection[1];
            //获取第三个数据部分
            var thirdDataPart = dataSubsection[2];
            //第一个数据部分分段
            var firstDataPartSubsection = firstDataPart.split("=");
            //第二个数据部分分段
            var secondDataPartSubsection = secondDataPart.split("=");
            //第三个数据部分分段
            var thirdDataPartSubsection = thirdDataPart.split("=");
            //获取第一个数据的值
            var id = firstDataPartSubsection[1];
            //获取第二个数据的值
            var uid = secondDataPartSubsection[1];
            //获取第三个数据的值
            var user_id = thirdDataPartSubsection[1];
            var list = new Array();
            list.push(id);
            list.push(uid);
            list.push(user_id);
            return list;
        }
        <!--渲染简历信息-->
        $(function () {
            var dataList = getDataList();
            var id = dataList[0];
            $.ajax({
                type:"get",
                url:"/getIntroById",
                data:{"id":id},
                dataType:"json",
                success:function (resume) {
                    //感兴趣按钮
                    $("#interested").bind("click",function () {
                        interested();
                    })
                    // 头像
                    $("#user-photo").attr("src","../../"+resume.photo);
                    // 个人信息
                    var userInfoTable = $("#userInfoTable");
                    var userInfoTbody = userInfoTable.children("tbody").eq(0);
                    var userInfoTrArray = userInfoTbody.children("tr");
                    var userInfoTdArray1 = userInfoTrArray.eq(0).children("td");
                    userInfoTdArray1.eq(0).html("<b>姓名</b>："+resume.uname);
                    userInfoTdArray1.eq(1).html("<b>职业</b>："+resume.profession);
                    var userInfoTdArray2 = userInfoTrArray.eq(1).children("td");
                    userInfoTdArray2.eq(0).html("<b>性别</b>："+resume.sex);
                    userInfoTdArray2.eq(1).html("<b>手机</b>："+resume.phone);
                    var userInfoTdArray3 = userInfoTrArray.eq(2).children("td");
                    userInfoTdArray3.eq(0).html("<b>年龄</b>："+resume.age);
                    userInfoTdArray3.eq(1).html("<b>邮箱</b>："+resume.email);
                    //教学范围
                    var teachRangeTable = $("#teachRangeTable");
                    var teachRangeTbody = teachRangeTable.children("tbody").eq(0);
                    var teachRangeTrArray = teachRangeTbody.children("tr");
                    var teachRangeTdArray1 = teachRangeTrArray.eq(0).children("td");
                    teachRangeTdArray1.eq(0).html("<b>教学科目</b>："+resume.subject);
                    teachRangeTdArray1.eq(1).html("<b>教学模式</b>："+resume.pattern);
                    teachRangeTdArray1.eq(2).html("<b>授课地区</b>："+resume.address);
                    //教育背景
                    var educationTable = $("#educationTable");
                    var educationTbody = educationTable.children("tbody").eq(0);
                    var educationTrArray = educationTbody.children("tr");
                    var educationTdArray1 = educationTrArray.eq(0).children("td");
                    educationTdArray1.eq(0).html("<b>在读/毕业院校</b>："+resume.school);
                    educationTdArray1.eq(1).html("<b>学历</b>："+resume.education);
                    //座右铭
                    var mottoTable = $("#mottoTable");
                    var mottoTbody = mottoTable.children("tbody").eq(0);
                    var mottoTrArray = mottoTbody.children("tr");
                    var mottoTdArray1 = mottoTrArray.eq(0).children("td");
                    mottoTdArray1.eq(0).children("p").eq(0).html(resume.motto);
                    //自我评价
                    var introTable = $("#introTable");
                    var introTbody = introTable.children("tbody").eq(0);
                    var introTrArray = introTbody.children("tr");
                    var introTdArray1 = introTrArray.eq(0).children("td");
                    introTdArray1.eq(0).children("p").eq(0).html(resume.intro);
                },
                error:function () {
                    Tip.warn("请求失败");
                }
            })
        });

        // 感兴趣
        function interested() {
            var dataList = getDataList();
            var sender = dataList[1];
            var receiver = dataList[2];
            $.ajax({
                type:"get",
                url:"/interested",
                data:{sender:sender,receiver:receiver,articleType:"resume"},
                dataType:"json",
                success:function (result) {
                    if(result.data != null){
                        $("#_interested").click();
                        for(j = 0,len=result.data.length; j < len; j++){
                            $("#recruit").append('<option value="'+result.data[j].id+'">'+result.data[j].subject+'</option>');
                        }
                    }else {
                        Tip.info(result.message);
                    }
                },
                error:function () {
                    Tip.warn("请求失败");
                }
            })
        }

        $(function() {
            $("#recruitForm").on("submit",function (e) {
                var dataList = getDataList();
                var sender = dataList[1];
                var receiver = dataList[2];
                e.preventDefault();
                var form = new FormData(document.getElementById("recruitForm"));
                form.append("sender",sender);
                form.append("receiver",receiver);
                $.ajax({
                    type:"post",
                    url:"/sendRecruitToOthers",
                    data:form,
                    dataType:"text",
                    processData:false,
                    contentType:false,
                    success:function (data) {
                        $("#select-recruit").click();
                        if(data=="success"){
                            Tip.success("已通知对方");
                        }else if(data=="failure"){
                            Tip.warn("通知失败");
                        }
                    },
                    error:function () {
                        Tip.warn("请求失败");
                    }
                })
            });
        })
    });
});