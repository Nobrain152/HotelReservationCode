package bl.hotelbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 维护酒店基本信息
 * @author gyf
 *
 */
public class HotelInfoMaintain {
	private HotelInfoDataService hotelInfoData;
	private ResultMsg resultMsg;
	
	public HotelInfoMaintain(HotelInfoDataService hotelInfoData){
		this.hotelInfoData=hotelInfoData;
	}

	/**
	 * 输入酒店基本信息
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
		HotelInfoPO hotelInfoPO = (HotelInfoPO)VOPOchange.VOtoPO(hotelInfoVO);
		resultMsg = hotelInfoData.insert(hotelInfoPO);
		return resultMsg;
	}
	
	/**
	 * 检查信息是否符合标准
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
    	// TODO
    	return ResultMsg.SUCCESS;
    }
}
