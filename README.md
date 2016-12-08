## 环信服务器端jar

本项目支持使用[Maven](http://maven.apache.org)构建, 具体使用方式请参考maven的使用文档和pom.xml



如果使用[Gradle](http://gradle.org)进行构建, 可以直接导入到IDE中, 例如



### 导入到eclipse中:

在命令行中运行

    gradlew.bat eclipse
    
这个命令会生成eclipse的项目文件, 然后可以通过eclipse的import工具导入

### 导入到Intellij中:

在命令行运行

    gradlew.bat idea
    
然后直接在Intellij中打开这个项目



### 如何使用

* 添加引用

`<dependency>
<groupId>com.easemob.rest</groupId>
<artifactId>huanxin</artifactId>
<version>1.0.0</version>
</dependency>`
	
* Spring添加扫描

	"com.che.easemob"

* 环信应用配置信息
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

* 使用