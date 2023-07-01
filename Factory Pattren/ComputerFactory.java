public class ComputerFactory {

		   public Computer getComputer(String computerType){
		      if(computerType == null){
		         return null;
		      }if(computerType.equalsIgnoreCase("SERVER")){
		         return new Server();	         
		      }else if(computerType.equalsIgnoreCase("PC")){
		         return new PC();  
		      }
		      return null;
	}
}