<%--
  Created by IntelliJ IDEA.
  User: jianz
  Date: 2021/1/5
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加简历</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/statics/ckeditor/ckeditor.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/statics/ckeditor/config.js"></script>
    <style>
        #prev-photo[src=""], #prev-photo:not([src]) {
            opacity: 0;
        }
    </style>
    <script>
        function selectPhoto() {
            $("#photo-file").click();
        }

        function upload() {
            let file = $("#photo-file").val();
            if (!file) return;
            let formData = new FormData();
            formData.append("photo-file", document.getElementById("photo-file").files[0]);
            $.ajax({
                url: "${pageContext.request.contextPath}/servlet/upload.do",
                type: "post",
                data: formData,
                contentType: false,
                processData: false,
                success: function (data) {
                    let obj = JSON.parse(data);
                    if (obj.type == "success") {
                        $("#prev-photo").attr("src", obj.filePath + obj.fileName);
                        $("#photo").val(obj.fileName);
                    } else {
                        alert(obj.msg);
                    }
                },
                error: function (data) {
                    let obj = JSON.parse(data);
                    alert("上传失败:" + obj.msg);
                }
            });
        }
    </script>
</head>

<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/servlet/UserServlet.do?action=doAdd" method="post">
        <h2>基本信息</h2>
        <p>求职意向：<label><input type="text" name="user.job"></label></p>
        <p>姓名：<label><input type="text" name="user.username"></label></p>
        <p>专业：<label><input type="text" name="user.major"></label></p>
        <p>邮箱：<label><input type="text" name="user.email"></label></p>
        <p>手机：<label><input type="text" name="user.cellphone"></label></p>
        <p>现居地址：<label><input type="text" name="user.address"></label></p>
        <h2>教育背景</h2>
        <p>受教育时间段：<label><input type="text" name="user.eduDate"></label></p>
        <p>毕业院校：<label><input type="text" name="user.school"></label></p>
        <p>最高学历：<label><input type="text" name="user.education"></label></p>
        <p>主修课程：<label><input type="text" name="user.courseInfo"></label></p>
        <p>掌握技能：<label><input type="text" name="user.skillInfo"></label></p>
        <h2>工作经历</h2>
        <p><textarea name="user.workExperience" class="ckeditor"></textarea></p>
        <h2>自我评价</h2>
        <p><textarea name="user.selfEvaluation" class="ckeditor"></textarea></p>
        <h2>上传图片</h2>
        <p><a href="javascript:void(0);" onclick="selectPhoto()">点击上传图片</a>
            <input type="file" style="display: none;" id="photo-file" onchange="upload()">
            <input id="photo" name="user.photo" type="hidden" value="">
        </p>
        <p><img id="prev-photo" src="" alt="" width="300" height="200"></p>
        <input type="submit" value="保存">
    </form>
</div>
</body>

</html>