package com.fsd.stock.attachment;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class Test1 {

	@Test
	public void test1() throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdfmat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdfmat.parse("2019-06-08 10:30:00");
		System.out.println(date);

	}
	
	@Test
	public void contextLoads() {
		System.out.println(Long.parseLong("500112"));
	}

}
