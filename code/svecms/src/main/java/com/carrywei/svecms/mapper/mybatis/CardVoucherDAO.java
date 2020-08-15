package com.carrywei.svecms.mapper.mybatis;

import com.carrywei.svecms.entity.po.CardVoucher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * CardVoucherDAO继承基类
 */
@Mapper
@Repository
public interface CardVoucherDAO extends MyBatisBaseDao<CardVoucher, Integer> {
}