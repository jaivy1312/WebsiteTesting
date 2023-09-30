package POMproject.websiteTestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry1 implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count=0;
		int max=2;
		if(count<=max)
		{
			count ++;
			return true;
			
		}
		return false;
	}

}
