package com.onegini.mobile.testapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

  private SecureRandom secureRandom;
  private MyClass myClass;
  private int expectedLength;

  @Before
  public void setup() throws Exception {
    secureRandom = SecureRandom.getInstance("SHA1PRNG");
    myClass = new MyClass(secureRandom);

    final Random random = new Random();
    expectedLength = random.nextInt(200) + 1; // [1 - 200]
  }

  @Test
  public void test() {
    final String testedString = myClass.random(expectedLength);
    final Pattern expectedPattern = Pattern.compile("^[0-9]{" + expectedLength + "}$");

    assertThat(expectedPattern.matcher(testedString).find()).isTrue();
  }
}
