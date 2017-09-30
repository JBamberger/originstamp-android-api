package org.originstamp.originstampandroidclient;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {HashModelTest.class, ValidationModelTest.class, OriginStampAPITest.class}
)
public class TestSuite {
}
