package com.example.seckill.dao;


import com.example.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessKilledMapper {

    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    @Insert("")
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
    /**
     * 根据秒杀商品ID查询明细SuccessKilled对象， 携带了Seckill秒杀产品对象
     * @param seckillId
     * @param userPhone
     * @return
     */
    @Select("")
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId, @Param("userPhone") long userPhone);
}
