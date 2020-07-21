package com.carrywei.svecms.entity.po;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 门店卡券表
 */
@Data
public class CardVoucher implements Serializable {
    /**
     * 主键
     */
    private Integer cardId;

    /**
     * 卡券详情ID（当前可用卡券详情）
     */
    private Integer cardDetailId;

    /**
     * 卷码图片
     */
    private String cardPic;

    /**
     * 卡券名称
     */
    private String cardName;

    /**
     * 门店Id
     */
    private Integer shopId;

    /**
     * 卡券属性 1大礼包卡券 2 置换券 3特卖券
     */
    private Byte cardStyle;

    /**
     * 创建类型:1 平台创建，2外部导入
     */
    private Byte createType;

    /**
     * 卡券类型枚举：代金券：CARD_CASH_COUPON，单品券：CARD_ITEM_COUPON；套餐券：CARD_MULTI_COUPON，寄存卡：CARD_STORAGE 旅游门票：CARD_TRAVEL_TICKERT
     */
    private String cardType;

    /**
     * 结算方式：1选择结算至制券方2选择结算至核销方
     */
    private Byte settlementType;

    /**
     * 适用商铺状态：1 仅适用本商铺，2 适用其他商铺
     */
    private Byte applyShopState;

    /**
     * 平台系统用户Id
     */
    private Integer suId;

    /**
     * 更新人Id
     */
    private Integer upSuId;

    /**
     * 卡券状态；1：草稿；2：待商家确认；3：可使用；4：不可用； 5：已下架；6:已失效，7：商家已经拒绝， 8.删除 
     */
    private Byte changeState;

    /**
     * 卡券状态；1：草稿；2：待商家确认；3：可使用；4：不可用； 5：已下架；6:已失效，7：商家已经拒绝，8.删除 
     */
    private Byte state;

    /**
     * 店铺是否确认过；0：否；1：是
     */
    private Boolean shopExamState;

    /**
     * 添加时间
     */
    private Long ctime;

    private static final long serialVersionUID = 1L;
}