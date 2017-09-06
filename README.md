# scala_demo


### run in intellij idea:
1. install scala plugins
2. new scala project ,choose this project directory
3. add scala sdk from your dev  environment (install scala before)
4. add akka sdk (/lib directory and /lib/akka/ directory) from your dev  environment(install akka)  <br/>
`$ cd /Users/jboner/tools/akka-2.0
 $ export AKKA_HOME=`pwd`
 $ echo $AKKA_HOME
 /Users/jboner/tools/akka-2.0`
 5. 
 
 
 
### link
+ Scala从零开始：使用Intellij IDEA写hello world:<http://www.tuicool.com/articles/BzI3UfZ>
+ <http://www.scala-lang.org/api/current/#package>

---
+  入门指南 (Scala):<http://www.gtan.com/akka_doc/intro/getting-started-first-scala.html>
+ Windows平台下sbt的安装设置:<http://my.oschina.net/u/915967/blog/146746>
+ 在Java项目中整合Scala:<http://www.2cto.com/kf/201310/249427.html>
 1. 在IntelliJ中安装Scala插件
 2. 添加如下Maven Dependency
 ```xml
 <dependency>  
            <groupId>org.scala-lang</groupId>  
            <artifactId>scala-library</artifactId>  
            <version>2.10.1</version>  
        </dependency>  
 ```
 3. 同时添加如下plugin
 ```xml
 <plugin>  
                <groupId>org.apache.maven.plugins</groupId>  
                <artifactId>maven-surefire-plugin</artifactId>  
                <version>2.8.1</version>  
                <configuration>  
                    <includes>  
                        <include>**/*.java</include>  
                        <include>**/*.scala</include>  
                    </includes>  
                </configuration>  
            </plugin>  
            <plugin>  
                <groupId>org.scala-tools</groupId>  
                <artifactId>maven-scala-plugin</artifactId>  
                <version>2.15.2</version>  
                <executions>  
                    <execution>  
                        <id>scala-compile-first</id>  
                        <phase>process-resources</phase>  
                        <goals>  
                            <goal>compile</goal>  
                        </goals>  
                    </execution>  
                    <execution>  
                        <id>scala-test-compile</id>  
                        <phase>process-test-resources</phase>  
                        <goals>  
                            <goal>testCompile</goal>  
                        </goals>  
                    </execution>  
                </executions>  
            </plugin>  
  ```
  4. Scala代码中，我们实现了一个简单的Servlet返回Hello World
  ```java
       import org.springframework.stereotype.Controller  
     import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}  
     import javax.servlet.http.{HttpServletRequest, HttpServletResponse}  
     import java.io.OutputStream  
     import org.apache.log4j.Logger  
     import org.apache.commons.io.IOUtils  
     import HelloWorldServlet._  

     @Controller  
     class HelloWorldServlet {  
       @RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))  
       def helloworld(request: HttpServletRequest, response: HttpServletResponse, outputStream: OutputStream) {  
         log.info("helloworld is called")  
         response.setStatus(HttpServletResponse.SC_OK)  
         IOUtils.write("HELLO WORLD!", outputStream)  
         outputStream.flush  
         outputStream.close  
       }  
     }  

     object HelloWorldServlet {  
       private var log: Logger = Logger.getLogger(classOf[HelloWorldServlet])  
     }  
  ````
