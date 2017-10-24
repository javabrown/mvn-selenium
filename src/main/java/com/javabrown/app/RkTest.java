//package com.javabrown.app;
//
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//public class RkTest {
//  @Test
//  public void unexpected() {
//      Result result = JUnitCore.runClasses(Unexpected.class);
//      Failure failure = result.getFailures().get(0);
//      String message = failure.getMessage();
//      assertTrue(message.contains("expected<java.lang.Exception> but was<java.lang.Error>"));
//      assertEquals(Error.class, failure.getException().getCause().getClass());
//  }
//}
