### 1.如何使用

* 1.添加引用

`<dependency>
<groupId>com.easemob.rest</groupId>
<artifactId>huanxin</artifactId>
<version>1.0.2</version>
</dependency>`
	
* 2.Spring添加扫描包

	"com.che.easemob"

	
* 3.环信应用配置信息
	* hx.api_protocal=https
	* hx.appkey=*913111111k3dab2j#aichegujia*
	* hx.api_host=a1.easemob.com
	* hx.api_org=*913101111111*
	* hx.api_app=ai111111
	* hx.app_client_id=*YXA6TG9_cGXPEeaFPB1111*
	* hx.app_client_securt=*YXA6TiNyiI11111111*
	* hx.app_imp_lib=httpclient
	* hx.manageruser=*che_1111*
	* hx.manageruserpasswd=*chea11111*

* 4.使用说明
	* 1.该应用使用在spring 相关框架中，直接扫描包com.easemob.rest,并在web项目中配置环信应用配置信息，
	* 2. 直接在Service层或者Controller层注入便可使用
	* `@Autowired`
    `private EmchatService emchatService;`


* 5.接口方法说明：
	* 0.接口：com.che.easemob.service.EmchatService
	* 1.创建im聊天新用户(单个)
		* `mResponse createNewIMUser(ImUser imuser)`
	* 2.创建im聊天新用户（批量）、
		* `ImResponse createNewIMUserBatch(List<ImUser> imusers)`
	* 3.根据用户名查询环信用户信息
		* `ImResponse getImUserByUserName(String userName)`
	* 4.批量查询用户新
		* `ImResponse getImUsersBatch(Long limit);`
	* 5.系统向某用户发送普通消息
		* `ImResponse sendMessage(String[] userNames,String mess);`
	* 6.系统向某用户发送透传消息
		* `ImResponse sendCmdMessage(String[] userName,String mess);`
	* 7.系统向某用户发送自定义消息
		* `ImResponse sendCustomTextMessage(String[] userName,String from, String mess,Map<String, String> ext);`





### 2.环信服务器端jar

本项目支持使用[Maven](http://maven.apache.org)构建, 具体使用方式请参考maven的使用文档和pom.xml



如果使用[Gradle](http://gradle.org)进行构建, 可以直接导入到IDE中, 例如



### 3.0 导入到eclipse中:

在命令行中运行

    gradlew.bat eclipse
    
这个命令会生成eclipse的项目文件, 然后可以通过eclipse的import工具导入

### 3.1 导入到Intellij中:

在命令行运行

    gradlew.bat idea
    
然后直接在Intellij中打开这个项目





