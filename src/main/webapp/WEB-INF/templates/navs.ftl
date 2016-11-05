<@navs>
    <#list categories as c>
    <li <#if category?? && category.code==c.code>class="active"</#if>><a
            href="${ctx}/category/${c.code}">${c.name}</a></li>
    </#list>
</@navs>
