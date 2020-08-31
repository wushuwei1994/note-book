package com.carrywei.svecms.mapper.plus;

import com.carrywei.svecms.entity.po.CardVoucher;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Maps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardVoucherMapperTest {

    @Resource
    private CardVoucherMapper cardVoucherMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<CardVoucher> cardVoucherList = cardVoucherMapper.selectList(null);
        cardVoucherList.forEach(System.out::println);
        Maps.newHashMap()
    }

}