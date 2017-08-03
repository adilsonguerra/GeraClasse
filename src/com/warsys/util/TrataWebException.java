package com.warsys.util;

import javax.servlet.ServletException;

public class TrataWebException extends ServletException {

  public TrataWebException() {
    super();
  }

  public TrataWebException(String arg0) {
    super(arg0);
  }

  public TrataWebException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public TrataWebException(Throwable arg0) {
    super(arg0);
  }

}
