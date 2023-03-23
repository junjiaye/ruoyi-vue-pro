package cn.iocoder.yudao.module.system.controller.admin.material;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import cn.iocoder.yudao.module.system.controller.admin.group.vo.GroupCreateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.group.vo.GroupExcelVO;
import cn.iocoder.yudao.module.system.controller.admin.group.vo.GroupExportReqVO;
import cn.iocoder.yudao.module.system.controller.admin.group.vo.GroupUpdateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.*;
import cn.iocoder.yudao.module.system.convert.group.GroupConvert;
import cn.iocoder.yudao.module.system.convert.material.MaterialConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.group.GroupDO;
import cn.iocoder.yudao.module.system.dal.dataobject.material.MaterialDO;
import cn.iocoder.yudao.module.system.service.material.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

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

    @PostMapping("/create")
    @Operation(summary = "创建物料")
    @PreAuthorize("@ss.hasPermission('system:material:create')")
    public CommonResult<Long> createMaterial(@Valid @RequestBody MaterialCreateReqVO createReqVO) {
        return success(materialService.createMaterial(createReqVO));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除物料")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:material:delete')")
    public CommonResult<Boolean> deleteGroup(@RequestParam("id") Long id) {
        materialService.deleteMaterial(id);
        return success(true);
    }


    @PutMapping("/update")
    @Operation(summary = "更新物料")
    @PreAuthorize("@ss.hasPermission('system:material:update')")
    public CommonResult<Boolean> updateMaterial(@Valid @RequestBody MaterialUpdateReqVO updateReqVO) {
        materialService.updateMaterial(updateReqVO);
        return success(true);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出物料 Excel")
    @PreAuthorize("@ss.hasPermission('system:material:export')")
    @OperateLog(type = EXPORT)
    public void exportMaterialExcel(@Valid MaterialExportReqVO exportReqVO,
                                 HttpServletResponse response) throws IOException {
        List<MaterialDO> list = materialService.getMaterialList(exportReqVO);
        // 导出 Excel
        List<MaterialExcelVO> datas = MaterialConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "物料.xls", "数据", MaterialExcelVO.class, datas);
    }

    public void setMaterialService(MaterialService materialService) {
        this.materialService = materialService;
    }
}
