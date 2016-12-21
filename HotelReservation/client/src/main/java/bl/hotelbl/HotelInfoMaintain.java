package bl.hotelbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * ά���Ƶ������Ϣ
 * @author �ܳ�
 *
 */
public class HotelInfoMaintain {
	private HotelInfoDataService hotelInfoData;
	private ResultMsg resultMsg;
	
	public HotelInfoMaintain(HotelInfoDataService hotelInfoData){
		this.hotelInfoData=hotelInfoData;
	}

	/**
	 * �޸ľƵ������Ϣ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
		HotelInfoPO hotelInfoPO = (HotelInfoPO)VOPOchange.VOtoPO(hotelInfoVO);
		if(hotelInfoPO.getHotelID()==null){
			return ResultMsg.NONEID;
		}
		HotelInfoPO past=hotelInfoData.find(hotelInfoVO.getHotelID());
		if(hotelInfoPO.getName()!=null){
			past.setName(hotelInfoPO.getName());
		}
		if(hotelInfoPO.getLevel()!=0){
			past.setLevel(hotelInfoPO.getLevel());
		}
		if(hotelInfoPO.getSP()!=0){
			past.setSP(hotelInfoPO.getSP());
		}
		if(hotelInfoPO.getAddress()!=null){
			past.setAddress(hotelInfoPO.getAddress());
		}
		if(hotelInfoPO.getArea()!=null){
			past.setArea(hotelInfoPO.getArea());
		}
		if(hotelInfoPO.getIntroduction()!=null){
			past.setIntroduction(hotelInfoPO.getIntroduction());
		}
		if(hotelInfoPO.getFacility()!=null){
			past.setFacility(hotelInfoPO.getFacility());
		}
		resultMsg = hotelInfoData.update(past);
		return resultMsg;
	}
	
	/**
	 * �����Ϣ�Ƿ���ϱ�׼
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
    	if((hotelInfoVO.getAddress()==null)||(hotelInfoVO.getArea()==null)||(hotelInfoVO.getName()==null)||(hotelInfoVO.getFacility()==null)||(hotelInfoVO.getLevel()<0)||(hotelInfoVO.getSP()<=0)){
    		return ResultMsg.INCOMPLETE_INFO;
    	}
    	else{
    		return ResultMsg.SUCCESS;
    	}
    }
    
    /**
     * ��ӾƵ�
     * @param hotelInfoVO
     * @return
     */
    public String addHotel(HotelInfoVO hotelInfoVO)throws RemoteException{
        if(checkInfo(hotelInfoVO)==ResultMsg.SUCCESS){
        	return hotelInfoData.insert((HotelInfoPO)VOPOchange.VOtoPO(hotelInfoVO));
        }
		return null;
    }
}
