package suits;

import RBO.LoginRBOWithUploadFile;
import categories.SmokeTestFilter;
import loginTFGUA.LoginWithUploadFile;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
//@Categories.IncludeCategory(SmokeTestFilter.class)
@Suite.SuiteClasses({
        LoginWithUploadFile.class, LoginRBOWithUploadFile.class

})
public class SmokeSuiteWithCategories {
}
