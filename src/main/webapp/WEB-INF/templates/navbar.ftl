<#assign key = RequestParameters.key!'' />

<nav class="navbar navbar-fixed-top" id="navbar">
    <div class="pull-left margin-left-20">
        <a href="${ctx}/" class="font-22 letter-1">${appAuthor}</a>
    </div>

    <div class="pull-left hidden-sm">
        <ul class="nav-list">
        <#include "navs.ftl">
        </ul>
    </div>

    <div class="pull-right show-sm hidden margin-right-20 toggle-panel">
        <div class="toggle-button"
             onclick="var navs=document.getElementById('toggle-list-id');if(navs.className=='toggle-list hidden'){navs.className='toggle-list'}else{navs.className='toggle-list hidden'};">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <ul class="toggle-list hidden" id="toggle-list-id">
            <#include "navs.ftl">
            </ul>
        </div>
    </div>

    <div class="pull-right hidden-md show-lg">
        <form action="${ctx}/search" method="get" novalidate>
            <input class="search" type="text" name="key" value="${key!''}" placeholder="搜一搜:空格分词,支持拼音"/>
        </form>
    </div>
</nav>