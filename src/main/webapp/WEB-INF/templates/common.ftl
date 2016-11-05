<#--分页组件-->
<#macro pagination url param="">
    <#if page.list?? && page.pages gt 1>
    <div class="pagination">
        <ul>
            <#if page.pages gt 20>
                <li>
                    <#if page.hasPreviousPage>
                        <a href="${url}?p=1<#if param?has_content>&${param}</#if>">&lt;&lt;</a>
                    <#else>
                        <a href="javascript:">&lt;&lt;</a>
                    </#if>
                </li>
            </#if>
            <li>
                <#if page.hasPreviousPage>
                    <a href="${url}?p=${page.prePage}<#if param?has_content>&${param}</#if>">&lt;</a>
                <#else>
                    <a href="javascript:">&lt;</a>
                </#if>
            </li>

            <#list page.navigatepageNums as nav>
                <li <#if nav == page.pageNum>class="active"</#if>>
                    <a href="${url}?p=${nav}<#if param?has_content>&${param}</#if>">${nav}</a>
                </li>
            </#list>

            <#if page.pages gt 20>
                <li>
                    <#if page.hasNextPage>
                        <a href="${url}?p=${page.nextPage}<#if param?has_content>&${param}</#if>">&gt;</a>
                    <#else>
                        <a href="javascript:">&gt;</a>
                    </#if>
                </li>

                <li class="last-pagination">
                    <#if page.hasNextPage>
                        <a href="${url}?p=${page.pages}<#if param?has_content>&${param}</#if>">&gt;&gt;</a>
                    <#else>
                        <a href="javascript:">&gt;&gt;</a>
                    </#if>
                </li>
            <#else>
                <li class="last-pagination">
                    <#if page.hasNextPage>
                        <a href="${url}?p=${page.nextPage}<#if param?has_content>&${param}</#if>">&gt;</a>
                    <#else>
                        <a href="javascript:">&gt;</a>
                    </#if>
                </li>
            </#if>
        </ul>
    </div>
    </#if>
</#macro>

<#--截取字符串, 超出部分用省略号代替-->
<#macro substring str len default=''>
    <#if str?? && str != ''>
        <#if str?length gt len>
        ${str?substring(0, len)}...
        <#else>
        ${str}
        </#if>
    <#else>
    ${default}
    </#if>
</#macro>