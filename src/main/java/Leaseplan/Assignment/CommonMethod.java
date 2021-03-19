
package Leaseplan.Assignment;

import java.io.IOException;

public class CommonMethod extends PreDefinedActions {

	private CommonMethod instance;

	public CommonMethod getInstance() throws IOException {
		if (instance == null) {
			synchronized (CommonMethod.class) {
				if (instance == null) {
					instance = new CommonMethod();
				}
			}
		}
		return instance;
		
	}
}