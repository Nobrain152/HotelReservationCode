package bl;


import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

import po.ContactPO;
import po.CustomerInfoPO;
import po.OrderPO;
import po.RoomInfoPO;
import po.UserInfoPO;
import util.OrderState;
import util.RoomState;
import util.RoomType;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;
import vo.UserInfoVO;

/** 
 * @author txin15 
 *
 */
public class VOPOchange {
	
	@SuppressWarnings("unchecked")
	public static Object POtoVO(Object o){
		
		if(o == null){
			return null;
		}
		
		Object vo = null;
		
		Class<? extends Object> poClass = o.getClass();
		
		Class<? extends Object> voClass = null;
		
		String poName = poClass.getName();
		
		String voName = "vo"+poName.substring(2,poName.length()-2)+"VO";
		
		Field[] field = poClass.getDeclaredFields();
		
		try {
			voClass = Class.forName(voName);
			vo = voClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ; i < field.length; i++){
			
			if(field[i].getType().toString().endsWith("ArrayList")
					&& !field[i].getGenericType().toString().endsWith("String>")){
				
				Type listType = field[i].getGenericType();
				Object list = null;
				
				try {
					 list = field[i].get(o);
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
				ArrayList<Object> polist = (ArrayList<Object>)list;
				
				String[] spl = listType.toString().split("<");
				
				String votName = "vo" + spl[1].substring(2, spl[1].length()-3)+"VO";

				Class<? extends Object> potmp = null;

				try {
					
					potmp = Class.forName(votName);

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				ArrayList<Object> volist = new ArrayList<Object>(polist.size());
				for(int j = 0 ; j < polist.size(); j++){
					volist.add(potmp.cast(POtoVO(polist.get(j))));
				}
				
				Field ft = null;
				try {
					ft = vo.getClass().getDeclaredField(field[i].getName());
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				ft.setAccessible(true);
				try {
					ft.set(vo, polist);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			else
//				try {
//					tmp = voClass.getDeclaredField(f.getName());
//				} catch (NoSuchFieldException e) {
//					e.printStackTrace();
//				} catch (SecurityException e) {
//					e.printStackTrace();
//				}
//				f.setAccessible(true);
//				tmp.setAccessible(true);
//				try {
//					tmp.set(vo, f.get(o));
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}
				setSuperFieldTmp(vo, o, field[i].getName());
			}
		return vo;
		
	}
	
	private static void setSuperFieldTmp(Object vo, Object o, String name) {
		
		Field field1 = getSuperFieldTmp(o.getClass(), name);
		if(name.endsWith("PO")) {
			name = name.substring(0, name.length()-2) + "VO";
		}
		Field field2 = getSuperFieldTmp(vo.getClass(), name);
		
		try {
			
			field1.setAccessible(true);
			Object val = field1.get(o);

			try {
				field2.setAccessible(true);
				if(val.getClass().toString().endsWith("PO")) {
					Object valtmp = POtoVO(val);
					field2.set(vo, valtmp);
				} else {
					field2.set(vo, val);
				}
			} catch(NullPointerException exception) {
				
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes") 
	private static Field getSuperFieldTmp(Class clazz, String name) {
		Field[] field = clazz.getDeclaredFields();
		
		for(Field f : field ){
			if(f.getName().equals(name)){
				return f;
			}
		}
		
		Class supClass = clazz.getSuperclass();
		if(supClass!=null){
			return getSuperFieldTmp(supClass, name);
		}
		return null;
	}
	

	@SuppressWarnings("unchecked")
	public static Object VOtoPO(Object o){
		
		if(o == null) {
			return null;
		}
		
		Object po = null;
		
		Class<? extends Object> voClass = o.getClass();
		
		Class<? extends Object> poClass = null;
		
		String voName = voClass.getName();
		
		String poName = "po"+voName.substring(2,voName.length()-2)+"PO";
		
		Field[] field = voClass.getDeclaredFields();
	
		try {		
			poClass = Class.forName(poName);
			po = poClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ; i < field.length; i++){
			
			if(field[i].getType().toString().endsWith("ArrayList")
					&& !field[i].getGenericType().toString().endsWith("String>")){
				
				Type listType = field[i].getGenericType();
				Object list = null;
				
				try {
					 list = field[i].get(o);
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
				ArrayList<Object> volist = (ArrayList<Object>)list;
				
				String[] spl = listType.toString().split("<");
				
				String potName = "po" + spl[1].substring(2, spl[1].length()-3)+"PO";

				Class<? extends Object> potmp = null;

				try {
					
					potmp = Class.forName(potName);

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				ArrayList<Object> polist = new ArrayList<Object>(volist.size());
				for(int j =0 ; j< volist.size(); j++){
					polist.add(potmp.cast(VOtoPO(volist.get(j))));
				}
				
				Field ft = null;
				try {
					ft = po.getClass().getDeclaredField(field[i].getName());
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				ft.setAccessible(true);
				try {
					ft.set(po, polist);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			else
				setSuperField(po, o, field[i].getName());
		}
		
		return po;
		
	}
	 
	private static void setSuperField(Object po,Object o, String name) {
		
		Field field1 = getSuperField(o.getClass(), name);
		if(name.endsWith("VO")) {
			name = name.substring(0, name.length()-2) + "PO";
		}
		Field field2 = getSuperField(po.getClass(), name);
		
		try {
			
			field1.setAccessible(true);
			Object val = field1.get(o);
			field2.setAccessible(true);

			try {
				if(val.getClass().toString().endsWith("VO")) {
					Object valtmp = VOtoPO(val);
					field2.set(po, valtmp);
				} else {
					field2.set(po, val);
				}
			} catch(NullPointerException exception) {
				
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	private static Field getSuperField(Class clazz, String name) {
		
		Field[] field = clazz.getDeclaredFields();
		
		for(Field f : field ){
			if(f.getName().equals(name)){
				return f;
			}
		}
		
		Class supClass = clazz.getSuperclass();
		if(supClass!=null){
			return getSuperField(supClass, name);
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		//OK
//		UserInfoVO vo = new UserInfoVO("12345", "67890", new ContactVO("18805156300", "151250132@smail.nju.edu.cn"));
//		UserInfoPO po = (UserInfoPO)VOtoPO(vo);
//		System.out.println(po.getContact().getEmailAddress());
		
		//OK
//		OrderVO vo = new OrderVO(new CustomerInfoVO("19954722", "ÌÆöÎ", 
//				new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
//				OrderState.UNEXECUTED, 99.9, "201612062014", "014", false, 
//				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", "2016-12-17 12:00",
//				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
//		OrderPO po = (OrderPO)VOtoPO(vo);
//		System.out.println(po.getOrderID());
		
		//OK
//		ContactVO vo = new ContactVO("18805156300", null);
//		ContactPO po = (ContactPO)VOtoPO(vo);
//		System.out.println(po.getPhoneNumber());

		//OK
//		ContactPO po = new ContactPO("18805156300",null);
//		ContactVO vo = (ContactVO)POtoVO(po);
//		System.out.println(vo.getPhoneNumber());
		
		//OK
//		OrderPO po = new OrderPO("201612062014",new CustomerInfoPO("19954722", "ÌÆöÎ", 
//		new ContactPO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
//		OrderState.UNEXECUTED, 99.9, "014", false, 
//		"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", "2016-12-17 12:00",
//		1, 1,new RoomInfoPO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"));
//		OrderVO vo = (OrderVO)POtoVO(po);
//		System.out.println(po.getOrderID());
		
		//OK
//		UserInfoPO po = new UserInfoPO("12345", "67890", new ContactPO("18805156300", "151250132@smail.nju.edu.cn"));
//		UserInfoVO vo = (UserInfoVO)POtoVO(po);
//		System.out.println(vo.getContact().getEmailAddress());
	}

}
