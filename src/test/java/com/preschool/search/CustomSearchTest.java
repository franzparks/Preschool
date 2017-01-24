/**
 * 
 */
package com.preschool.search;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.preschool.domain.Result;
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
        $ = new CustomSearch(cx, apiKey, 10);
    }
    
    //@Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        new CustomSearch(null, null,0);
    }
    
    //@Test
    public void testApiKeyAvailable() {
        assertNotNull($.getApiKey());
    }
    
    @Test
    public void testResultAvailable() {
        Result result = $.execute("Android");
        assertNotNull(result);
        System.out.println("total : "+result.getSearchInformation().getTotalResults());
        System.out.println("total------------------ : "+result);
        assertTrue(Long.valueOf(result.getSearchInformation().getTotalResults()) > 0);
    }
    
    //@Test
    public void testMultipleKeywords() {
        Result result = $.execute("bob marley");
        assertNotNull(result);
        assertTrue(Long.valueOf(result.getSearchInformation().getTotalResults()) > 0);
    }
    
    //@Test
    public void testSearchTime() {
        Result result = $.execute("android");
        assertTrue(result.getSearchInformation().getSearchTime() > 0);
    }
    
    //@Test
    public void testSetTotalResult() {
        int total = 15;
        CustomSearch search = new CustomSearch(cx, apiKey, total);
        Result result = search.execute("Preschools");
        assertEquals(total, result.getItems().size());
    }
    
    //@Test
    public void testSetTotalResultLesserThanDefault() {
        int total = 7;
        CustomSearch search = new CustomSearch(cx, apiKey, total);
        Result result = search.execute("Android");
        assertEquals(total, result.getItems().size());
    }


}
