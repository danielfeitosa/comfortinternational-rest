package com.sponsorshiphub.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	public static <T> T mapear(Object obj, Class<T> classe){
		return modelMapper.map(obj, classe);
	}

}
