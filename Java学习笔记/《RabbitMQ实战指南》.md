## RabbitMQ实战指南

### 简介

#### 消息中间件的作用

* **解耦：**在项目启动之初来预测将来会碰到什么 需求是极其困难的。消息中间件在处理过程中间插入了一个隐含的、基于数据的接口层，两边的处理过程都要实现这一接口，这允许你独立地扩展或修改两边的处理过程，只要确保它们遵守同样的接口约束即可
* **冗余（存储）：**有些情况下，处理数据的过程会失败。消息中间件可以把数据进行持久化直到它们已经被完全处理，通过这一方式规避了数据丢失风险。在把 个消息从消息中间件中删除之前，需要你的处理系统明确地指出该消息己经被处理完成，从而确保你的数据被安全地保存直到你使用完毕。

* **扩展性：** 因为消息中间件解耦了应用的处理过程，所以提高消息入队和处理的效率是很容易的，只要另外增加处理过程即可，不需要改变代码，也不需要调节参数。
* **削峰：** 在访问量剧增的情况下，应用仍然需要继续发挥作用，但是这样的突发流 并不常见。如果以能处理这类峰值为标准而投入资源，无疑是巨大的浪费 使用消息中间件能够使关键组件支撑突发访问压力，不会因为突发的超负荷请求而完全崩惯
* **可恢复性：** 当系统一部分组件失效时，不会影响到整个系统 消息中间件降低了进程间的
  稿合度，所以即使 个处理消息的进程挂掉，加入消息中间件中的消息仍然可以在系统恢复后
  进行处理
* **顺序保证：** 在大多数使用场景下，数据处理的顺序很重要，大部分消息中间件支持 定程
  度上的顺序性。
* **缓冲：** 在任何重要的系统中，都会存在需要不同处理时间的元素。消息中间件通过 个缓
  冲层来帮助任务最高效率地执行，写入消息中间件的处理会尽可能快速 该缓冲层有助于控制
  和优化数据流经过系统的速度。
* **异步通信：** 在很多时候应用不想也不需要立即处理消息 消息中间件提供了异步处理机制，
  允许应用把 些消息放入消息中间件中，但并不立即处理它，在之后需要的时候再慢慢处理



#### 简单demo

生产者

```
package com.carrywei.svecms.mq.rabbit.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitProducer {
    public static final String EXCHANGE_NAME = "exchange_demo";
    public static final String ROUTING_KEY = "routingkey_demo";
    public static final String QUEUE_NAME = "queue_demo";
    public static final String IP_ADDRESS = "192.168.4.81";
    public static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("root");
        factory.setPassword("root");

        Connection connection = factory.newConnection(); // 创建连接
        Channel channel = connection.createChannel(); // 创建信道
        // 创建一个type="direct"、持久化的、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        // 创建一个持久化、非排他的、非自动删除的队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 将交换器与队列通过路由键绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        // 发送一条持久化的消息：Hellp world!
        String message = "Hello world";
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        // 关闭资源
        channel.close();
        connection.close();
    }
}
```

消费者

```
package com.carrywei.svecms.mq.rabbit.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{
                new Address(RabbitProducer.IP_ADDRESS, RabbitProducer.PORT)
        };
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
        Connection connection = connectionFactory.newConnection(addresses);
        final Channel channel = connection.createChannel();
        channel.basicQos(64); // 设置客户端最多未接受未被ack的消息的个数
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message:" + new String(body));
                System.out.println(System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        channel.basicConsume(RabbitProducer.QUEUE_NAME, consumer);
        System.out.println(System.currentTimeMillis());
        // 等待回调函数执行完毕之后，关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }

}
```

### RabbitMQ入门

#### 相关概念介绍

**Producer：**生产者。生产者创建消息，然后发布到RabbitMQ中

**Message：**消息，一般可以包含2个部分，消息体（payload [有效负荷]）和标签（Label）

**消息标签：**用来表述这条消息，比如一个交换器的名称和一个路由键

**Consumer ：**消费者，就是接收消息的一方。消费者连接到 RabbitMQ 服务器，并订阅到队列上。当消费者消费 条消息时，只是消费消息的消息体（ payload ）。在消息路由的过程中，消息的标签会丢弃，存入到队列中的消息只有消息体，消费者也只会消费到消息体，也就不知道消息的生产者是谁，当然消费者也不需要知道。

**Broker：**消息中间件的服务节点。对于 RabbitMQ 来说， RabbitMQ Broker 可以简单地看作一个 RabbitMQ 服务节点，或者 RabbitMQ 服务实例。大多数情况下也可以将 RabbitMQ Broker 看作 RabbitMQ服务器

**Queue：**队列，是 RabbitMQ的内部对象，用于存储消息 。多个消费者可以订阅同一个队列，这时队列中的消息会被平均分摊（Round-Robin ，即轮询）给多个消费者进行处理，而不是每个消费者都收到所有的消息井处理.

