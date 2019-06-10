# 使用 SOFAStack 快速构建微服务


## 实验内容

本实验基于 SOFAStack 快速构建一个微服务，主要包括以下几个部分：

* 使用 SOFABoot + SOFARPC 发布服务
* 使用 SOFABoot + SOFARPC 调用服务
* 通过 ZipKin 查看 SOFATracer 上报的信息

## 架构图
![pic](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*WtRuRr4fzxIAAAAAAAAAAABkARQnAQ)

## 任务

#### 1、任务准备

从  github 上将 demo 工程克隆到本地
```bash
git clone https://github.com/sofastack-guides/kc-sofastack-demo.git
```

然后将工程导入到 IDEA 或者 eclipse。导入之后界面如下：
![image.png](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*znWeR7-3MTMAAAAAAAAAAABkARQnAQ)

* sofastack-kubecon-service-facade : 提供接口，供 provider 和 consumer 使用
* sofastack-kubecon-service-provider : RPC 服务提供方
* sofastack-kubecon-service-consumer : RPC服务消费方

#### 2、引入依赖

![image.png](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*M_ddTJ6KO4wAAAAAAAAAAABkARQnAQ)

将下面的依赖引入到 sofastack-kubecon-service-consumer 和 sofastack-kubecon-service-provider 工程模块的 pom.xml 文件中。
```xml
<!--SOFARPC 依赖-->
<dependency>
  <groupId>com.alipay.sofa</groupId>
  <artifactId>rpc-sofa-boot-starter</artifactId>
</dependency>
<!--SOFATracer 依赖-->
<dependency>
  <groupId>com.alipay.sofa</groupId>
  <artifactId>tracer-sofa-boot-starter</artifactId>
</dependency>
<!--SOFARegistry 依赖-->
<dependency>
  <groupId>com.alipay.sofa</groupId>
  <artifactId>registry-client-all</artifactId>
</dependency>
<!--runtime 依赖-->
<dependency>
  <groupId>com.alipay.sofa</groupId>
  <artifactId>runtime-sofa-boot-starter</artifactId>
</dependency>
```
#### 3、添加配置

将如下配置复制到  sofastack-kubecon-service-consumer 和 sofastack-kubecon-service-provider 工程模块的 application.properties 中。
```properties
# 1、添加服务注册中心地址
com.alipay.sofa.rpc.registry-address=sofa://registry-1-dev.sofastack.tech:9603
# 2、添加 tracer 数据上报的服务端 zipkin 地址
com.alipay.sofa.tracer.zipkin.base-url=http://zipkin-dev.sofastack.tech:9411
```
![](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*QufcS5IxRMUAAAAAAAAAAABkARQnAQ)

#### 4、发布 SOFARPC 服务

如下图所示，在 HelloServiceImpl 类上加上 @SofaService 注解 和 @Service 注解，将其发布成一个 SOFARPC 服务：

![](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*Dk-BS5hvL2UAAAAAAAAAAABkARQnAQ)

注解参考：

```java
@Service
@SofaService(interfaceType = HelloService.class,bindings = {@SofaServiceBinding(bindingType = "bolt")})
```

增加之后的界面如下所示：

![](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*Pu-JRY5UlO0AAAAAAAAAAABkARQnAQ)

右击 ProviderApplication ，run ProviderApplication 启动应用

#### 5、引用 SOFARPC 服务

在 SimpleController 类中的 HelloService 变量上方加 @SofaReference 注解，用于引用 SOFARPC 服务:

![](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*nu2qTJCYCMAAAAAAAAAAAABkARQnAQ)

注解参考：

```java
@SofaReference(interfaceType = HelloService.class,binding = @SofaReferenceBinding(bindingType = "bolt"))
```

增加之后的界面如下所示：

![](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*ZoAYRa4k228AAAAAAAAAAABkARQnAQ)

右击 ConsumerApplication ，run ConsumerApplication 启动应用。

#### 6、实验验证

应用启动之后，通过浏览器访问：[http://localhost:8084/hello](http://localhost:8084/hello) ，正常情况下返回 hello sofastack 。浏览器访问 [http://zipkin-dev.sofastack.tech:9411](http://zipkin-dev.sofastack.tech:9411)，查看链路数据上报以链路关系图。

* 服务 span
![](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*V6M2RKbBZHEAAAAAAAAAAABkARQnAQ)

* 链路关系
![](https://gw.alipayobjects.com/mdn/rms_1a1552/afts/img/A*ve2lQKjvuPYAAAAAAAAAAABkARQnAQ)

#### 7、上报 lookout
待建设