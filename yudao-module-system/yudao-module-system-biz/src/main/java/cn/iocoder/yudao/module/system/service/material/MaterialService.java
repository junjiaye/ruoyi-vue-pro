package cn.iocoder.yudao.module.system.service.material;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.group.vo.GroupExportReqVO;
import cn.iocoder.yudao.module.system.controller.admin.group.vo.GroupUpdateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialCreateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialExportReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialUpdateReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.group.GroupDO;
import cn.iocoder.yudao.module.system.dal.dataobject.material.MaterialDO;

import javax.validation.Valid;
import java.util.List;

public interface MaterialService {

    PageResult<MaterialDO> getMaterialPage(MaterialPageReqVO pageVO);

    Long createMaterial(@Valid MaterialCreateReqVO createReqVO);

    void deleteMaterial(Long id);

    void updateMaterial(@Valid MaterialUpdateReqVO updateReqVO);

    List<MaterialDO> getMaterialList(MaterialExportReqVO exportReqVO);
}
