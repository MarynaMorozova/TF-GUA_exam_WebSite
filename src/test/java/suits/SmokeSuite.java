package suits;

import rbo.LoginRBOWithUploadFile;
import loginTFGUA.LoginWithUploadFile;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import steps.Step2Test;
import steps.Step3Test;

@RunWith(Suite.class)
@Suite.SuiteClasses({//формування списку класів, які потрібно запустити
        LoginWithUploadFile.class, LoginRBOWithUploadFile.class, Step2Test.class, Step3Test.class})
public class SmokeSuite {
}