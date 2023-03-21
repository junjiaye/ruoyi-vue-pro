package cn.iocoder.yudao.module.system.service.material;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.material.MaterialDO;
import cn.iocoder.yudao.module.system.dal.mysql.material.MaterialMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
@Service
@Validated
public class MaterialServiceImpl implements MaterialService{
    @Resource
    private MaterialMapper materialMapper;
    @Override
    public PageResult<MaterialDO> getMaterialPage(MaterialPageReqVO pageVO) {
        return materialMapper.selectPage(pageVO);
    }
}
