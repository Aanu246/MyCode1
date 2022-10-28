package com.eazyschool.audit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class EazySchoolInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		Map<String, String> eazyMap = new HashMap<String,String>();
		eazyMap.put("App Name", "Eazy School");
		eazyMap.put("App Description", "Eazy School web Application for Students and Admin");
		eazyMap.put("App Version","1.0.0");
		eazyMap.put("Contact email", "aanukayode2@gmail.com");
		eazyMap.put("Contact Mobile","09063074615");
		builder.withDetail("eazyschool-info",eazyMap);
		
	}

}
