import request from '@/utils/request'

// 创建物料
export function createMaterial(data) {
  return request({
    url: '/system/material/create',
    method: 'post',
    data: data
  })
}

// 更新物料
export function updateMaterial(data) {
  return request({
    url: '/system/material/update',
    method: 'put',
    data: data
  })
}

// 删除物料
export function deleteMaterial(id) {
  return request({
    url: '/system/material/delete?id=' + id,
    method: 'delete'
  })
}

// 获得物料
export function getMaterial(id) {
  return request({
    url: '/system/material/get?id=' + id,
    method: 'get'
  })
}

// 获得物料分页
export function getMaterialPage(query) {
  return request({
    url: '/system/material/page',
    method: 'get',
    params: query
  })
}

// 导出物料 Excel
export function exportMaterialExcel(query) {
  return request({
    url: '/system/material/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
