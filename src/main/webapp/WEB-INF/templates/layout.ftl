<#assign ctx="${(rca.contextPath)!''}">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>${appAuthor} - ${title!''}</title>
    <link rel="icon" type="image/ico" href="${ctx}/static/app/images/favicon.ico">
    <meta name="keywords" content="康永敢,康,勇敢,个人博客,个人网站,代码片段,代码,学习笔记,笔记,技术分享"/>
    <meta name="description" content="这是我的个人网站，主要是记录一写代码片段、学习笔记等。"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- inline styles related to this page -->
    <link rel="stylesheet" href="${ctx}/static/app/css/app.css"/>
<@block name="style"/>
</head>
<body class="theme">

<#include "navbar.ftl">

<div class="container">
<@block name="content"/>
</div>

<#include "footer.ftl">

<div class="scroll-bar hidden" id="scroll-bar">
    <a href="javascript:scroll(0,0)" class="top">&uarr;</a>
    <a href="javascript:scroll(0, 9999999999)" class="bottom">&darr;</a>
</div>

<script>
    window.onscroll = function () {
        if (document.documentElement.scrollTop + document.body.scrollTop > 100) {
            document.getElementById("scroll-bar").style.display = "block";
        } else {
            document.getElementById("scroll-bar").style.display = "none";
        }
    }
</script>
<@block name="script"/>

</body>
</html>
