
/*Change Log: General Task | Function to Generate the rule response and store it in a runtime variable | 16/11/23 */


package com.cdmx.testsigma.addons.web;

import com.testsigma.sdk.WebAction;
import com.testsigma.sdk.ApplicationType;
import com.testsigma.sdk.annotation.Action;
import com.testsigma.sdk.annotation.TestData;
import com.testsigma.sdk.annotation.RunTimeData;
import lombok.Data;
import org.openqa.selenium.NoSuchElementException;

@Data
@Action(actionText = "Generate the rule response from (rule_id testdata1, rule_code testdata2, rule_name testdata3, rule_score testdata4, rule_flagged testdata5, rule_accepted testdata6, rule_accept_ids testdata7 ) and store in runtime variable",
        description = "This addon will Generate the rule response and store it in a runtime variable",
        applicationType = ApplicationType.WEB)

public class GetRuleResponse extends WebAction {

  @TestData(reference = "testdata1")
  private com.testsigma.sdk.TestData testData1;
  
  @TestData(reference = "testdata2")
  private com.testsigma.sdk.TestData testData2;
  
  @TestData(reference = "testdata3")
  private com.testsigma.sdk.TestData testData3;
  
  @TestData(reference = "testdata4")
  private com.testsigma.sdk.TestData testData4;
  
  @TestData(reference = "testdata5")
  private com.testsigma.sdk.TestData testData5;
  
  @TestData(reference = "testdata6")
  private com.testsigma.sdk.TestData testData6;
  
  @TestData(reference = "testdata7")
  private com.testsigma.sdk.TestData testData7;
  
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
    	String var_rule_id = testData1.getValue().toString();
        String var_rule_code = testData2.getValue().toString();
        String var_rule_name = testData3.getValue().toString();
        String var_rule_score = testData4.getValue().toString();
        String var_rule_flagged = testData5.getValue().toString();
        String var_rule_accepted = testData6.getValue().toString();
        String var_rule_accept_ids = testData7.getValue().toString();
     
        if(var_rule_accept_ids == null)
          var_rule_accept_ids = "[]";
        else
        {
          var_rule_accept_ids = testData7.getValue().toString();
          var_rule_accept_ids = '['+var_rule_accept_ids+']';
        }
     
        //your custom code starts here
       String Result = "{\"id\":" + var_rule_id + ",\"code\":\"" + var_rule_code + "\",\"name\":\"" + var_rule_name + "\",\"flagged\":" + var_rule_flagged + ",\"accepted\":" + var_rule_accepted + ",\"accept_ids\":" + var_rule_accept_ids + ",\"score\":" + var_rule_score + "}";
       
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