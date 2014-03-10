package com.octodecillion.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Target class used for testing PropertyAsserter.
 * 
 * @author jbetancourt
 *
 */
public class Target1 {
	private Logger logger = LoggerFactory.getLogger(Target1.class.getName());
    private String data;

    /** 
     * getter. 
     * @return data
     */
	public String getData() {
		logger.debug("getting data: '{}'", data);
		return data;
	}

	/** setter. 
	 * 
	 * @param data to set
	 */
	public void setData(final String data) {
		logger.debug("setting data: '{}'", data);
		this.data = data;
	}
}
