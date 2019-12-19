package Practice;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	
	
	public Object[][] getInputData() {
		
		Object [][]obj=new Object[][]
				{
			
			{"hello"},{"+=@#/"}
			
			
				};
		
		
		
		return obj;
		
		
		
		
	}

}
