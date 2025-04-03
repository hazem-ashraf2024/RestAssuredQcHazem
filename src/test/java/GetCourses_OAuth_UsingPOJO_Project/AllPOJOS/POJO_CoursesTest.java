package GetCourses_OAuth_UsingPOJO_Project.AllPOJOS;

import java.util.List;

public class POJO_CoursesTest {
    private List<WebAutomationPojoTest> webAutomation;
    private List<ApiPojoTest> api;
    private List<MobilePojoTest> mobile;

    public List<WebAutomationPojoTest> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomationPojoTest> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<ApiPojoTest> getApi() {
        return api;
    }

    public void setApi(List<ApiPojoTest> api) {
        this.api = api;
    }

    public List<MobilePojoTest> getMobile() {
        return mobile;
    }

    public void setMobile(List<MobilePojoTest> mobile) {
        this.mobile = mobile;
    }
}
