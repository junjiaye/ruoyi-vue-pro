package cn.iocoder.yudao.module.system.controller.admin.material.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户组 Excel 导出 Request VO，参数和 GroupPageReqVO 是一致的")
@Data
public class MaterialExportReqVO {

    @Schema(description = "名字", example = "赵六")
    private String materialname;

    @Schema(description = "类型", example = "赵六")
    private String materialtype;

    @Schema(description = "状态", example = "1")
    private Byte materialstatus;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
