package se.orbilius.service;


public class ServiceFactory {
	
	public Service getService(ServiceIOArguments args) throws NoSuchServiceException{

		if(GeocoderService.NAME.equals(args.service)){
			return new GeocoderService();
		} 
		if(EmptyService.NAME.equals(args.service)){
			return new EmptyService();
		}
		
		if(DataAugmenterService.NAME.equals(args.service)){
			return new DataAugmenterService();
		}
		
		throw new NoSuchServiceException("No service with name " + args.service);
	}
}
