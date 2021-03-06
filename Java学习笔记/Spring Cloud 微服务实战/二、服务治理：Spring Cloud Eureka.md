### 服务治理

服务治理主要用来实现各个微服务实例化的自动化注册与发现。

* **服务注册：**在服务治理框架中，通常都会构建一个注册中心。每个服务单元向注册中心登记自己提供的服务，将主机与端口号、版本号、通信协议等一些附加信息告知注册中心，注册中心按服务名分类组织服务清单。服务清单示例：

  | 服务名 | 位置                                                       |
  | ------ | ---------------------------------------------------------- |
  | 服务A  | 192.168.0.100:8080、192.168.0.101:8080                     |
  | 服务B  | 192.168.0.100:9000、192.168.0.101:9000、192.168.0.102:9000 |

  各服务进程启动并向注册中心注册自己的服务之后，注册中心会维护类似上面的一个服务清单。服务注册中心还需要以心跳的方式去监测清单中的服务是否可用，若不可用需要从服务清单中剔除，达到排除故障服务的效果。

* **服务发现：** 由于在服务治理框架下运作，服务的调用不用通过指定具体的实例地址来实现，而是通过服务名发起请求调用调用实现。调用方不知道具体的服务实例位置，所以，调用方需要向服务注册中心咨询服务，并获取所有服务的实例清单，以实现对具体服务实例的访问。 