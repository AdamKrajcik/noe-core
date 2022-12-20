package noe.tomcat

import noe.common.utils.Java
import noe.common.utils.Platform
import org.junit.Assume
import org.junit.BeforeClass

class BindingsTomcat8ConfiguratorIT extends BindingsTomcatConfiguratorIT {

  @BeforeClass
  public static void beforeClass() {
    Platform platform = new Platform()
    Assume.assumeFalse("JWS is not supported on HP-UX => skipping", platform.isHP())
    Assume.assumeTrue("JWS 3.0 is not supported on RHEL8+ => skipping", platform.isRHEL6() || platform.isRHEL7())
    Assume.assumeTrue("Tomcat from JWS 3.0 requires at least Java 1.7", Java.isJdk1xOrHigher('1.7'))

    loadTestProperties("/tomcat8-common-test.properties")
    prepareWorkspace()
  }
}
