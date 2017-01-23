/**
 * 
 */
package com.preschool;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.preschool.search.CustomSearch;

/**
 * @author francis
 *
 */

@RunWith(JUnit4.class)
public class CustomSearchTest {
	
	private final String cx = "014723624719242706501:ky6zn2teax4";
    private final String apiKey = "AIzaSyBFnKBQPESdi2sP1twKp59-3mBscTVw99k";
    CustomSearch $;
    
    @Before
    public void setUp() throws Exception {
        $ = new CustomSearch(cx, apiKey, 2);
    }

}
