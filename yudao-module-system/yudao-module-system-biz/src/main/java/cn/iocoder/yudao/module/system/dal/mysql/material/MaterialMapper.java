package cn.iocoder.yudao.module.system.dal.mysql.material;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.material.vo.MaterialPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.material.MaterialDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户组 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MaterialMapper extends BaseMapperX<MaterialDO> {

    default PageResult<MaterialDO> selectPage(MaterialPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MaterialDO>()
                //.likeIfPresent(MaterialDO::getMaterialname, reqVO.getMaterialname())
                //.eqIfPresent(MaterialDO::getMaterialstatus, reqVO.getMaterialstatus())
                //.betweenIfPresent(MaterialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MaterialDO::getId));
    }

    default List<MaterialDO> selectList(MaterialPageReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MaterialDO>()
                .likeIfPresent(MaterialDO::getMaterialname, reqVO.getMaterialname())
                .eqIfPresent(MaterialDO::getMaterialstatus, reqVO.getMaterialstatus())
                .betweenIfPresent(MaterialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MaterialDO::getId));
    }

}
