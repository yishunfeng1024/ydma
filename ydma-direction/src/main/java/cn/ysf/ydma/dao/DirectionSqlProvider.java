package cn.ysf.ydma.dao;

import cn.ysf.ydma.entity.Direction;
import org.apache.ibatis.jdbc.SQL;

public class DirectionSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table direction
     *
     * @mbg.generated Wed Apr 29 16:28:46 CST 2020
     */
    public String insertSelective(Direction record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("direction");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table direction
     *
     * @mbg.generated Wed Apr 29 16:28:46 CST 2020
     */
    public String updateByPrimaryKeySelective(Direction record) {
        SQL sql = new SQL();
        sql.UPDATE("direction");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}