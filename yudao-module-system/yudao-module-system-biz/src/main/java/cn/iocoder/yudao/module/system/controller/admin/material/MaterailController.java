package cn.iocoder.yudao.module.system.controller.admin.material;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialRespVO;
import cn.iocoder.yudao.module.system.convert.material.MaterialConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.material.MaterialDO;
import cn.iocoder.yudao.module.system.service.material.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 物料信息")
@RestController
@RequestMapping("/system/material")
@Validated
public class MaterailController {
    @Resource
    private MaterialService materialService;

    @GetMapping("/page")
    @Operation(summary = "获得物料分页")
    @PreAuthorize("@ss.hasPermission('system:material:query')")
    public CommonResult<PageResult<MaterialRespVO>> geMterialPage(@Valid MaterialPageReqVO pageVO) {
        PageResult<MaterialDO> pageResult = materialService.getMaterialPage(pageVO);
        return success(MaterialConvert.INSTANCE.convertPage(pageResult));
    }
}
