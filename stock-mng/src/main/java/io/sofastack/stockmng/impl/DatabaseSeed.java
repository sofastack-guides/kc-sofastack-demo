package io.sofastack.stockmng.impl;

import java.math.BigDecimal;

public class DatabaseSeed {
    public static String[] name = new String[] {
        "未来架构: 从服务化到云原生",
        "Cloud Native Go: 构建基于Go和React的云原生Web应用与微服务",
        "云原生Java: Spring Boot、Spring Cloud与Cloud Foundry弹性系统设计",
        "Python云原生: 构建应对海量用户数据的高可扩展Web应用",
        "深入浅出Istio: Service Mesh快速入门与实践"
    };

    public static BigDecimal[] price = new BigDecimal[] {
        new BigDecimal(99),
        new BigDecimal(69),
        new BigDecimal(128),
        new BigDecimal(89),
        new BigDecimal(79),
    };

    public static String[] description = new String[] {
        "{\n"
            + "  \"description\": "
            + "\"<div><p"
            +
            ">互联网架构不断演化，经历了从集中式架构到分布式架构，再到云原生架构的过程。云原生因能解决传统应用升级缓慢、架构臃肿、无法快速迭代等问题而成了未来云端应用的目标。《未来架构：从服务化到云原生》首先介绍架构演化过程及云原生的概念，让读者对基础概念有一个准确的了解，接着阐述分布式、服务化、可观察性、容器调度、Service Mesh、云数据库等技术体系及原理，并介绍相关的SkyWalking、Dubbo、Spring Cloud、Kubernetes、Istio等开源解决方案，最后深度揭秘开源分布式数据库生态圈ShardingSphere的设计、实现，以及进入Apache基金会的历程，非常适合架构师、云计算从业人员阅读、学习。</p><div><b>张亮</b><p>京东数科数据研发负责人，Apache Sharding-Sphere发起人兼PPMC成员。热爱分享，拥抱开源，主张代码优雅化，擅长以Java为主的分布式架构及以Kubernetes和Mesos为主的云平台的构建。ShardingSphere已进入Apache软件基金会，是京东集团首个进入Apache的开源项目，也是Apache首个分布式数据库中间件。</p><b>吴晟</b><p>Apache SkyWalking创始人及PPMC成员，Apache ShardingSphere原型作者及PPMC成员，Apache Zipkin贡献者，Apache孵化器导师，CNCF基金会OpenTracing标准化委员会成员，W3C Trace Context规范贡献者。擅长分布式架构、性能监控与诊断、分布式追踪、云原生监控等领域。</p><b>敖小剑</b><p>具有十七年软件开发经验，资深码农，微服务专家，Cloud Native拥护者，敏捷实践者，ServiceMesh布道师，ServicelMesher中文社区联合创始人。专注于基础架构建设，对微服务、云计算等相关技术有着深入研究和独到见解。</p><b>宋净超</b><p>蚂蚁金服云原生布道师，ServiceMesher中文社区联合创始人，Kubemetes社区成员，Istio社区成员，《Cloud Native Go》《Python云原生》《云原生Java》等图书译者。</p></div></div>\",\n"
            + "  \"author\": \"张亮, 吴晟, 敖小剑, 宋净超\",\n"
            + "  \"image_url\": \"http://reserved-antcloud-cnshnfpub-opsware-v2.oss-cn-shanghai.aliyuncs"
            + ".com/fas/books/1.png?OSSAccessKeyId=RZU9wKztYEqaBQGB&Expires=1647166160&Signature=xCS%2FpJtY8"
            + "%2FVcdbLqfjHUp6z%2FoOw%3D\"\n"
            + "}\n",

        "{\n"
            + "  \"description\": \"<div><p>本书旨在向开发人员展示如何构建适用于大流量、高并发场景下的云原生Web应用。本书从搭建开发测试环境开始，逐步介绍使用Go"
            + "语言构建微服务的方法，通过引入CI/CD流程和Wercker、Docker等工具将应用推送到云中。结合微服务构建中的后端服务、数据服务、事件溯源和CQRS模式、基于React和Flux的UI"
            + "设计等，本书最后构建了一个基于Web的RPG游戏World of FluxCraft，可以作为使用Go构建云原生Web应用的参考，适合于云计算与Go语言编程从业者们阅读。</p><div><b>1"
            + "．云原生是云计算时代的发展趋势和必然结果</b><p>《Cloud Native "
            + "Go：构建基于Go和React的云原生Web应用与微服务》通过一个云原生应用项目的构建，为大家介绍了云原生的道与术，引导读者了解云原生理念的产生、应用场景、优势。</p><b>2"
            + "．集现今诸多热点技术之大成</b><p>《Cloud Native Go：构建基于Go和React的云原生Web应用与微服务》在构建云原生项目时，涉及Docker、持续集成、微服务、DevOps"
            + "、事件溯源与CQRS等众多备受关注的技术热点，无疑会让读者受益匪浅。</p><b>3．Go语言助理云开发完美实现</b><p>Go"
            + "语言以其简单优雅、快速安全、支持高并发等特性，成为云计算时代的最优语言。《Cloud Native "
            + "Go：构建基于Go和React的云原生Web应用与微服务》将带领读者正确认识Go语言，掌握用Go构建应用程序的方法。</p><b>4．流程完整，示例具体详细</b><p>《Cloud Native "
            + "Go：构建基于Go和React的云原生Web应用与微服务》从搭建平台开始，逐步带领读者开发一个完整的云上项目。其中的每一环节都有详细讲解。示例具有代表性，代码详细，帮助读者轻松掌握云原生开发的关键。</p"
            + "></div></div>\",\n"
            + "  \"author\": \"Kevin Hoffman, 宋净超\",\n"
            + "  \"image_url\": \"http://reserved-antcloud-cnshnfpub-opsware-v2.oss-cn-shanghai.aliyuncs"
            + ".com/fas/books/2.png?OSSAccessKeyId=RZU9wKztYEqaBQGB&Expires=1647166182&Signature"
            + "=U4ep6Dsh4w8TqW6tLlDLoEopIm4%3D\"\n"
            + "}\n",

        "{\n"
            + "  \"description\": \"<div><p>无论是传统IT行业，还是互联网行业，都正处于行业历史上最剧烈的变革中 ：大量的系统正在从传统的IT架构转向基于云的架构， "
            + "开发模式也正在从开发和运维分工的传统模式，逐渐转向统一的“DevOps”模式。Java技术已经进入了新的生命周期，大量被用于构建现代的、基于云的应用程序。 "
            + "本书详细阐述了开发云原生应用程序的机遇和挑战，明确指出了成功实现的方向，并且重点介绍了微服务框架Spring Boot。Spring Boot可以轻松创建任何粒度的 "
            + "Spring服务，并部署到现代的容器环境中。本书主要面向正在使用 Spring Boot、SpringCloud和Cloud Foundry， 以便更快、更好地构建软件的Java/JVM "
            + "开发人员。本书一共分为4个部分共15章。第1章和第2章介绍了云原生思想产生的背景，然后介绍了Spring Foundry。第3章介绍了如何配置Spring "
            + "Boot应用程序。第4章介绍了如何测试Spring应用程序，从如何测试最简单的组件到测试分布式系统。第5章介绍了可以将应用程序迁移到Cloud "
            + "Foundry等云平台的轻量级重构方式。第6章介绍了如何使用Spring构建HTTP和RESTful服务。第7章介绍了在分布式系统中控制请求进出的常用方法。第8章介绍了如何构建一个响应外部请求的服务。第9"
            + "章介绍了如何使用Spring Data在Spring中管理数据。这为领域驱动的思想奠定了基础。第10章介绍了如何使用Spring中事件驱动、消息中心化的能力，来集成分布式服务和数据。第11"
            + "章介绍了如何利用云平台（如Cloud Foundry）的能力来处理长期运行的工作。第12章介绍了在分布式系统中管理状态的一些方法。第13章介绍了如何构建具备可观测性和可操作性的系统。第14"
            + "章介绍了如何构建类似于Cloud Foundry平台的服务代理。第15章介绍了持续交付背后的思想。</p><div><b>1. 基础知识</b><p>了解云原生思维背后的动机；配置和测试Spring "
            + "Boot应用程序；将您的传统应用程序迁移至云端</p><b>2. 微服务</b><p>使用Spring构建HTTP和RESTful服务；在分布式系统中路由请求；建立更接近数据的边缘服务</p><b>3. "
            + "数据整合</b><p>使用Spring Data管理数据，并将分布式服务与——Spring对事件驱动、以消息传递为中心架构的支持——集成起来</p><b>4. "
            + "生产</b><p>让您的系统可观察；使用服务代理来连接有状态的服务；了解持续交付背后的重要思想</p></div></div>\",\n"
            + "  \"author\": \"Josh Long, 张若飞, 宋净超\",\n"
            + "  \"image_url\": \"http://reserved-antcloud-cnshnfpub-opsware-v2.oss-cn-shanghai.aliyuncs"
            + ".com/fas/books/3.png?OSSAccessKeyId=RZU9wKztYEqaBQGB&Expires=1647166193&Signature"
            + "=WfYCQ1S8XLuqj7oCGxHYTH3VNdc%3D\"\n"
            + "}\n",

        "{\n"
            + "  \"description\": \"<div><p>《Python云原生：构建应对海量用户数据的高可扩展Web应用》以一个应用开发贯穿始终，从云原生和微服务的概念原理讲起，使用Python"
            + "构建云原生应用，并使用React构建Web视图。为了应对大规模的互联网流量，使用了Flux构建UI和事件溯源及CQRS模式。考虑到Web应用的安全性，《Python"
            + "云原生：构建应对海量用户数据的高可扩展Web应用》对此也给出了解决方案。书中对于关键步骤进行了详细讲解并给出运行结果。读者可以利用Docker容器、CI/CD工具，敏捷构建和发布本书示例中的应用到AWS"
            + "、Azure这样的公有云平台上，再利用平台工具对基础设施和应用的运行进行持续监控。</p><div><b>云原生是云计算时代的发展趋势和必然结果</b><p>云原生将持续领航云时代架构理念</p><b"
            + ">用Python语言进行开发</b><p>易如门，易掌握，集现今诸多热点技术之大成</p><b>流程完整，示例具体详细</b><p>一个实际开发案例贯穿始终，全面开放代码</p></div></div"
            + ">\",\n"
            + "  \"author\": \"Manish Sethi, 宋净超\",\n"
            + "  \"image_url\": \"http://reserved-antcloud-cnshnfpub-opsware-v2.oss-cn-shanghai.aliyuncs"
            + ".com/fas/books/4.png?OSSAccessKeyId=RZU9wKztYEqaBQGB&Expires=1647178695&Signature"
            + "=9l4JHy7eMQVj3T3mXgRpAN9wdPI%3D\"\n"
            + "}\n",

        "{\n"
            + "  \"description\": \"<div><p>Google联合IBM、Lyft推出的Istio，一经问世就受到了人们的普遍关注，其热度迅速攀升，成为Service "
            + "Mesh（服务网格）方案的代表项目。本书整理了Istio中的部分概念和案例，以快速入门的形式，对Istio的基础用法一一进行讲解，并在书末给出一些试用方面的建议。<br/>在本书中，前3"
            + "章从微服务和服务网格的简短历史开始，讲述了服务网格的诞生过程、基本特性及Istio的核心功能，若对这些内容已经有所了解，则可以直接从第4章开始阅读；第4、5章分别讲解了Istio的配置和部署过程；第6"
            + "章至第9章，通过多个场景来讲解Istio的常用功能；第10章结合了笔者的实践经验，为读者提供了Istio的一系列试用建议。本书没有采用官方复杂的Book "
            + "Info应用案例，而是采用客户端+简单HTTP服务端的案例，读者随时都能在短时间内启动一个小的测试。<br/>本书面向对服务网格技术感兴趣，并希望进一步了解和学习Istio"
            + "的中高级技术人员，假设读者已经了解Kubernetes的相关概念并能够在Kubernetes上熟练部署和管理微服务。若希望全面、深入地学习Kubernetes，可参考《Kubernetes "
            + "权威指南：从Docker到Kubernetes实践全接触》和《Kubernetes 权威指南：企业级容器云实战》。</p><div><b>快速入门Service "
            + "Mesh和实践</b><p>手把手快速入门Service Mesh和实践，并根据Istio 1.1版本的升级，将源码及内容同步更新至GitHub</p><b>作者为Kubernetes "
            + "权威指南作者之一</b><p>作者为Kubernetes 权威指南作者之一，Istio、Kubernetes项目成员，Istio"
            + ".io主要贡献者之一</p><b>知名大咖热评</b><p>知名大咖敖小剑、马全一、张琦及《Kubernetes 权威指南》作者龚正等热评！</p></div></div>\",\n"
            + "  \"author\": \"崔秀龙\",\n"
            + "  \"image_url\": \"http://reserved-antcloud-cnshnfpub-opsware-v2.oss-cn-shanghai.aliyuncs"
            + ".com/fas/books/5.png?OSSAccessKeyId=RZU9wKztYEqaBQGB&Expires=1647179151&Signature=LIY"
            + "%2F56jF8Out5eHsxAU1hkUOp7o%3D\"\n"
            + "}\n",
    };
}
