package cn.iocoder.yudao.module.system.controller.admin.material.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * 用户组 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MaterialExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("物料名字")
    private String materialname;

    @ExcelProperty(value = "物料类型",converter = DictConvert.class)
    @DictFormat("system_material_type")
    private String materialtype;

    @ExcelProperty("物料描述")
    private String materialdescription;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte materialstatus;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
