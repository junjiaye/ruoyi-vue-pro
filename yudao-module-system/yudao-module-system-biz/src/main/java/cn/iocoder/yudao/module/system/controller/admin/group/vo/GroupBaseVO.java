package cn.iocoder.yudao.module.system.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 用户组 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class GroupBaseVO {

    @Schema(description = "名字", required = true, example = "赵六")
    @NotNull(message = "名字不能为空")
    private String name;

    @Schema(description = "描述", example = "你猜")
    private String description;

    @Schema(description = "状态", required = true, example = "1")
    @NotNull(message = "状态不能为空")
    private Byte status;

}
