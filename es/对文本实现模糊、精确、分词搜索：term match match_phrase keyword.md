## 对文本实现模糊、精确、分词搜索：term match match_phrase keyword

索引base-product-spu-info有数据：

```
{
"spuName" : "【市场价2532】HUAWEI WATCH 2 Pro 4G智能手表 移动支付"
}
```

#### **term **搜索

* 关键字「智」搜索


```
GET base-product-spu-info/_search
{
  "query": {
    "term": {
      "spuName": {
        "value": "智"
      }
    }
  }
}
// 结果：搜索出数据
```

* 关键字「智能」搜索

```
GET base-product-spu-info/_search
{
  "query": {
    "term": {
      "spuName": {
        "value": "智能"
      }
    }
  }
}
// 结果：不能搜索出数据
```

* 关键字「Pro」搜索

```
GET base-product-spu-info/_search
{
  "query": {
    "term": {
      "spuName": {
        "value": "Pro"
      }
    }
  }
}
// 结果：不能搜索出数据
```

* 关键字「pro」搜索（小写）

```
GET base-product-spu-info/_search
{
  "query": {
    "term": {
      "spuName": {
        "value": "pro"
      }
    }
  }
}
// 结果：搜索出数据
```

* 关键字「【市场价2532】HUAWEI WATCH 2 Pro 4G智能手表 移动支付」搜索

```
GET base-product-spu-info/_search
{
  "query": {
    "term": {
      "spuName": {
        "value": "【市场价2532】HUAWEI WATCH 2 Pro 4G智能手表 移动支付"
      }
    }
  }
}
// 结果：不能搜索出数据
```

* 关键字「【市场价2532】HUAWEI WATCH 2 Pro 4G智能手表 移动支付」搜索（增加keyword关键字）

```
GET base-product-spu-info/_search
{
  "query": {
    "term": {
      "spuName.keyword": {
        "value": "【市场价2532】HUAWEI WATCH 2 Pro 4G智能手表 移动支付"
      }
    }
  }
}
// 结果：搜索出数据
```

* 对「【市场价2532】HUAWEI WATCH 2 Pro 4G智能手表 移动支付」分词

```
GET base-product-spu-info/_analyze
{
"analyzer": "standard",
  "text":  "【市场价2532】HUAWEI WATCH 2 Pro 4G智能手表 移动支付"
}
// 分词结果：市|场|价|2532|huawei|watch|2|pro|4g|智|能|手|表|移|动|支|付
```

**总结：term搜索是对搜索词不进行分词搜索，但对搜索的字段还是会分词，而加keyword属性，则是不分词的精准索引**

 

#### match搜索

```
GET base-product-spu-info/_search
{
  "query": {
    "match": {
      "spuName": "手机"
    }
  }
}
// 结果：搜索出数据
```

**总结：先对搜索词进行分词，再进行分词搜索**



#### match_phrase搜索

```
GET base-product-spu-info/_search
{
  "query": {
    "match_phrase": {
      "spuName": "智能手表"
    }
  }
}
// 结果：搜索出数据

GET base-product-spu-info/_search
{
  "query": {
    "match_phrase": {
      "spuName": "智能手表1"
    }
  }
}
// 结果：不能搜索出数据
```

**总结：短语搜索， 要求所有的分词必须同时出现在文档中，同时位置必须紧邻一致 **