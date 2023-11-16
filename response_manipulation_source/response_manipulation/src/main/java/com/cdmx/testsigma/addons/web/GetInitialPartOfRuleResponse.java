
/*Change Log: General Task | Function to Generate the initial part of rule response and store it in a runtime variable | 16/11/23 */


package com.cdmx.testsigma.addons.web;

import com.testsigma.sdk.WebAction;
import com.testsigma.sdk.ApplicationType;
import com.testsigma.sdk.annotation.Action;
import com.testsigma.sdk.annotation.TestData;
import com.testsigma.sdk.annotation.RunTimeData;
import lombok.Data;
import org.openqa.selenium.NoSuchElementException;

@Data
@Action(actionText = "Generate the initial part of rule response from (id testdata1, type testdata2, tx_id testdata3, flagged testdata4 ) and store in runtime variable",
        description = "This addon will Generate the initial part of rule response and store it in a runtime variable",
        applicationType = ApplicationType.WEB)

public class GetInitialPartOfRuleResponse extends WebAction {

  @TestData(reference = "testdata1")
  private com.testsigma.sdk.TestData testData1;
  
  @TestData(reference = "testdata2")
  private com.testsigma.sdk.TestData testData2;
  
  @TestData(reference = "testdata3")
  private com.testsigma.sdk.TestData testData3;
  
  @TestData(reference = "testdata4")
  private com.testsigma.sdk.TestData testData4;
  
  @TestData(reference = "variable")
  private com.testsigma.sdk.TestData runtimeVar;
  
  @RunTimeData
  private com.testsigma.sdk.RunTimeData runTimeData;

  @Override
  public com.testsigma.sdk.Result execute() throws NoSuchElementException {
    //Your Awesome code starts here
    logger.info("Initiating execution");
    com.testsigma.sdk.Result result = com.testsigma.sdk.Result.SUCCESS;
    try 
    {
       String var_id = testData1.getValue().toString();
       String var_type = testData2.getValue().toString();
       String var_tx_id = testData3.getValue().toString();
       String var_flagged = testData4.getValue().toString();

         //your custom code starts here
       String Result = "{\"id\":\"" + var_id + "\",\"type\":\"" + var_type + "\",\"tx_id\":\"" + var_tx_id + "\",\"flagged\":\"" + var_flagged +"\"";

       runTimeData.setKey(runtimeVar.getValue().toString());
       runTimeData.setValue(Result);
       
       result = com.testsigma.sdk.Result.SUCCESS;
       setSuccessMessage("Parameter Testdata variable with value "+ String.valueOf(Result) +" has been stored successfully in runtime variable "+ runtimeVar.getValue().toString());
    }
    catch (Exception e) 
    {
        result = com.testsigma.sdk.Result.FAILED;
        setErrorMessage(errorMessage);
	} 
    return result;
  }
}