package presentacio;

import logica.LogicaFacade;

public class BLServiceLocator {
  private LogicaFacade service;
  private static BLServiceLocator instance;

  private BLServiceLocator() throws Exception{
  }
  
  public static final BLServiceLocator getInstance() {
	  if (instance==null) {
		  try {
			  instance = new BLServiceLocator();
		  } catch (Exception e) {
			  
		  }
		 	  
	  }
	  return instance;
  }

  public LogicaFacade getLocator() throws Exception {
    if (service == null) {
		try{
//			Class c = Class.forName("logica.LogicaFacade");
//			service = (LogicaFacade) c.newInstance();
			service = new LogicaFacade();
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
    return service;
  }
}
