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
    <title>${requestScope.user.username}的个人简历</title>
    <style>
        body,
        dl,
        dt,
        dd,
        ul,
        ol,
        li,
        p,
        h1,
        h2,
        h3 {
            padding: 0;
            margin: 0;
        }

        ol {
            padding-left: 20px;
            margin-bottom: 20px;
        }

        ol li {
            line-height: 30px;
            height: 30px;
        }

        p {
            line-height: 1.5em;
            /* 两端对齐 */
            text-align: justify;
            /* 首行缩进2字符 */
            text-indent: 2em;
        }

        ul {
            list-style-type: none;
        }

        .a4 {
            width: 744px;
            /* height: 1123px; */
            margin: 0 auto;
            border: 1px solid #e0e0e0;
            padding: 50px;
        }

        #base-info,
        #edu-info,
        #work-exp {
            margin-bottom: 20px;
        }

        #person-name {
            overflow: hidden;
        }

        #person-name h1,
        #person-name div {
            display: inline-block;
        }

        .deep-blue {
            color: #02194d;
        }

        .mb-10 {
            margin-bottom: 10px;
        }

        #person-name div {
            margin-left: 60px;
        }

        #person-name div span {
            font-weight: bold;
            font-size: 20px;
        }

        #base-info {
            position: relative;
        }

        #photo {
            position: absolute;
            right: 0;
            top: 0;
        }

        #base-info ul {
            margin-top: 20px;
            overflow: hidden;
            width: 520px;
        }

        #base-info ul li {
            float: left;
            width: 260px;
        }

        .title {
            border-bottom: 1px solid #02194d;
            margin-bottom: 20px;
        }

        .title span {
            font-size: 18px;
            padding: 2px 20px;
            color: #fff;
            background-color: #02194d;
        }

        .exp span {
            display: inline-block;
            width: 240px;
        }

        #edu-info dl {
            overflow: hidden;
        }

        #edu-info dt,
        #edu-info dd {
            float: left;
        }

        #edu-info dd {
            width: 664px;
            text-align: justify;
            line-height: 1.5em;
        }
        h3{padding-bottom: 10px;}
    </style>
</head>

<body>
<div class="a4">
    <div id="base-info">
        <div id="person-name">
            <h1 class="deep-blue">${requestScope.user.username}</h1>
            <div><span class="deep-blue">求职意向：</span>${requestScope.user.job}</div>
        </div>
        <div id="photo">
            <img src="${pageContext.request.contextPath}/upload/${requestScope.user.photo}.jpg" alt="简历图片" width="100" height="130">
        </div>
        <ul>
            <li>电话：${requestScope.user.cellphone}</li>
            <li>学历：${requestScope.user.education}</li>
            <li>邮箱：${requestScope.user.email}</li>
            <li>现居：${requestScope.user.address}</li>
        </ul>
    </div>
    <div id="edu-info">
        <h2 class="title"><span>教育背景</span></h2>
        <div class="exp mb-20"><span>${requestScope.user.eduDate}</span><span>${requestScope.user.school}</span><span>${requestScope.user.major}/本科</span></div>
        <dl class="mb-10">
            <dt>主修课程：</dt>
            <dd>${requestScope.user.courseInfo}</dd>
        </dl>
        <dl>
            <dt>掌握技能：</dt>
            <dd>${requestScope.user.skillInfo}</dd>
        </dl>
    </div>
    <div id="work-exp">
        <h2 class="title"><span>工作经历</span></h2>
        <div class="work-content">
            <div class="exp mb-10">
                <span>${requestScope.user.workExperience}</span>
            </div>
            <h3>工作内容:</h3>
            <ol>
                <li>根据产品设计完成前端项目需求的开发和维护工作</li>
                <li>模块化前端组件 ,优化前端工程架构,提高项目代码质量和性能</li>
                <li>参与项目技术方赛的制定 ,研究新兴技术框架并实践应用</li>
            </ol>

            <div class="exp mb-10">
                <span>20XX.XX~至今</span><span>广州XX信息技术有限公司</span><span>Web前端开发工程师</span>
            </div>
            <h3>工作内容:</h3>
            <ol>
                <li>负责 HTML和Javascript代码的编写与调试</li>
                <li>负责Web前端的程序设计、后台交互和功能实现</li>
                <li>负责与软件研发有关的文档的整理与编写</li>
                <li>负责就本职工作范围内的相关问题与其他部门和公司其他工作人员沟通与协调</li>
            </ol>

            <div class="exp mb-10">
                <span>20XX.XX~至今</span><span>广州XX信息技术有限公司</span><span>Web前端开发工程师</span>
            </div>
            <h3>工作内容:</h3>
            <ol>
                <li>负责项目前端技术架构设计,创建并完善前端工具和框架</li>
                <li>负封装良好的前端交互组件,结合前端技术建立或优化web的交互方式:</li>
            </ol>
        </div>
    </div>
    <div id="self-evaluation">
        <h2 class="title"><span>自我评价</span></h2>
        <p>${requestScope.user.selfEvaluation}</p>
    </div>
</div>
</body>

</html>