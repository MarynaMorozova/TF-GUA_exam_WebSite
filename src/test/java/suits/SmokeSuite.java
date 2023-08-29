package suits;


import RBO.LoginRBOWithUploadFile;
import loginTFGUA.LoginWithUploadFile;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginWithUploadFile.class, LoginRBOWithUploadFile.class})
public class SmokeSuite {


}
