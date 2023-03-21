package cn.iocoder.yudao.module.system.service.material;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.material.MaterialDO;

public interface MaterialService {

    PageResult<MaterialDO> getMaterialPage(MaterialPageReqVO pageVO);
}
