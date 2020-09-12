require(["/js/common/requireConfig.js"],function () {
    require(["jquery","tip","bootstrap","resolveAppBack"],function ($,Tip){
        //获取url中的数据
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
                url:"/getSendRecruitById",
                data:{"id":id},
                dataType:"json",
                success:function (recruit) {
                    //感兴趣按钮
                    $("#interested").bind("click",function () {
                        interested();
                    })
                    // 头像
                    $("#user-photo").attr("src","../../"+recruit.photo);
                    // 聘方信息
                    var recruitTable = $("#recruitTable");
                    var recruitTbody = recruitTable.children("tbody").eq(0);
                    var recruitTrArray = recruitTbody.children("tr");
                    var recruitTdArray1 = recruitTrArray.eq(0).children("td");
                    recruitTdArray1.eq(0).html("<b>姓名</b>："+recruit.uname);
                    recruitTdArray1.eq(1).html("<b>手机</b>："+recruit.phone);
                    var recruitTdArray2 = recruitTrArray.eq(1).children("td");
                    recruitTdArray2.eq(0).html("<b>单位</b>："+recruit.unit);
                    recruitTdArray2.eq(1).html("<b>邮箱</b>："+recruit.email);
                    //教学范围
                    var teachRangeTable = $("#teachRangeTable");
                    var teachRangeTbody = teachRangeTable.children("tbody").eq(0);
                    var teachRangeTrArray = teachRangeTbody.children("tr");
                    var teachRangeTdArray1 = teachRangeTrArray.eq(0).children("td");
                    teachRangeTdArray1.eq(0).html("<b>教学科目</b>："+recruit.subject);
                    teachRangeTdArray1.eq(1).html("<b>教学模式</b>："+recruit.pattern);
                    teachRangeTdArray1.eq(2).html("<b>授课地点</b>："+recruit.address);
                    //学员简介
                    var studentTable = $("#studentTable");
                    var studentTbody = studentTable.children("tbody").eq(0);
                    var studentTrArray = studentTbody.children("tr");
                    var studentTdArray1 = studentTrArray.eq(0).children("td");
                    studentTdArray1.eq(0).children("p").eq(0).html(recruit.stu_intro);
                    //教学要求
                    var requireTable = $("#requireTable");
                    var requireTbody = requireTable.children("tbody").eq(0);
                    var requireTrArray = requireTbody.children("tr");
                    var requireTdArray1 = requireTrArray.eq(0).children("td");
                    requireTdArray1.eq(0).children("p").eq(0).html(recruit.work_require);
                },
                error:function () {
                    Tip.warn("请求失败");
                }
            })
        })

        // 感兴趣
        function interested() {
            var dataList = getDataList();
            var sender = dataList[1];
            var receiver = dataList[2];
            $.ajax({
                type:"get",
                url:"/interested",
                data:{sender:sender,receiver:receiver,articleType:"recruit"},
                dataType:"json",
                success:function (result) {
                    if(result.data != null){
                        $("#_interested").click();
                        for(j = 0,len=result.data.length; j < len; j++){
                            $("#resume").append('<option value="'+result.data[j].id+'">'+result.data[j].subject+'</option>');
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
            $("#resumeForm").on("submit",function (e) {
                var dataList = getDataList();
                var sender = dataList[1];
                var receiver = dataList[2];
                e.preventDefault();
                var form = new FormData(document.getElementById("resumeForm"));
                form.append("sender",sender);
                form.append("receiver",receiver);
                $.ajax({
                    type:"post",
                    url:"/sendResumeToOthers",
                    data:form,
                    dataType:"text",
                    processData:false,
                    contentType:false,
                    success:function (data) {
                        $("#select-resume").click();
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
