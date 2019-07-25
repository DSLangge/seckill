package com.example.seckill.dao;

import com.example.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface SeckillMapper {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新库存的记录行数
     */
    @Update(" UPDATE seckill SET number = number - 1 WHERE seckill_id = #{seckillId} " +
            "        AND start_time <![CDATA[ <= ]]> #{killTime} " +
            "        AND end_time >= #{killTime} AND number > 0 ")
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
    /**
     * 根据id查询秒杀的商品信息
     * @param seckillId
     * @return
     */
    @Select("SELECT *  FROM seckill WHERE seckill_id = #{seckillId}")
    Seckill queryById(@Param("seckillId") long seckillId);
    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    @Select("SELECT * FROM seckill ORDER BY create_time DESC limit #{offset},#{limit}")
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);


    void killByProcedure(Map<String,Object> paramMap);

}
