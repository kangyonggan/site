<ul class="breadcrumbs">
    <li>当前位置:</li>
    <li><a href="${ctx}/">${appAuthor}</a></li>
    <#if category?? && article??>
        <li>&gt;</li>
        <li><a href="${ctx}/category/${category.code}">${category.name}</a></li>
    </#if>
    <li>&gt;</li>
    <li class="active">${title!''}</li>
</ul>