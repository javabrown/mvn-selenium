package com.javabrown.app;

import com.javabrown.app.utils.StringUtils;

public class CLI {
  private String _browserName;
  private String _domain;
  private String _language;
  private String _testCasePath;
  private boolean _hasError;
  private String _errorMsg;

  public CLI(String[] args) {
    this.initWithDefault();
    this.processCliInput(args);
  }
  
  private void initWithDefault(){
    _hasError = false;
    _browserName = KeysI.BROWSER_CH;
    _domain = KeysI.DOMAIN_OSX;
    _language = KeysI.LANGUAGE_EN;
    
    _testCasePath = ".";
    _errorMsg = "";
  }
  
  private void processCliInput(String[] args){
    for (int i = 0; i < args.length; i++) {
      LaunchOption opt = LaunchOption.find(args[i]);

      switch (opt) {
        case BROWSER:
          if (opt.isSuppliedParamValid(args[i])) {
            _browserName = opt.getSuppliedOptionParams(args[i]);
          } else {
            _errorMsg = String.format(
               "Invalid browser with option -b, valid browsers values: [%s]\n",
               StringUtils.stringify(opt.getValidOptions()));
            _hasError = true;
          }
          break;
  
        case TESTCASE_PATH:
          _testCasePath = opt.getSuppliedOptionParams(args[i]);
  
          if (StringUtils.isEmpty(_testCasePath)) {
            _errorMsg = "Invalid path provided with option -p. "
                + "Valid sample -pc:\\test-cases\\";
            _hasError = true;
          }
          break;
  
        case DOMAIN:
          if (opt.isSuppliedParamValid(args[i])) {
            _domain = opt.getSuppliedOptionParams(args[i]);
          } else {
            _errorMsg = String.format(
                 "Invalid Domain with option -d, valid domains:[%s]\n",
                 StringUtils.stringify(opt.getValidOptions()));
            _hasError = true;
          }
          break;

        case LANGUAGE:
          if (opt.isSuppliedParamValid(args[i])) {
            _language = opt.getSuppliedOptionParams(args[i]);
          } else {
            _errorMsg = String.format(
               "Invalid Language provided with option -l, "
               + "valid languages:[%s]\n",
               StringUtils.stringify(opt.getValidOptions()));
            _hasError = true;
          }
          break;          
          
          default:
      }
    }
    
  }

  public String getBrowserName() {
    return _browserName;
  }

  public String getTestCasePath() {
    return _testCasePath;
  }
  
  public String getDomain(){
    return _domain;
  }
  
  public String getLanguage(){
    return _language;
  }

  public boolean hasError() {
    return _hasError;
  }

  public String getErrorMsg() {
    return _errorMsg;
  }
}