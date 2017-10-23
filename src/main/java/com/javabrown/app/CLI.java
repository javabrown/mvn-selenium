package com.javabrown.app;

import com.javabrown.app.utils.StringUtils;

public class CLI {
  private String _browserName;
  private String _testCaseLocation;
  private boolean _hasError;
  private String _errorMsg;

  public CLI(String[] args) {
    _hasError = false;
    _browserName = KeysI.BROWSER_CH;
    _testCaseLocation = ".";
    _errorMsg = "";

    for (int i = 0; i < args.length; i++) {
      LaunchOption opt = LaunchOption.find(args[i]);

      switch (opt) {
      case BROWSER:
        if (opt.isSuppliedParamValid(args[i])) {
          _browserName = opt.getSuppliedOptionParams(args[i]);
        } else {
          _errorMsg = String
              .format(
                  "Invalid parameter for option -b, valid browser options are [%s]\n",
                  StringUtils.stringify(opt.getValidOptions()));
          _hasError = true;
        }
        break;

      case TESTCASE_LOCATION:
        _testCaseLocation = opt.getSuppliedOptionParams(args[i]);

        if (StringUtils.isEmpty(_testCaseLocation)) {
          _errorMsg = "Invalid parameter with option -l. Sample -lc:\\test-cases\\";
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

  public String getTestCaseLocation() {
    return _testCaseLocation;
  }

  public boolean hasError() {
    return _hasError;
  }

  public String getErrorMsg() {
    return _errorMsg;
  }
}