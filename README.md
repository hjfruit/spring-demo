# 相关技术介绍

>[!tip] 在阅读详细技术文档之前，有必要对我们当前使用的技术做一份详细的介绍。

## 我们使用了哪些技术

> 技术选型
* <font color=#ffaa44>graphql</font>(我们使用了 <font color=#ffaa44>graphql</font>  替代了原本的 <font color=#ffaa44>json</font>),
  关于<font color=#ffaa44>graphql</font>的语法，可通过[此链接](https://spec.graphql.cn/)查看。
* <font color=#ffaa44>grpc</font>(同时我们选用了<font color=#ffaa44>grpc</font>作为后端的传输协议) ,关于 <font color=#ffaa44>grpc</font>
  的详细语法，可通过[此链接](https://grpc.io/docs/what-is-grpc/)查看

> 框架选型
* 整体微服务我们采用了consul作为配置中心和注册中心，同时数据库全部采用了postgres的方案。
* graphql 的相关框架使用了 netflix-dgs-framework,详情见[https://github.com/Netflix/dgs-framework](https://github.com/Netflix/dgs-framework)
* grpc 使用了如下gRPC-Spring-Boot-Starter,详情见[https://yidongnan.github.io/grpc-spring-boot-starter/zh-CN/](https://yidongnan.github.io/grpc-spring-boot-starter/zh-CN/)

## 如何开始项目

> 对于以上提到过的相关技术，如果你已经做了相关的了解，您可以根据此demo进行练习 。

## 项目结构
- 主目录
  - grpc-api 定义 protobuf 文件的工程
  - grpc-order 订单的grpc服务
  - grpc-customer 客户的grpc服务
  - grpc-supplier 供应商的服务

## 环境搭建
在

## 开始构建 grpc 项目

### 1. 定义 protobuf 文件

> 相比于 restful 接口, grpc 采用的是预先定义协议的模式。

```protobuf
syntax = "proto3"; // 指定 proto 的版本，我们这边使用的是 proto3

package fc.basic; // 定义 proto 的 package,此部分和下面的 java_package 相关。如果我们在下面不指定 java_package 的名称，编译器会将此名称当作包名

option java_multiple_files = true;
option java_package = "fc.proto.basic";
option java_outer_classname = "CustomerProto"; // 输出的 class 名称

// 在 protobuf 中，可以通过 import 去引用其他地方声明的实体
import "google/protobuf/wrappers.proto";

// 我们先定义一个实体
// 在 proto 中, 使用 message 开头定义实体
message Customer{
  // 对于 protobuf 的基本类型，我们这边不再进行赘述
  int64 id=1;
  string customer_name=2;
  string customer_address=3;
  // 在 protobuf 中，接口直接的调用不会根据名称去匹配值，而是根据名称对应的数字去匹配
}

// 接着，我们定义一个服务

service CustomerService{
    // 根据 id 查询客户
    rpc customer(google.protobuf.Int64Value) returns (Customer);
}
```

### 编译 protobuf 文件 

在定义好 protobuf 之后，我们需要将他编译为 java 文件。我们采用 protobuf-maven-plugin
这个插件进行编译

### 继承编译好的 grpc-service 完成我们的接口

## 开始构建 graphql 项目

```graphql
# Query 是整个 graphql 的跟查询节点.所有的查询都要从这里暴露出去
type Query {
    customer(id:ID):Customer
}

# 我们在这里声明一个 Customer 的 graphql 类型
type Customer{
    id:ID # graphql 特有的id类型，对应java里的String或者Long
    customerName:String
    customerAddress:String
}
```