**Exchange：**交换器，生产者将消息发送到 Exchange （交换器，通常也可以用大写的“ ”来表示），由交换器将消息路由到一个或者多个队列中。如果路由不到，或许会返回给生产者，或许直接丢弃。

**RoutingKey ：**路由键，生产者将消息发给交换器的时候， 一般会指定一个 RoutingKey ，用来指定这个消息的路由规则，而这个 Routing Key 需要与交换器类型和绑定键（ BindingKey ）联合使用才能最终生效。

**Binding ：**绑定 ，RabbitMQ 中通过绑定将交换器与队列关联起来，在绑定的时候一般会指定一 个**绑定键（BindingKey ）**，这样 RabbitMQ 就知道如何正确地将消息路由到队列

**Connection：**连接，无论生产者还是消费者，都需要和 RabbitMQ Broker 建立连接，这个连接就是一条 TCP 连接，也就是Connection

**Channel：**信道，一旦TCP 连接建立起来，客户端紧接着可以创建一个 AMQP 信道（ Channel) ，每个信道都会被指派一个唯一的ID 。信道是建立在 Connection 之上的虚拟连接， RabbitMQ 处理的每条 AMQP 指令都是通过信道完成的。

>我们完全可以直接使用 Connection 就能完成信道的工作，为什么还要引入信道呢？试想这
>样一个场景， 个应用程序中有很多个线程需要从 RabbitMQ 中消费消息，或者生产消息，那
>么必然需要建立很多个 Connection ，也就是许多个 TC 连接。然而对于操作系统而言，建立和
>销毁 TCP 连接是非常昂贵的开销，如果遇到使用高峰，性能瓶颈也随之显现。 RabbitMQ 采用
>类似 NI01 (Non-blocking 110 ）的做法，选择 TCP 连接复用，不仅可以减少性能开销，同时也
>便于管理。
>
>每个线程把持一个信道，所以信道复用了 Connection TCP 连接。同时 RabbitMQ 可以确
>保每个线程的私密性，就像拥有独立的连接一样。当每个信道的流量不是很大时，复用单
>Connection 可以在产生性能瓶颈的情况下有效地节 TC 连接资源。但是当信道本身的流量很
>大时，这时候多个信道复用一个 Connection 就会产生性能瓶颈，进而使整体的流量被限制了。
>此时就需要开辟多个 Connection ，将这些信道均摊到这些 Connection 中，

#### AMQP协议相关指令

* Basic.Publish  消息发送
* Basic.Consume 消息消费（推模式）
* Basic.get 消息获取（拉模式）

#### 相关参数

##### 交换器类型 type

* **fanout**  把所有发送到该交换器的消息路由到所有与该交换器绑定的队列中

* **direct ** 它会把消息路由到那些 BindingKey、RoutingKey完全匹配的队列中

* **topic**  topic 类型的交换器在匹配规则上进行了扩展，它与 direct 类型的交换器相似，也是将消息路由到 BindingKey RoutingKey 相匹配的队列中，但这里的匹配规则有些不同，它约定

  * RoutingKey 为一个点号“ ”分隔的字符串（被点号“．”分隔开的每 段独立的字符
    串称为一个单词），如“com.rabbi q.client ＇，、＂java. util.concurrent ”、“ com.hidden .client“
  * BindingKey和RoutingKey 一样也是点号“．”分隔的字符串；
  * BindingKey 中可以存在两种特殊字符串“＊”和“＃”，用于做模糊匹配，其中“*”用于匹配一个单词，“#”用于匹配多规格单词（可以是零个）。

  >示例：
  >
  >Queue1与Exchange 通过 “\*.rabbitmq.\*”绑定
  >
  >Queue2与Exchange通过“\*.\*.client”和“com.#”绑定
  >
  >则
  >
  >路由键为“com.rabbitmq.client ”的消息会同时路由到Queue1和Queue2
  >路由键为“com.hidden.client ”的消息只会路由到 Queue2 中
  >路由键为“com.hidden.demo 的消息只会路由到 Queue2 中
  >路由键为“java.rabbitmq.demo ”的消息只会路由到 Queue1中
  >路由键为“java.util.concurrent ”的消息将会被丢弃或者返回给生产者（需要设置mandatory 参数），因为它没有匹配任何路由键。

* **headers** headers 类型的交换器不依赖于路由键的匹配规则来路由消息，而是根据发送的消息内容中headers 属性进行匹配。在绑定队列和交换器时制定一组键值对，当发送消息到交换器时，RabbitMQ 会获取到该消息的 headers （也是一个键值对的形式〉，对比其中的键值对是否完全匹配队列和交换器绑定时指定的键值对，如果完全匹配则消息会路由到该队列，否则不会路由到该队列 headers 类型的交换器性能会很差，而且也不实用，基本上不会看到它的存在。