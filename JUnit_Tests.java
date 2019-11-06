package Generalized

import org.junit.Rule;
import org.junit.rules.Timeout;

public class JUnit_Tests {

    @Rule
    public Timeout globalTimeout = new Timeout(2);
}
