package cn.iocoder.yudao.module.system.dal.dataobject.material;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 物料 DO
 *
 * @author yejjr
 */
@TableName("system_material")
@KeySequence("system_material_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名字
     */
    private String materialname;
    /**
     * 类型
     */
    private String materialtype;
    /**
     * 描述
     */
    private String materialdescription;
    /**
     * 状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Byte materialstatus;

}
