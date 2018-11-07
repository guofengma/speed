package com.speed.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.speed.dao.MenuDao;
import com.speed.model.AdminRefRole;
import com.speed.model.Entity;
import com.speed.model.Entity.AdminRefRoleCriteria;
import com.speed.model.Entity.MenuCriteria;
import com.speed.model.Entity.RoleRefMenuCriteria;
import com.speed.model.Entity.Value;
import com.speed.model.Menu;
import com.speed.model.RoleRefMenu;
import com.speed.service.AdminRefRoleService;
import com.speed.service.MenuService;
import com.speed.service.RoleRefMenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Integer, Menu> implements MenuService {
	
	@Autowired
	private MenuDao dao;
	
	@Autowired
	private AdminRefRoleService adminRefRoleService;
	
	@Autowired
	private RoleRefMenuService roleRefMenuService;
	
	@Override
	public List<Menu> getMenuListByAdmin(int adminId,String name) {
		// 1.根据adminid获取该用户的角色列表
		// admin ---> role
		AdminRefRoleCriteria adminRefRoleCriteria =  new AdminRefRoleCriteria();
		adminRefRoleCriteria.setAdminid(Value.eq(adminId));
		List<AdminRefRole> list = adminRefRoleService.selectList(adminRefRoleCriteria);
		// 组装成一个Integer数组，用于查询
		if (list.size() == 0) {
			return new ArrayList<Menu>();
		}
		List<Integer> roleIds = new ArrayList<Integer>();
		for (AdminRefRole ar : list) {
			roleIds.add(ar.getRoleid());
		}
		
		// 2.根据该用户的角色列表来获取每个角色所拥有的菜单权限
		// role ---> menu
		List<Menu> menus = dao.getMenusByRoleIds(roleIds);
		
		
		//根据条件查询的菜单，取两个集合的交集
				if(name!=null&&!name.equals("")){
					MenuCriteria criteria=new MenuCriteria();			
					criteria.setName(Entity.Value.like(name+"%"));
					//criteria.setImgName(Entity.Value.like("%"+img.getImgName()+"%"));		
					List<Menu> menus1=selectList(criteria);
					for(int i=0;i<menus1.size();i++){			
						//获取上级菜单
						if(menus1.get(i)!=null&&menus1.get(i).getParentId()!=0){
							Menu menu=selectOne(menus1.get(i).getParentId());
							menus1.add(menu);
							//获取上上级
							if(menu!=null&&menu.getParentId()!=0){
								Menu menu2=selectOne(menu.getParentId());
								menus1.add(menu2);
							}
						}				
					}
					menus.retainAll(menus1);
				}
		
		
		
		System.out.println("menus size" + menus.size());
		// 4.遍历菜单做成树形格式
		// 0是最高级节点
		List<Menu> roots = getChilds(menus, 0);
		dg(menus,roots);
		return roots;
	}

	// 递归所有菜单
		public void dg(List<Menu> allMenus,List<Menu> list){
			for(Menu menu : list){
				int id = menu.getId();
				List<Menu> childs = getChilds(allMenus, id);
				if(!childs.isEmpty()){
					menu.setList(childs);
					dg(allMenus,childs);
				}
			}
		}
		
		// 根据parentId 获取所有子节点
		public List<Menu> getChilds(List<Menu> list , int parentId){
			List<Menu> childs = new ArrayList<Menu>();
			for(Menu menu : list){
				int _parentId = menu.getParentId();
				if(parentId ==_parentId){
					childs.add(menu);
				}
			}
			return childs;
		}
		
	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = selectAll();
		List<Menu> roots = getChilds(menus, 0);
		dg(menus,roots);
		return roots;
	}

	@Override
	public List<RoleRefMenu> getMenuListByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getMenuListByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}