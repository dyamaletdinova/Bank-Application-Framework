/**
 * 
 */
package finCo.operation;

import finCo.controller.ReportGeneratorController;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class PrintReport implements Operation{

	@Override
	public void execute() {
		ReportGeneratorController reportGeneratorController=ReportGeneratorController.getInstance();
		reportGeneratorController.generateReport();
	}


}
