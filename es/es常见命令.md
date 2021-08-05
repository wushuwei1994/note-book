## 基础命令
```
# 查看所有索引
GET /_cat/indices?v


# 搜索某个搜索下的所有数据
GET /base-product-spu-info/_search
{
  "query": {
    "match_all": {}
  }
}


#查看文档类型
GET /base-product-spu-info/_mapping

#查看索引
GET base-product-sku-info
GET base-product-spu-info

#创建索引
#注意在type类型上创建映射 ， 在es7中已经在内部取消了， type。 只不过还保留着基本的语法留着过度，因此需要改成这下面这种方法，把索引下面的类型去掉
PUT base-product-spu-info_new
{
  "mappings": {
    "properties" : {
        "brandId" : {
          "type" : "long"
        },
        "brandName" : {
          "type" : "text",
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        },
        "createTime" : {
          "type" : "date"
        },
        "discount" : {
          "type" : "float"
        }
      }
  }
}


#查看所有文档
GET base-product-spu-info/_search

# 复制索引数据
POST _reindex
{
  "source": {
    "index": "base-product-spu-info"
  },
  "dest": {
    "index": "base-product-spu-info_new"
  }
}


# 删除索引
DELETE base-product-spu-info_new

#查看type为「_doc」，ID为「96」的文档
GET base-product-sku-info/_doc/80

#查看type为「_doc」，ID为「96」的文档
GET base-product-spu-info/_doc/80

#更新ID为「96」的文档（只更新指定字段）
POST base-product-spu-info/_doc/61/_update
{
  "doc":{
  "spuStatus": 1,
  "isDeleted": 0
  }
}

POST base-product-spu-info/_update/80
{
  "doc":{
    "isRecommend": 1,
    "saleNum": 160,
    "salePrice": 700,
    "originPrice": 1000,
    "discount": 7.0
  }
}

#根据查询条件批量更新数据
POST base-product-spu-info/_doc/_update_by_query
{
  "query": {
    "match_all": {}
  },
  "script": {
    "inline": "ctx._source['spuStatus'] = 1;ctx._source['isDeleted'] = 0"
  }
}

#更新ID为「96」的文档（完全覆盖更新）
PUT base-product-spu-info/_doc/96
{
  "id": 96,
  "weight":0.124
}



# 删除文档
DELETE base-product-spu-info/_doc/96

#查看所有文档
GET base-product-spu-info/_search
{
  "sort": [
    {
      "isRecommend": {
        "order": "desc"
      }
    },
    {
      "saleNum": {
        "order": "desc"
      }
    }
  ]
}

# 多字段查询
GET base-product-spu-info/_search
{
  "query": {
    "multi_match" : {
      "query":      "小 泰国",
      "fields":     [ "supplierName", "spuName" ],
      "tie_breaker": 0.3
    }
  },
  "from": 0, 
  "size": 3
}

# 多字段查询
GET base-product-spu-info/_search
{
  "query": {
    "multi_match" : {
      "query":      "brown fox",
      "type":       "best_fields",
      "fields":     [ "subject", "message" ],
      "tie_breaker": 0.3
    }
  }
}

# term查询
GET base-product-spu-info/_search
{
  "query": {
    "term": {
      "liveId": {
        "value": "1299914260059607042"
      }
    }
  }
}


## 复杂查询
GET test-base-product-spu-info/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "term": {
          "spuStatus": {
            "value": "1"
          }
        }},
        {
          "term": {
            "isDeleted": {
              "value": "0"
            }
          }
        },
      
        {
          "term": {
            "firstCatalog": {
              "value": "211"
            }
          }
        }
        ,
        {
          "match_phrase": {
            "akcActivityName": "爆品"
          }
        }
      ], 
      "should": [
        {
          "match": {
            "productSource": "1"
          }
        },
        {
          "bool": {
            "must": [
              {
                "match": {
                  "productSource": "2"
                }
              },
              {
                "range": {
                  "endDate": {
                    "gte": 1614740968721
                    }
                }
              }
            ]
          }
        }
      ]
    }
  }
}


## 增加字段
PUT /base-product-spu-info/_mapping
{
  
    "properties": {
      "profitRate": {
        "type": "float"
      },
      "activeBrandName": {
        "type": "keyword"
      }
    }
}
```
