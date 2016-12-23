package bl;

import java.rmi.Remote;

import util.DataServiceType;
 /** 
 * 
 * @author txin 15 
 */
public abstract class BusinessController {
	
	protected DataServiceType myType;

	public abstract void reinitDataService(Remote dataService);	
	
}
