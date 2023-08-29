package suits;


import rbo.LoginRBOWithUploadFile;
import loginTFGUA.LoginWithUploadFile;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({//формування списку класів, які потрібно запустити
        LoginWithUploadFile.class, LoginRBOWithUploadFile.class})
public class SmokeSuite {


}
