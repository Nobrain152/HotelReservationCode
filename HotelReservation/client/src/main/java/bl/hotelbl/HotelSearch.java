package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.hotelblservice.RoomAddBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import vo.HotelInfoVO;
import vo.RoomInfoVO;

/**
 * ËÑË÷¾Æµê
 * @author ²Ü³©
 *
 */
public class HotelSearch {
	private HotelInfoDataService hotelData;
	public ArrayList<HotelInfoVO> hotelList;
	private RoomAddBLService room;
	private BusinessLogicDataFactory factory;
	
	public HotelSearch(HotelInfoDataService hotelDataService){
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
		factory=BusinessLogicDataFactory.getFactory();
		room=factory.getRoomAddBLService();
	}

	/**
	 * Ñ¡ÔñÌõ¼þ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelInfoVO,RoomInfoVO roomin) throws RemoteException{
		ArrayList<HotelInfoPO> pos;
		pos=hotelData.findByAreaAndCircle(hotelInfoVO.getAddress(),hotelInfoVO.getArea());
		if(hotelInfoVO.getName()!=null){
			for(int i=0;i<pos.size();i++){
				if(!pos.get(i).getName().equals(hotelInfoVO.getName())){
					pos.remove(i);
				}
			}
		}
		else{
			if(hotelInfoVO.getLevel()!=0){
				for(int i=0;i<pos.size();i++){
					HotelInfoPO po=pos.get(i);
					if(po.getLevel()!=hotelInfoVO.getLevel()){
						pos.remove(i);
					}
				}
			}
			double up=hotelInfoVO.getUp();
			double down=hotelInfoVO.getDown();
			if((Math.abs(up-0.0)<0.1)||(Math.abs(down-0.0)<0.1)){
				for(int i=0;i<pos.size();i++){
					HotelInfoPO po=pos.get(i);
					if((po.getScore()<down)||(po.getScore()>up)){
						pos.remove(i);
					}
				}
			}
			
			if(roomin!=null){
				for(int i=0;i<pos.size();i++){
					String hotelid=pos.get(i).getHotelID();
					ArrayList<RoomInfoVO> r=room.HotelRoomSearch(hotelid);
					for(int j=0;j<r.size();j++){
						if(roomin.getPrice()!=0){
							if(r.get(j).getPrice()!=roomin.getPrice()){
								pos.remove(i);
								break;
							}
						}
						if(roomin.getType()!=null){
							if(r.get(j).getType()!=roomin.getType()){
								pos.remove(i);
								break;
							}
						}
					}
					
				}
			}
		}
		
		
		for(HotelInfoPO p:pos){
			hotelList.add((HotelInfoVO)VOPOchange.POtoVO(p));
		}
		return hotelList;
	}
	
}
