/**
 * 
 */
package finCo.controller;

import finCo.operation.Operation;

/**
 * invoker
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class OperationController {
	
	private static OperationController operationControllerObj;
	private OperationController() {
	}

	public static OperationController getInstance() {
		
		if (operationControllerObj == null) {
			operationControllerObj = new OperationController();
		}
		return operationControllerObj;
	}

	public void submit(Operation operation){
		operation.execute();
	}
}
