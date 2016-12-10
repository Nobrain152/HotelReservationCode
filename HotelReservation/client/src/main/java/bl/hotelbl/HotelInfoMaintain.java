package bl.hotelbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 维护酒店基本信息
 * @author 曹畅
 *
 */
public class HotelInfoMaintain {
	private HotelInfoDataService hotelInfoData;
	private ResultMsg resultMsg;
	
	public HotelInfoMaintain(HotelInfoDataService hotelInfoData){
		this.hotelInfoData=hotelInfoData;
	}

	/**
	 * 修改酒店基本信息
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
		HotelInfoPO hotelInfoPO = (HotelInfoPO)VOPOchange.VOtoPO(hotelInfoVO);
		resultMsg = hotelInfoData.update(hotelInfoPO);
		return resultMsg;
	}
	
	/**
	 * 检查信息是否符合标准
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
    	if((hotelInfoVO.getAddress()==null)||(hotelInfoVO.getArea()==null)||(hotelInfoVO.getName()==null)||(hotelInfoVO.getFacility()==null)){
    		return ResultMsg.FAIL;
    	}
    	else{
    		return ResultMsg.SUCCESS;
    	}
    }
    
    /**
     * 添加酒店
     * @param hotelInfoVO
     * @return
     */
    public String addHotel(HotelInfoVO hotelInfoVO)throws RemoteException{
    	try {
			return hotelInfoData.insert((HotelInfoPO)VOPOchange.VOtoPO(hotelInfoVO));
		} catch (RemoteException e) {
			return null;
		}
    }
}
