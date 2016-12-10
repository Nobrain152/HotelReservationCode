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
		resultMsg = hotelInfoData.update(hotelInfoPO);
		return resultMsg;
	}
	
	/**
	 * �����Ϣ�Ƿ���ϱ�׼
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
     * ��ӾƵ�
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
