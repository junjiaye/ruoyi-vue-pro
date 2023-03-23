package cn.iocoder.yudao.module.system.service.material;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialCreateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialExportReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialUpdateReqVO;
import cn.iocoder.yudao.module.system.convert.group.GroupConvert;
import cn.iocoder.yudao.module.system.convert.material.MaterialConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.group.GroupDO;
import cn.iocoder.yudao.module.system.dal.dataobject.material.MaterialDO;
import cn.iocoder.yudao.module.system.dal.mysql.material.MaterialMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

@Service
@Validated
public class MaterialServiceImpl implements MaterialService{
    @Resource
    private MaterialMapper materialMapper;
    @Override
    public PageResult<MaterialDO> getMaterialPage(MaterialPageReqVO pageVO) {
        return materialMapper.selectPage(pageVO);
    }


    @Override
    public Long createMaterial(MaterialCreateReqVO createReqVO) {
        // 插入
        MaterialDO material = MaterialConvert.INSTANCE.convert(createReqVO);
        materialMapper.insert(material);
        // 返回
        return material.getId();
    }

    @Override
    public void deleteMaterial(Long id) {
        // 校验存在
        validateGroupExists(id);
        // 删除
        materialMapper.deleteById(id);
    }

    @Override
    public void updateMaterial(@Valid MaterialUpdateReqVO updateReqVO) {
        // 校验存在
        validateGroupExists(updateReqVO.getId());
        // 更新
        MaterialDO updateObj = MaterialConvert.INSTANCE.convert(updateReqVO);
        materialMapper.updateById(updateObj);
    }

    @Override
    public List<MaterialDO> getMaterialList(MaterialExportReqVO exportReqVO) {
        return materialMapper.selectList(exportReqVO);
    }

    private void validateGroupExists(Long id) {
        if (materialMapper.selectById(id) == null) {
            throw exception(MATERIAL_NOT_EXISTS);
        }
    }
}
