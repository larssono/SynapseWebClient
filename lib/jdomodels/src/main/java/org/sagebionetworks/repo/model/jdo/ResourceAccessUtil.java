package org.sagebionetworks.repo.model.jdo;

import java.util.HashSet;
import java.util.Set;

import org.sagebionetworks.repo.model.AuthorizationConstants;
import org.sagebionetworks.repo.model.DatastoreException;
import org.sagebionetworks.repo.model.InvalidModelException;
import org.sagebionetworks.repo.model.ResourceAccess;
import org.sagebionetworks.repo.model.AuthorizationConstants.ACCESS_TYPE;
import org.sagebionetworks.repo.model.jdo.persistence.JDOResourceAccess;

public class ResourceAccessUtil {
	
	/**
	 * Create a new JDO from a DTO.
	 * @param dto
	 * @return
	 * @throws DatastoreException
	 * @throws InvalidModelException 
	 */
	public static JDOResourceAccess createJdoFromDto(ResourceAccess dto) throws DatastoreException, InvalidModelException{
		// Create a new JDO
		JDOResourceAccess jdo = new JDOResourceAccess();
		jdo.setAccessType(new HashSet<String>());
		updateJdoFromDto(jdo, dto);
		return jdo;
	}
	
	/**
	 * Update an existing JDO from a DTO.
	 * @param jdo
	 * @param dto
	 * @throws DatastoreException
	 * @throws InvalidModelException 
	 */
	public static void updateJdoFromDto(JDOResourceAccess jdo, ResourceAccess dto) throws DatastoreException, InvalidModelException{
		if(dto.getUserGroupId() == null) throw new InvalidModelException("UserGroup id cannot be null");
		jdo.setUserGroupId(KeyFactory.stringToKey(dto.getUserGroupId()));
		Set<String> jdoAccessTypes = new HashSet<String>();
		if(dto.getAccessType() != null){
			for (AuthorizationConstants.ACCESS_TYPE jdoAccessType : dto.getAccessType()) {
				jdoAccessTypes.add(jdoAccessType.name());
			}			
		}
		jdo.setAccessType(jdoAccessTypes);
		jdo.setId(dto.getId() == null ? null :KeyFactory.stringToKey(dto.getId()));
	}
	
	/**
	 * Create a new DTO from the JDO
	 * @param jdo
	 * @return
	 * @throws DatastoreException
	 */
	public static ResourceAccess createDtoFromJdo(JDOResourceAccess jdo) throws DatastoreException{
		ResourceAccess dto = new ResourceAccess();
		dto.setAccessType(new HashSet<ACCESS_TYPE>());
		dto.setUserGroupId(KeyFactory.keyToString(jdo.getUserGroupId()));
		dto.setId(jdo.getId() == null ? null : KeyFactory.keyToString(jdo.getId()));
		for(String typeString: jdo.getAccessType()){
			dto.getAccessType().add(ACCESS_TYPE.valueOf(typeString));
		}
		return dto;
	}

}