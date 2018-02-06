# mystruts2learning
Struts2学习
## Struts2
struts.xml配置文件

    <!-- 动态方法绑定注册 -->
    <constant name="struts.enable.DynamicMethodInvocation" value="true" />
     
    <!-- 继承于 struts-default的根目录，默认情况下是"/" -->
    <package name="front" extends="struts-default">	
    	<action name="hello" class="com.mrhu.struts.IndexAction" method="execute" >
		   	<!-- 可以不加name属性，默认为success -->
		   	<result name="success">
		   		/Hello.jsp
		   	</result>
    	</action>
    	
    	<action name="index2" class="com.mrhu.struts.IndexAction1" method="execute">
    		<result name="success">
    			/Error.jsp
    		</result>
    	</action>
		<action name="index3" class="com.mrhu.struts.Test" method="execute">
    		<result name="success">
    			/index.jsp
    		</result>
    	</action>
   
    </package>
    
    
    <package name="user" extends="front" namespace="/user">
     
    	<action name="userAdd" class="com.mrhu.struts.T0500.UserAction" method="add">
    		<result>/UserAddSuccess.jsp</result>
    	</action>
    	
    	<!-- 动态方法绑定，访问时使用actionName!methodName方式访问 -->
    	<action name="userABB" class="com.mrhu.struts.T0500.UserAction">
    		<result>/UserAddSuccess.jsp</result>
    		<!-- 
    			当不设置全局允许方法时需要额外对action进行指定方法
    			struts2的2.5版本需要额外指定allowed-methods属性，为了增强安全性
    		 -->
    		<allowed-methods>add</allowed-methods>
    	</action>
    </package>

	<package name="actions" extends="front" namespace="/actions">
		
		<!-- 
			注册通配符的使用
			注意！
			约定优于配置原则
		-->
		<global-allowed-methods>regex:.*</global-allowed-methods>
	
		<action name="Student*" class="com.mrhu.struts.wildcard.StudentAction" method="{1}">
			<result>/Student{1}_success.jsp</result>
		</action> 
		
		<action name="*_*" class="com.mrhu.struts.wildcard.{1}Action" method="{2}">
			<result name="success">/{1}{2}_success.jsp</result>
			<result name="error">/{1}{2}_error.jsp</result>
		</action>
	</package>
web.xml配置文件
```
  <!-- 默认处理页面 -->
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
  
  <!-- 拦截器 -->
  <!-- START SNIPPET: filter -->
    <filter>
        <filter-name>action2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>
    <!-- END SNIPPET: filter -->

    <filter-mapping>
        <filter-name>action2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```
struts2最小开发jar包
![struts2最小开发jar包.png](http://upload-images.jianshu.io/upload_images/7364514-6abd7ef9145f1984.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

三种实现Action的方法
1.自己写一个可以返回String类型的方法
2.实现Action接口
3.继承于ActionSupport类（推荐）
