package bl.orderbl;

import java.util.ArrayList;

import blservice.orderblservice.OrderOnUserBLService;
import util.OrderMsg;
import util.ResultMsg;
import vo.OrderOnUserVO;

public class OrderOnUserController implements OrderOnUserBLService{

	/* (non-Javadoc)
	 * @see blservice.orderblservice.OrderOnUserBLService#personalOrderScan()
	 */
	public ArrayList<OrderOnUserVO> personalOrderScan() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see blservice.orderblservice.OrderOnUserBLService#personalOrderCancel(vo.OrderOnUserVO)
	 */
	public ResultMsg personalOrderCancel(OrderOnUserVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see blservice.orderblservice.OrderOnUserBLService#personalOrderDetail(vo.OrderOnUserVO)
	 */
	public OrderMsg personalOrderDetail(OrderOnUserVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see blservice.orderblservice.OrderOnUserBLService#createOrder(vo.OrderOnUserVO)
	 */
	@Override
	public void createOrder(OrderOnUserVO orderVO) {
		// TODO Auto-generated method stub
		
	}

}
