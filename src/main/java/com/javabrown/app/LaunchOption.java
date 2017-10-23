package com.javabrown.app;

import com.javabrown.app.utils.StringUtils;
import java.util.Arrays;
import static com.javabrown.app.KeysI.*;

public enum LaunchOption {
  BROWSER("-b", true, new String[]{BROWSER_IE, BROWSER_CH, BROWSER_FF}, "Browser to be used in Test."), 
  TESTCASE_LOCATION("-l", false, null, "Path for the Testcases."), 
  NONE("", false, null, "No option supplied in CLI."), 
  ;
 
  private String _name;
  private boolean _hasDefinedParamValues;
  private String[] _validOptions;
  private String _desc;
  
  LaunchOption(String name, boolean hasDefinedParamValues, String[] validOptions, String desc) {
    _name = name;
	_hasDefinedParamValues = hasDefinedParamValues;
	_validOptions = validOptions;
	_desc = desc;
  }

  public String getName(){
    return _name;
  }

  public boolean hasDefinedParamValues(){
	return _hasDefinedParamValues;
  }
  
  public String[] getValidOptions(){
    return _validOptions;
  }
  
  public boolean isSuppliedParamValid(String arg){
	  String suppliedOption = this.getSuppliedOptionParams(arg);
	  if(_hasDefinedParamValues && Arrays.asList(_validOptions).contains(suppliedOption)){
		  return true;
	  }
	  
	  if(!_hasDefinedParamValues){
		  return true;
	  }
	  
	  return false;
  }
  
  public String getSuppliedOptionParams(String arg){
	  return arg.replace(_name, "");
  }
  
  public String getDesc(){
    return _desc;
  }
  
  public static LaunchOption find(String optionName) {//System.out.println(optionName);
    if (!StringUtils.isEmpty(optionName)) {
      for (LaunchOption opt : values()) {
        if (optionName.toUpperCase().startsWith(opt.getName())) {
          return opt;
        }
      }
    }

    return NONE;
  }

  public boolean typeOf(String optionName) {
    LaunchOption opt = find(optionName);
    if (this.equals(opt)) {
      return true;
    }
    return false;
  }

  public static String getAllOptions(){
     StringBuilder str = new StringBuilder();
     int index = 0;

     for(LaunchOption opt : values()){
        if(index > 0 ) {
           str.append(KeysI.COMMA_K).append(KeysI.SPACE_K);
        }

        str.append(opt);
        index++;
     }
     return String.format(" [ %s ]", str.toString());
  }
}