package Framework.SeleniumRevision.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int startcount = 0;
	int maxcount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub


		if (startcount < maxcount) {

			startcount++;
			return true;
		}

		return false;
	}

}
