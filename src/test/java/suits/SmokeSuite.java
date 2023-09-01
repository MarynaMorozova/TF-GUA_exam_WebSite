package suits;


import rbo.LoginRBOWithUploadFile;
import loginTFGUA.LoginWithUploadFile;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import steps.Step3Test;


@RunWith(Suite.class)
@Suite.SuiteClasses({//формування списку класів, які потрібно запустити
        LoginWithUploadFile.class, LoginRBOWithUploadFile.class, Step3Test.class})
public class SmokeSuite {


}
